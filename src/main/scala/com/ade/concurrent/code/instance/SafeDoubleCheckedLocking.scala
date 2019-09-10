package com.ade.concurrent.code.instance

/**
  * @author: shudj
  * @time: 2019/9/10 17:09
  * @description:  线程安全的延迟初始化
  */
class Instance {
    def printTest(): Unit = {
        println("nihao")
    }
}

object SafeDoubleCheckedLocking {

    @volatile private[this] var instance: Instance = null

    def getInstance(): Instance = {
        if (null == instance) {
            this.synchronized {
                if (null == instance) {
                    instance = new Instance
                }
            }
        }

        instance
    }

    def main(args: Array[String]): Unit = {
        getInstance().printTest()
    }
}
