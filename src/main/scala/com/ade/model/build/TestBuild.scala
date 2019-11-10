package com.ade.model.build

/**
 * 建造者模式是在当创建复杂对象得算法应该独立于该对象得组成部分以及它们得装配方式时适用得模式
 */
object TestBuild {

    def main(args: Array[String]): Unit = {
        val director = new Director
        val b1 = new ConcreteBuilder1
        val b2 = new ConcreteBuilder2

        director.construct(b1)
        val p1 = b1.getResult
        p1.show

        director.construct(b2)
        val p2 = b2.getResult
        p2.show
    }
}
