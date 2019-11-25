package com.ade.model.mediator

/**
  * @author: shudj
  * @time: 2019/11/25 16:36
  * @description:
  */
abstract class Mediator {

    def send(message: String, colleague: Colleague)
}

class ConcreteMediator extends Mediator {

    var colleague1: ConcreteColleague1 = _
    var colleague2: ConcreteColleague2 = _

    override def send(message: String, colleague: Colleague): Unit = {
        if (colleague.equals(colleague1)) {
            colleague2.notice(message)
        } else {
            colleague1.notice(message)
        }
    }
}