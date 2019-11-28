package com.ade.model.visitor

import scala.collection.mutable.ArrayBuffer

/**
  * @author: shudj
  * @time: 2019/11/28 15:28
  * @description:
  */
class ObjectStructure {
    private var elements = ArrayBuffer[Element]()

    def add(element: Element):Unit = elements = elements :+ element

    def remove(element: Element): Unit = elements = elements - element

    def accept(visitor: Visitor): Unit = {
        elements.foreach(_.accept(visitor))
    }
}
