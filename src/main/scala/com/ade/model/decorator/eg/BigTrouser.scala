package com.ade.model.decorator.eg

class BigTrouser extends Finery {

    override def show(): Unit = {
        println("垮裤")
        super.show()
    }
}
