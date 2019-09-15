package com.ade.model.decorator.eg

class Finery extends Person {
    protected var person: Person = null
    def this(person: Person) = {
        this
        this.person = person
    }

    override def show(): Unit = {
        if (null != person) {
            person.show()
        }
    }

    def decorate(person: Person): Unit = {
        this.person = person
    }
}
