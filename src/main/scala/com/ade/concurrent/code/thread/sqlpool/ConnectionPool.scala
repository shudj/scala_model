package com.ade.concurrent.code.thread.sqlpool

import java.sql.Connection
import java.util

/**
  * @author: shudj
  * @time: 2019/9/12 9:39
  * @description:
  */
class ConnectionPool {

    val pool: util.LinkedList[Connection] = new util.LinkedList[Connection]()

    def this(initialSize: Int) = {
        this
        if (initialSize > 0) {
            for (i <- 0 to initialSize) {
                pool.addLast(ConnectionDriver.createConnection())
            }
        }
    }

    def releaseConnection(connection: Connection): Unit = {
        if (null != connection) {
            pool.synchronized {
                // 连接释放需要进行通知，这样其他消费者能够感知到连接池中已经归还了一个连接
                pool.addLast(connection)
                pool.notifyAll()
            }
        }
    }


    @throws[InterruptedException] def fetchConnection(mills: Long): Connection = {
        pool.synchronized {
            // 完全超时
            if (mills <= 0) {
                while (pool.isEmpty) {
                    pool.wait()
                }

                return pool.removeFirst()
            } else {
                val future: Long = System.currentTimeMillis() + mills
                var remaining: Long = mills
                while (pool.isEmpty && remaining > 0) {
                    pool.wait()
                    remaining = future - System.currentTimeMillis()
                }

                var result: Connection = null
                if (!pool.isEmpty) {
                    result = pool.removeFirst()
                }

                result
            }
        }
    }
}
