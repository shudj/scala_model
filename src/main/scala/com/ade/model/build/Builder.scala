package com.ade.model.build

trait Builder {

    def buildPartA
    def buildPartB
    def getResult: Product
}
