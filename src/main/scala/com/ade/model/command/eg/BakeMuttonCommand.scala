package com.ade.model.command.eg

/**
 * 烤羊肉串命令
 */
class BakeMuttonCommand extends Command {

    def this(receiver: Barbecuer) = {
        this
        this.receiver = receiver
    }

    override def executeCommand(): Unit = receiver.bakeMutton()
}
