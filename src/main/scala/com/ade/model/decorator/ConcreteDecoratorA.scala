package com.ade.model.decorator

class ConcreteDecoratorA extends Decorator {
    private var addedState: String = _

    override def operation(): Unit = {
        super.operation()
        addedState = "New State"
        println("具体装饰对象A的操作")
    }
}
