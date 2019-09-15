package com.ade.model.decorator

class ConcreteDecoratorB extends Decorator {
    override def operation(): Unit = {
        super.operation()
        addedBehavior()
    }

    private def addedBehavior(): Unit = {
        println("本类独有的方法，以区别于ConcreteDecoratorB")
    }
}
