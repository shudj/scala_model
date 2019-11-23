package com.ade.concurrent.code.thread

class VolatileTest extends Thread{

    // 加上volatile程序会停止
    // volatile负责从主内存拉取相关属性的值到线程内存中
    @volatile var flag: Boolean = false
    // var flag: Boolean = false
    var i: Int = 0

    override def run(): Unit = {
        while (!flag) i += 1
    }
}

object VolatileTest {
    def main(args: Array[String]): Unit = {
        val vt = new VolatileTest
        vt.start()
        Thread.sleep(2000)
        vt.flag = true
        println("stop " + vt.i)
    }
}
