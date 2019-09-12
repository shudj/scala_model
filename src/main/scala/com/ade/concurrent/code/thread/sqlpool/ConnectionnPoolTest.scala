package com.ade.concurrent.code.thread.sqlpool

import java.sql.Connection
import java.util.concurrent.CountDownLatch
import java.util.concurrent.atomic.AtomicInteger

/**
  * @author: shudj
  * @time: 2019/9/12 9:56
  * @description:
  */
object ConnectionnPoolTest {

    val pool: ConnectionPool = new ConnectionPool(10)
    // 保证所有ConnectionRunner能够同时开始
    val start: CountDownLatch = new CountDownLatch(1)
    // main线程将会等待所有ConnectionRunner结束后才能继续执行
    var end: CountDownLatch = _

    @throws[Exception] def main(args: Array[String]): Unit = {
        // 线程数量，可以修改线程数量进行观察
        val threadCount: Int = 10
        end = new CountDownLatch(threadCount)
        val count: Int = 20
        val got: AtomicInteger = new AtomicInteger()
        val notGot: AtomicInteger = new AtomicInteger()
        for (i <- 0 until threadCount) {
            val thread = new Thread(new ConnectionRunner(count, got, notGot), "ConnectionRunnerThread")
            thread.start()
        }

        start.countDown()
        end.await()
        println("total invoke: " + (threadCount * count))
        println("got connection:" + got)
        println("not got connection: " + notGot)
    }

    class ConnectionRunner extends Runnable {
        var count: Int = 0
        var got: AtomicInteger = _
        var notGot: AtomicInteger = _

        def this(count: Int, got: AtomicInteger, notGot: AtomicInteger) {
            this
            this.count = count
            this.got = got
            this.notGot = notGot
        }

        override def run(): Unit = {
            try {
                start.await()
            } catch {
                case ex: Exception =>
            }

            while (count > 0) {
                try {
                    // 从线程池获取连接，如果1000ms内无法获取到，将返回null
                    // 分别统计连接获取的数量got和未获取到的数量notGot
                    val connection: Connection = pool.fetchConnection(1000)
                    if (null != connection) {
                        try {
                            connection.createStatement()
                            connection.commit()
                        } finally {
                            pool.releaseConnection(connection)
                            got.incrementAndGet()
                        }
                    } else {
                        notGot.incrementAndGet()
                    }
                } catch {
                    case ex: Exception =>
                } finally {
                    count -= 1
                }
            }
            end.countDown()
        }
    }
}
