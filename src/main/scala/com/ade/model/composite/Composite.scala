package com.ade.model.composite

import java.util

class Composite(name: String) extends Component(name) {

    import scala.collection.JavaConverters._
    private val list = new util.ArrayList[Component]()
    override def add(component: Component): Unit = list.add(component)

    override def remove(component: Component): Unit = list.remove(component)

    override def display(depth: Int): Unit = {
        println("-" * depth + name)
        list.asScala.foreach(_.display(depth + 2))
    }
}
