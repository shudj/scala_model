package com.ade.concurrent.code.thread

import java.lang.management.ManagementFactory

/**
  * @author: shudj
  * @time: 2019/9/10 18:09
  * @description:
  */
object MultiThread {
    def main(args: Array[String]): Unit = {
        // 获取Java线程管理MXBean
        val threadMXBean = ManagementFactory.getThreadMXBean
        // 不需要获取同步的monitor和synchronizer信息，仅获取线程和线程堆栈信息
        val threadInfoes = threadMXBean.dumpAllThreads(false, false)
        // 遍历线程信息，仅打印线程ID和线程名称信息
        threadInfoes.foreach(threadInfo => {
            println("[" + threadInfo.getThreadId + "] " + threadInfo.getThreadName + "\t" + threadInfo.getThreadState)
        })
    }
}
