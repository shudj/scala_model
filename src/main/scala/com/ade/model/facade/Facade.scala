package com.ade.model.facade

class Facade {

    val one = new SubSystemOne
    val two = new SubSystemTwo
    val three = new SubSystemThree
    val four = new SubSystemFour

    def methodA = {
        one.methodOne
        two.methodTwo
        four.methodFour
    }

    def methodB = {
        two.methodTwo
        three.methodThree
    }
}
