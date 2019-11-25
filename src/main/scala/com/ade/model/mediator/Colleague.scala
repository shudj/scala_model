package com.ade.model.mediator

/**
  * @author: shudj
  * @time: 2019/11/25 16:37
  * @description:
  */
abstract class Colleague {
    protected var mediator: Mediator = _

    def this(mediator: Mediator) = {
        this
        this.mediator = mediator
    }
}

class ConcreteColleague1 extends Colleague {

    def this(mediator: Mediator) {
        this
        this.mediator = mediator
    }

    def send(message: String): Unit = {
        this.mediator.send(message, this)
    }

    def notice(message: String): Unit = {
        println(s"同事1得到消息：${message}")
    }
}

class ConcreteColleague2 extends Colleague {

    def this(mediator: Mediator) {
        this
        this.mediator = mediator
    }

    def send(message: String): Unit = {
        this.mediator.send(message, this)
    }

    def notice(message: String): Unit = {
        println(s"同事2得到消息：${message}")
    }
}