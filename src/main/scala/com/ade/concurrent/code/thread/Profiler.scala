package com.ade.concurrent.code.thread

import java.util.concurrent.TimeUnit

/**
  * @author: shudj
  * @time: 2019/9/12 9:20
  * @description:
  */
object Profiler {

    private val TIME_THREADLOCAL: ThreadLocal[Long] = new ThreadLocal[Long]() {
        override def initialValue(): Long = System.currentTimeMillis()
    }

    def begin = TIME_THREADLOCAL.set(System.currentTimeMillis())

    def end: Long = System.currentTimeMillis() - TIME_THREADLOCAL.get()

    def main(args: Array[String]): Unit = {
        begin
        TimeUnit.SECONDS.sleep(1)
        println("Cost: " + end + " mills")
    }
}
