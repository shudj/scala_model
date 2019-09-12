package com.ade.concurrent.code.thread.threadpool

/**
  * @author: shudj
  * @time: 2019/9/12 10:28
  * @description:
  */
trait ThreadPool[Job <: Runnable] {

    // 执行一个Job，这个Job需要实现Runnable
    def excute(job: Job)

    // 关闭线程池
    def shutdown

    // 增加工作者线程
    def addWorkers(num: Int)

    // 减少工作者线程
    def removeWorkers(num: Int)

    // 得到正在等待执行的任务数量
    def getJobSize: Int
}
