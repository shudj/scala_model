package com.ade.model.composite

class Leaf(name: String) extends Component(name) {
    override def add(component: Component): Unit = {
        println("cannot add to a leaf")
    }

    override def remove(component: Component): Unit = {
        println("cannot remove to a leaf")
    }

    override def display(depth: Int): Unit = {
        println("-" * depth + name)
    }
}
