package com.ade.model.decorator

object Test {

    def main(args: Array[String]): Unit = {
        val c = new ConcreteComponent
        val a = new ConcreteDecoratorA
        val b = new ConcreteDecoratorB
        a.setComponent(c)
        b.setComponent(a)
        b.operation()
    }
}
