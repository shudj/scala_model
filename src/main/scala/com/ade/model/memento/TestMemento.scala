package com.ade.model.memento

/**
 * 备忘录（Memento）：在不破坏封装性的前提下，捕获一个对象的内部状态，并在该对象之外保存这个状态。这样以后就可将该对象恢复到原先保存的状态
 *
 * Memento模式比较适用于功能比较复杂，但需要维护或记录属性历史的类，或者需要保存的属性只是众多属性中的一小部分时，Originator可以根据保存的Memento信息还原到前一状态
 *
 *  当角色的状态改变的时候，有可能这个状态无效，这时候就可以使用暂时存储起来的备忘录将状态复原
 */
object TestMemento {

    def main(args: Array[String]): Unit = {
        val originator = new Originator
        originator.state = "on"
        originator.show()

        val caretaker = new Caretaker
        caretaker.memento = originator.createMemento

        originator.state = "off"
        originator.show()

        originator.setMemento(caretaker.memento)
        originator.show()
    }
}
