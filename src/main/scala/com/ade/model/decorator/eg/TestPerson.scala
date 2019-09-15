package com.ade.model.decorator.eg

object TestPerson {

    def main(args: Array[String]): Unit = {
        val person = new Person("ade")
        println("\n 第一种装扮： ")
        val shirts = new TShirts
        val bigTrouser = new BigTrouser
        shirts.decorate(person)
        bigTrouser.decorate(shirts)
        bigTrouser.show()
    }
}
