package com.ade.concurrent.code.customize

import java.util
import java.util._
import java.util.concurrent.atomic.{AtomicBoolean, AtomicInteger}
import java.util.concurrent.locks.ReentrantLock
import java.util.concurrent.{BlockingQueue, ConcurrentHashMap, TimeUnit}

import scala.collection.JavaConverters._

/**
 *
 * @param miniSize          最小现场池，也叫核心线程数
 * @param maxSize           最大线程数
 * @param keepAliveTime     线程需要被回收的时间
 * @param unit
 * @param workQueue         存放线程的阻塞队列
 * @param notify
 */
class CustomThreadPoo (miniSize: Int, maxSize: Int, keepAliveTime: Long, unit: TimeUnit,
                       workQueue: BlockingQueue[Runnable], notify: Notify) {

    private val lock = new ReentrantLock()

    /**
     * 存放线程池
     */
    private val workers: Set[Worker] = new ConcurrentHashSet()
    /**
     * 是否关闭线程池标志
     */
    private val isShutDown = new AtomicBoolean(false)
    /**
     * 提交到线程池的任务总数
     */
    private val totalTask = new AtomicInteger()
    /**
     * 线程池任务全部执行完毕后的通知组件
     */
    private val shutDownNotify = new Object

    /**
     * 有返回值
     * @param callable
     * @tparam T
     * @return
     */
    def submit[T](callable: Callable[T]): Future[T] = {
        val future = new FutureTask[T](callable)
        execute(future)

        future
    }

    /**
     * 执行任务
     * @param runnable  需要执行的任务
     */
    def execute(runnable: Runnable): Unit = {
        if (null == runnable) {
            throw new NullPointerException("runnable nullPointerException")
        }

        if (isShutDown.get()) {
            println("线程池已经关闭，不能再提交任务！")
            return
        }
        // 提交的线程 计数
        totalTask.incrementAndGet()

        if (workers.size() < miniSize) {
            addWorker(runnable)
            return
        }

        val offer = workQueue.offer(runnable)
        // 写入队列失败
        if (!offer) {
            // 创建新的线程执行
            if (workers.size() < maxSize) {
                addWorker(runnable)
                return
            } else {
                println("超过最大线程数")
                try {
                    // 会阻塞
                    workQueue.put(runnable)
                } catch {
                    case e: InterruptedException => e.printStackTrace()
                }
            }
        }
    }

    /**
     * 添加任务，需要加锁
     * @param runnable  任务
     */
    private def addWorker(runnable: Runnable): Unit = {
        val worker = new Worker(runnable, true)
        worker.startTask
        workers.add(worker)
    }


    /**
     * 工作线程
     */
    class Worker extends Thread {
        private var task: Runnable = _
        private var thread: Thread = _
        /**
         * true  --> 创建新的线程执行
         * false --> 从队列里获取线程执行
         */
        private var isNewTask: Boolean = _

        def this(task: Runnable, isNewTask: Boolean) = {
            this
            this.task = task
            this.isNewTask = isNewTask
            thread = this
        }

        def startTask: Unit = thread.start()

        def close: Unit = thread.interrupt()

        override def run(): Unit = {
            var task: Runnable = null
            if (isNewTask) task = this.task
            var compile: Boolean = true
            try {

                while ((task != null || (task = getTask) != null)) {
                    try {
                        // 执行任务
                        task.run()
                    } catch {
                        case e: Exception => {
                            compile = false
                            throw e
                        }
                    } finally {
                        // 任务执行完毕
                        task = null
                        val number = totalTask.decrementAndGet()
                        if (0 == number) {
                            synchronized {
                                shutDownNotify.notify()
                            }
                        }
                    }
                }
            } finally {
                // 释放线程
                val remove: Boolean = workers.remove(this)
                if (!compile) {
                    addWorker(null)
                }
                tryClose(true)
            }
        }
    }

    private def getTask: Runnable = {
        // 关闭标识及任务是否全部完成
        if (isShutDown.get() && totalTask.get() == 0) {
            return null
        }
        lock.lock()
        try {
            var task: Runnable = null
            if (workers.size() > miniSize) {
                // 大于核心线程数时需要用保活时间获取任务
                task = workQueue.poll(keepAliveTime, unit)
            } else {
                task = workQueue.take()
            }

            if (null != task) {
                return task
            }
        } catch {
            case e: InterruptedException => null
        } finally {
            lock.lock()
        }
        null
    }

    /**
     * 关闭线程池
     * @param isTry true 尝试关闭       --> 会等待所有任务执行完毕
     *              false 立即关闭线程池 --> 任务有丢失的可能
     */
    private def tryClose(isTry: Boolean): Unit = {
        if (!isTry) {
            closeAllTask
        } else {
            if (isShutDown.get() && totalTask.get() == 0) {
                closeAllTask
            }
        }
    }

    /**
     * 关闭所有任务
     */
    private def closeAllTask: Unit = workers.asScala.foreach(_.close)

    /**
     * 任务执行完毕关闭线程
     */
    def shutdown: Unit = {
        isShutDown.set(true)
        tryClose(true)
    }

    /**
     * 内部存放工作线程容器，并发安全
     * @tparam T
     */
    class ConcurrentHashSet[T] extends AbstractSet[T] {

        private val map: ConcurrentHashMap[T, Object] = new ConcurrentHashMap[T, Object]()
        private val PRESENT = new Object

        private val count = new AtomicInteger()

        override def size(): Int = count.get()

        override def iterator(): util.Iterator[T] = map.keySet().iterator()

        override def add(e: T): Boolean = {
            count.incrementAndGet()
            map.put(e, PRESENT) == PRESENT
        }

        override def remove(o: Any): Boolean = {
            count.decrementAndGet()
            map.remove(0) == PRESENT
        }
    }
}
