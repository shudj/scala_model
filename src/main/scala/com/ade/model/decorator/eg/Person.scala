package com.ade.model.decorator.eg

class Person {

    private var name: String = _
    def this(name: String) = {
        this
        this.name = name
    }

    def show(): Unit = {
        printf("装扮的%s", name)
    }
}
