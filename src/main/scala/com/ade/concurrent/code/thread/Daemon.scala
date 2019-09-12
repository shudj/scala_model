package com.ade.concurrent.code.thread

/**
  * @author: shudj
  * @time: 2019/9/11 9:31
  * @description:
  *    Daemon线程是一种支持型线程，因为它主要被用作程序中后台调度以及支持性工作。这意味着当一个Java虚拟机中不存在非Daemon
  * 线程的时候，Java虚拟机将会退出。可以通过调用Thread.setDaemon(true)将线程设置为Daemon线程
  *
  * 注：Daemon属性需要在启动线程之前设置，不能再启动线程之后设置
  *    在构建Daemon线程时，不能依靠finally块中的内容来确保执行关闭或清理资源的逻辑
  *
  *
  * result：运行Daemon程序，可以看到在终端或者命令提示符上没有任何输出。main线程（非Daemon线程）在启动了线程DaemonRunner之后
  *         随着main方法执行完毕而终止，而此时Java虚拟机中已经没有非Daemon线程，虚拟机需要退出。Java虚拟机中的所有Daemon线程
  *         需要立即终止，因此DaemonRunner立即终止，但是DaemonRunner中finally块并没有执行
  */
object Daemon {

    def main(args: Array[String]): Unit = {
        val thread = new Thread(new DaemonRunner, "DaemonRunner")
        thread.setDaemon(true)
        thread.start()
    }

    class DaemonRunner extends Runnable {
        override def run(): Unit = {

            try {
                Thread.sleep(10)
            } finally {
                println("DaemonThread finally run.")
            }
        }
    }
}
