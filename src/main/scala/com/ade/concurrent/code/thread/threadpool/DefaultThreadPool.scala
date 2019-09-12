package com.ade.concurrent.code.thread.threadpool

import java.util
import java.util.Collections
import java.util.concurrent.atomic.AtomicLong

/**
  * @author: shudj
  * @time: 2019/9/12 10:25
  * @description:  设计一个线程池接口
  */
class DefaultThreadPool[Job <: Runnable](implicit job:Null <:< Job) extends ThreadPool[Job] {

    // 线程池最大限制数
    private val MAX_WORKER_NUMBERS: Int = 10
    // 线程默认的数量
    private val DEFAULT_WORKER_NUMBERS: Int = 5
    // 线程池最小的数量
    private val MIN_WORKER_NUMBERS = 1
    // 这是一个工作列表，将会向里面插入工作
    private val jobs = new util.LinkedList[Job]()
    // 工作者列表
    private val workers = Collections.synchronizedList(new util.ArrayList[Worker]())
    // 工作者线程的数量
    private var workerNum = DEFAULT_WORKER_NUMBERS
    // 线程编号生成
    private val threadNum: AtomicLong = new AtomicLong()

    initialWorkers(DEFAULT_WORKER_NUMBERS)

    def this(num: Int) {
        this
        workerNum = if (num > MAX_WORKER_NUMBERS) MAX_WORKER_NUMBERS else if (num < MIN_WORKER_NUMBERS) MIN_WORKER_NUMBERS else num
        initialWorkers(workerNum)
    }

    override def excute(job: Job): Unit = {
        if (null != job) {
            jobs.synchronized {
                jobs.addLast(job)
                jobs.notify()
            }
        }
    }

    override def shutdown: Unit = {
        for (worker: Worker <- workers) {
            worker.shutdown
        }
    }

    override def addWorkers(num: Int): Unit = {
        jobs.synchronized {
            var temp = num
            // 限制新增的Worker数量不能超过最大值
            if (temp + this.workerNum > MAX_WORKER_NUMBERS) {
                temp = MAX_WORKER_NUMBERS - this.workerNum
            }
            initialWorkers(temp)
            this.workerNum += temp
        }
    }

    override def removeWorkers(num: Int): Unit = {
        jobs.synchronized() {
            if (num >= this.workerNum) {
                throw new IllegalArgumentException("beyond workNum")
            }

            // 按照给定的数量停止Worker
            var count: Int = 0
            while (count < num) {
                val worker = workers.get(count)
                if (workers.remove(worker)) {
                    worker.shutdown
                    count += 1
                }
            }
            this.workerNum -= count
        }
    }

    override def getJobSize: Int = jobs.size()

    // 初始化线程工作者
    private def initialWorkers(num: Int): Unit = {
        for (i <- 0 until num) {
            val worker = new Worker
            workers.add(worker)
            val thread = new Thread(worker, "ThreadPool-Worker-" + threadNum.incrementAndGet())
            thread.start()
        }
    }

    class Worker extends Runnable {

        // 是否工作
        @volatile private var running: Boolean = true
        override def run(): Unit = {
            while (running) {
                var job: Job = null
                jobs.synchronized() {
                    // 如果工作者是空，那么就等待wait
                    while (jobs.isEmpty) {
                        try {
                            jobs.wait()
                        } catch {
                            case ex: InterruptedException => {
                                // 感知外部对WokerThread的中断操作，返回
                                Thread.currentThread().interrupt()
                                return
                            }
                        }
                    }
                    // 取出一个Job
                    job = jobs.removeFirst()
                }

                if (null != job) {
                    try {
                        job.run()
                    } catch {
                        case ex: Exception =>
                    }
                }
            }
        }

        def shutdown: Unit = {

            running = false
        }
    }
}
