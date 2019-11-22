package com.ade.model.command

/**
  * @author: shudj
  * @time: 2019/11/22 17:55
  * @description:
  */
class ConcreteCommand extends Command {

    def this(receiver: Receiver) {
        this
        super.receiver = receiver
    }

    override def execute: Unit = {
        receiver.action
    }
}
