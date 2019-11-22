package com.ade.model.command.eg

object TestBarbecue {

    def main(args: Array[String]): Unit = {
        // 开店前的准备
        val barbecuer = new Barbecuer
        val muttonCommand = new BakeMuttonCommand(barbecuer)
        val muttonCommand1 = new BakeMuttonCommand(barbecuer)
        val muttonCommand2 = new BakeMuttonCommand(barbecuer)
        val chickenWingCommand = new BakeChickenWingCommand(barbecuer)
        val waiter = new Waiter

        // 开店营业
        waiter.setOrder(muttonCommand)
        waiter.setOrder(muttonCommand1)
        waiter.setOrder(chickenWingCommand)

        waiter.cancelOrder(muttonCommand2)
        waiter.notice()
    }
}
