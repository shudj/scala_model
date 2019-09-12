package com.ade.concurrent.code.thread

import java.util.concurrent.TimeUnit

/**
  * @author: shudj
  * @time: 2019/9/11 10:09
  * @description:
  *    通过中断操作和cancel()方法均可以使CountThead得以终止，这种通过标识位或者中断操作的方式能够使线程在终止时有机会去清理资源，
  *    而不是武断地将线程停止，因此这种终止线程的做法显得更加安全和优雅
  */
object ShutDown {

    def main(args: Array[String]): Unit = {
        val one = new Runner
        var countThread = new Thread(one, "CountThread")
        countThread.start
        // 睡眠1秒，main线程对CountThread进行中断，使CountThread能够感知中断而结束
        TimeUnit.SECONDS.sleep(1)
        countThread.interrupt()
        val two = new Runner
        countThread = new Thread(two, "countThread")
        countThread.start()
        // 睡眠1秒，main线程对CountThread进行取消，使CountThread能够感知on为false而结束
        TimeUnit.SECONDS.sleep(1)
        two.cancel()
    }

    class Runner extends Runnable {

        private var i: Int = 0
        @volatile private var on:Boolean = true
        override def run(): Unit = {
            while (on && !Thread.currentThread().isInterrupted) {
                i += 1
            }

            println("Count i = " + i)
        }

        def cancel(): Unit = {
            on = false
        }
    }
}
