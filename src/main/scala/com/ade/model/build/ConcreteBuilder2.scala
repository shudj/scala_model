package com.ade.model.build

class ConcreteBuilder2 extends Builder {

    private val product = new Product
    override def buildPartA: Unit = product.add("部件X")

    override def buildPartB: Unit = product.add("部件Y")

    override def getResult: Product = product
}
