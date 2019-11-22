package com.ade.model.command

/**
  * @author: shudj
  * @time: 2019/11/22 17:58
  * @description: 命令
  */
object TestCommand {

    def main(args: Array[String]): Unit = {
         val receiver = new Receiver
        val command = new ConcreteCommand(receiver)
        val invoker = new Invoker

        invoker.command = command
        invoker.executeCommand
    }
}
