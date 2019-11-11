package com.ade.model.observer

class ConcreteObserver extends Observer {

    var name: String = _
    var observerState: String = _
    var subject: ConcreteSubject = _
    def this(subject: ConcreteSubject, name: String) = {
        this
        this.subject = subject
        this.name = name
    }


    override def update: Unit = {
        observerState = subject.subjectState
        println(s"观察者${name}的新状态是${observerState}")
    }
}
