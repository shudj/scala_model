package com.ade.model.flyweight

/**
  * 享元模式（Flyweight）：运用共享技术有效地支持大量细粒度的对象
  *
  * 场景：
  *     如果一个应用使用了大量的对象，而大量的这些对象造成了很大的存储开销时就应该考虑使用；还有就是对象的大多数状态可以外部状态，如果
  *     删除对象的外部状态，那么可以用相对较少的共享对象取代很多对象，此时可以考虑享元模式
  */
object TestFlyWeight {

    def main(args: Array[String]): Unit = {
        val extrinsicState: Int = 22

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
