package com.ade.model.flyweight

/**
  * 享元模式（Flyweight）：运用共享技术有效地支持大量细粒度的对象
  */
object TestFlyWeight {

    def main(args: Array[String]): Unit = {
        var extrinsicState: Int = 22

        val factory = new FlyweightFactory

        val fx = factory.getFlyweight("X")
        fx.operation(extrinsicState = extrinsicState - 1)

        val fy = factory.getFlyweight("Y")
        fy.operation(extrinsicState = extrinsicState - 1)

        val fz = factory.getFlyweight("Z")
        fz.operation(extrinsicState = extrinsicState - 1)

        val unsharedConcreteFlyweight = new UnsharedConcreteFlyweight
        unsharedConcreteFlyweight.operation(extrinsicState = extrinsicState - 1)
    }
}
