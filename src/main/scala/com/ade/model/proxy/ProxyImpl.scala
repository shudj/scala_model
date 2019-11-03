package com.ade.model.proxy

class ProxyImpl(girl: Girl) extends Proxy {
    val ps: Pursite = new Pursite(girl)
    override def giveFlowers: Unit = ps.giveFlowers

    override def giveDolls: Unit = ps.giveDolls
}
