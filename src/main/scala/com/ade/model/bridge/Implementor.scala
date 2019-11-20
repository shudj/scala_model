package com.ade.model.bridge

trait Implementor {

    def operation: Unit
}

class ConcreteImplementorA extends Implementor {
    override def operation: Unit = println("具体实现A的方法执行")
}

class ConcreteImplementorB extends Implementor {
    override def operation: Unit = println("具体实现B的方法执行")
}