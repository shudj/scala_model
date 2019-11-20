package com.ade.model.bridge

class AbstracitionClass {

    protected var implementor: Implementor = _

    def setImplementor(implementor: Implementor): Unit = this.implementor = implementor

    def operation: Unit = implementor.operation
}

class RefinedAbstraction extends AbstracitionClass {
    override def operation: Unit = implementor.operation
}