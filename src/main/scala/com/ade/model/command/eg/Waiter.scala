package com.ade.model.command.eg

import java.util.Date

import scala.collection.mutable.ArrayBuffer

class Waiter {

    private val commands: ArrayBuffer[Command] = ArrayBuffer[Command]()

    def setOrder(command: Command): Unit = {
        val name = command.getClass.getName
        val i = name.lastIndexOf('.')
        if (name.substring(i + 1).equals("BakeChickenWingCommand")) {
            println("服务员：鸡翅没有了，请点别的烧烤")
        } else {
            commands += command
            println(s"增加订单：${command.toString} 时间：${new Date(System.currentTimeMillis())}")
        }
    }

    def cancelOrder(command: Command): Unit = {
        commands -= command
        println(s"取消订单：${command.toString} 时间：${System.currentTimeMillis()}")
    }

    def notice(): Unit = {
        commands.foreach(_.executeCommand())
    }
}
