package com.ade.model.bridge

/**
 * 桥接模式（Bridge），将抽象部分与它的实现部分分离，使它们都可以独立地变化
 *
 * 什么叫抽象与它的实现分离，这并不是说，让抽象类与其派生类分离，因为这没有任何意义。实现指的是抽象类和它的派生类用来实现自己的对象
 *
 * 实现系统可能有多角度分类，每一种分类都有可能变化，那么就把这么多角度分离出来让它们独立变化，减少它们之间的耦合
 */
object TestBridge {

    def main(args: Array[String]): Unit = {
        val refinedAbstraction = new RefinedAbstraction
        refinedAbstraction.setImplementor(new ConcreteImplementorA)
        refinedAbstraction.operation

        refinedAbstraction.setImplementor(new ConcreteImplementorB)
        refinedAbstraction.operation
    }
}
