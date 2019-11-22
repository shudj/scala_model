package com.ade.model.command

/**
  *
  */
abstract class Command {

    protected var receiver: Receiver = _

    def this(receiver: Receiver) = {
        this
        this.receiver = receiver
    }

    def execute: Unit
}
