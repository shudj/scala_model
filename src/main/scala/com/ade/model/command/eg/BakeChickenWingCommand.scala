package com.ade.model.command.eg

class BakeChickenWingCommand extends Command {

    def this(receiver: Barbecuer) = {
        this
        this.receiver = receiver
    }
    override def executeCommand(): Unit = receiver.bakeChickenWing()
}
