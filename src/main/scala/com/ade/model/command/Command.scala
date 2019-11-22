package com.ade.model.command

/**
  * @author: shudj
  * @time: 2019/11/22 17:53
  * @description:
  */
abstract class Command {

    protected var receiver: Receiver = _

    def this(receiver: Receiver) = {
        this
        this.receiver = receiver
    }

    def execute: Unit
}
