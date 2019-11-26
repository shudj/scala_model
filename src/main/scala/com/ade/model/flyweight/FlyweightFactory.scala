package com.ade.model.flyweight

import scala.collection.mutable._
/**
  * @author: shudj
  * @time: 2019/11/26 17:47
  * @description:
  */
class FlyweightFactory {

    private val flyweights = Map[String, Flyweight](
        "X" -> new ConcreteFlyweight,
        "Y" -> new ConcreteFlyweight,
        "Z" -> new ConcreteFlyweight
    )

    def getFlyweight(key: String): Flyweight = flyweights.get(key).orNull
}
