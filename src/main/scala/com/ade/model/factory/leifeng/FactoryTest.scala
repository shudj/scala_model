package com.ade.model.factory.leifeng

object FactoryTest {

    def main(args: Array[String]): Unit = {
        val factory = new UndergraduateFactory
        val leiFeng = factory.createLeiFeng
        leiFeng.sweep
    }
}
