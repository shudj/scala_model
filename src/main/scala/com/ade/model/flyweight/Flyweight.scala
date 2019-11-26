package com.ade.model.flyweight

/**
  * 是所有具体享元类的超类或接口，通过这个接口，Flyweight可以接受并作用于外部状态
  */
trait Flyweight {

    def operation(extrinsicState: Int)
}

/**
  * 为内部状态增加存储空间
  */
class ConcreteFlyweight extends Flyweight {
    override def operation(extrinsicState: Int): Unit = println(s"具体Flyweight：$extrinsicState")
}

/**
  * UnsharedConcreteFlyweight是指那些不需要共享的Flyweight子类
  */
class UnsharedConcreteFlyweight extends Flyweight {
    override def operation(extrinsicState: Int): Unit = println(s"不共享的具体Flyweight：$extrinsicState")
}