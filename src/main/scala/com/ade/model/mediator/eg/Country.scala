package com.ade.model.mediator.eg

/**
  * @author: shudj
  * @time: 2019/11/25 16:47
  * @description:
  */
abstract class Country {

    protected var mediator: UniteNations = _

    def this(mediator: UniteNations) = {
        this
        this.mediator = mediator
    }
}

class USA extends Country {

    def this(mediator: UniteNations) = {
        this
        this.mediator = mediator
    }

    def declare(message: String): Unit = this.mediator.declare(message, this)

    def getMessage(message: String): Unit = println(s"USA获取的对方的信息：$message")
}

class Iraq extends Country {

    def this(mediator: UniteNations) = {
        this
        this.mediator = mediator
    }

    def declare(message: String):Unit = this.mediator.declare(message, this)

    def getMessage(message: String): Unit = println(s"Iraq获得的对方的信息：$message")
}