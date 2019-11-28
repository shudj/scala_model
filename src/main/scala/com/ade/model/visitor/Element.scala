package com.ade.model.visitor

/**
  * @author: shudj
  * @time: 2019/11/28 15:21
  * @description:
  */
trait Element {
    def accept(visitor: Visitor)
}

class ConcreteElementA extends Element {
    override def accept(visitor: Visitor): Unit = visitor.visitConcreteElementA(this)

    // 其他操作做方法
    def operationA: Unit = ???
}

class ConcreteElementB extends Element {
    override def accept(visitor: Visitor): Unit = visitor.visitConcreteElementB(this)

    def operationB: Unit = ???
}