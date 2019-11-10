package com.ade.model.build

class ConcreteBuilder1 extends Builder {
    private val product = new Product
    override def buildPartA: Unit = product.add("部件A")

    override def buildPartB: Unit = product.add("部件B")

    override def getResult: Product = product
}
