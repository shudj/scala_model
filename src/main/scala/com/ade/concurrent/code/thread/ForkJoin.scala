package com.ade.concurrent.code.thread

import java.util.concurrent.{ForkJoinPool, ForkJoinTask, RecursiveTask}

/**
  * @author: shudj
  * @time: 2019/12/25 17:23
  * @description:
  * 步骤1　分割任务。首先我们需要有一个fork类来把大任务分割成子任务，有可能子任务还
  * 是很大，所以还需要不停地分割，直到分割出的子任务足够小。
  *
  * 步骤2　执行任务并合并结果。分割的子任务分别放在双端队列里，然后几个启动线程分
  * 别从双端队列里获取任务执行。子任务执行完的结果都统一放在一个队列里，启动一个线程
  * 从队列里拿数据，然后合并这些数据。
  *
  * Fork/Join使用两个类来完成以上两件事情:
  *
  * ①ForkJoinTask：我们要使用ForkJoin框架，必须首先创建一个ForkJoin任务。它提供在任务
  * 中执行fork()和join()操作的机制。通常情况下，我们不需要直接继承ForkJoinTask类，只需要继
  * 承它的子类，Fork/Join框架提供了以下两个子类。
  * ·RecursiveAction：用于没有返回结果的任务。
  * ·RecursiveTask：用于有返回结果的任务。
  *
  * ②ForkJoinPool：ForkJoinTask需要通过ForkJoinPool来执行。
  * 任务分割出的子任务会添加到当前工作线程所维护的双端队列中，进入队列的头部。当
  * 一个工作线程的队列里暂时没有任务时，它会随机从其他工作线程的队列的尾部获取一个任
  * 务。
  */
class ForkJoin extends RecursiveTask[Int]{

    private val THRESHOLD: Int = 10
    private var start: Int = _
    private var end: Int = _

    def set(start: Int, end: Int): ForkJoin = {
        this.start = start
        this.end = end

        this
    }

    override def compute(): Int = {
        var sum: Int = 0
        // 如果任务足够下就计算任务
        val canCompute: Boolean = end - start <= THRESHOLD
        if (canCompute) {
            for (i <- start to end) {
                println(s"${i}, ${start}, ${end}")
                sum = sum + i
            }
        } else {
            // 如果任务大于阀值，就分裂成两个子任务计算
            val middle: Int = (start + end) / 2
            val leftTask = new ForkJoin().set(start, middle)
            val rightTask = new ForkJoin().set(middle + 1, end)
            // 执行任务
            leftTask.fork()
            rightTask.fork()
            // 等待子任务执行完毕，并得到其结果
            val left = leftTask.join()
            val right = rightTask.join()
            // 合并子任务
            sum = left + right
        }

        sum
    }
}

object ForkJoin {
    def main(args: Array[String]): Unit = {
        val forkJoinPool = new ForkJoinPool()
        val forkJoin = new ForkJoin().set(1, 50)
        val result: ForkJoinTask[Int] = forkJoinPool.submit(forkJoin)
        println(result.get())
    }
}