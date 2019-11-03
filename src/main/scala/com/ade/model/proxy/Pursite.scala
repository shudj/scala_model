package com.ade.model.proxy

class Pursite(girl: Girl) extends Proxy {

    override def giveFlowers: Unit = {
        println("送" + girl.getName + "玫瑰花")
    }

    override def giveDolls: Unit = println("送" + girl.getName + "洋娃娃")
}
