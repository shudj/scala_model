package com.ade.concurrent.code

import java.util.concurrent.atomic.AtomicInteger

import scala.collection.mutable.ArrayBuffer


/**
  * @author: shudj
  * @time: 2019/9/5 14:43
  * @description:
  */
object CAS_demo1 {

    def main(args: Array[String]): Unit = {
        val cas = new CAS_demo1()
        val ts = ArrayBuffer[Thread]()
        val start = System.currentTimeMillis()
        for (j <- 0 to 100) {

            val t = new Thread(new Runnable {
                override def run(): Unit = {
                    for (i <- 0 to 10000) {
                        cas.count()
                        cas.safeCount()
                    }
                }
            })
            print(t)
            ts += t
        }
        println(ts.length)
        ts.foreach(t => t.start())

        // 等待所有线程执行完成
        for (t: Thread <- ts) {
            try {
                t.join()
            } catch {
                case e:InterruptedException => e.printStackTrace()
            }
        }

        println(cas.i)
        println(cas.atomicI.get())
        println(System.currentTimeMillis() - start)
    }
}

class CAS_demo1() {

    val atomicI = new AtomicInteger(0)
    var i = 0

    /**
      * 使用CAS实现线程安全计数器
      */
    def safeCount(): Unit = {
        var flag = true
        while (flag) {
            var i = atomicI.get()
            val t = i + 1
            val suc = atomicI.compareAndSet(i, t)
            i = t
            if (suc) {
                flag = false
            }
        }
    }

    /**
      * 非线程安全计数器
      */
    def count(): Unit = {
        i += 1
    }
}
