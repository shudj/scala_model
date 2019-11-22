package com.ade.model.command.eg

abstract class Command {

    protected var receiver: Barbecuer = _

    /**
     * @param receiver 抽象命令类，只需要确定“烤肉串者”是谁
     */
    def this(receiver: Barbecuer) = {
        this
        this.receiver = receiver
    }

    def executeCommand(): Unit

    override def toString: String = {
        val name: String = this.getClass.getName
        val i = name.lastIndexOf('.')
        name.substring(i + 1)
    }
}
