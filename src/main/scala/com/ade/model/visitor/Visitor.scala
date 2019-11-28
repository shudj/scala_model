package com.ade.model.visitor

/**
  * @author: shudj
  * @time: 2019/11/28 15:22
  * @description:
  */
trait Visitor {
    def visitConcreteElementA(concreteElementA: ConcreteElementA)
    def visitConcreteElementB(concreteElementB: ConcreteElementB)
}

class ConcreteVisitor1 extends Visitor {
    override def visitConcreteElementA(concreteElementA: ConcreteElementA): Unit = println(s"${concreteElementA.getClass.getName}被${this.getClass.getName}访问")

    override def visitConcreteElementB(concreteElementB: ConcreteElementB): Unit = println(s"${concreteElementB.getClass.getName}被${this.getClass.getName}访问")
}

class ConcreteVisitor2 extends Visitor {
    override def visitConcreteElementA(concreteElementA: ConcreteElementA): Unit = println(s"${concreteElementA.getClass.getName}被${this.getClass.getName}访问")

    override def visitConcreteElementB(concreteElementB: ConcreteElementB): Unit = println(s"${concreteElementB.getClass.getName}被${this.getClass.getName}访问")
}