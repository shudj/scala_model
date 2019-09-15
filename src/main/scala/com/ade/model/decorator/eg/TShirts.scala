package com.ade.model.decorator.eg

class TShirts extends Finery {

    override def show(): Unit = {
        println("大T恤")
        super.show()
    }
}
