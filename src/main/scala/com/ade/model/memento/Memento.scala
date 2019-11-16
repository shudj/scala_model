package com.ade.model.memento

/**
 * Memento（备忘录）：负债存储Originator对象的内部状态，可防止Originator以外的其他对象访问备忘录Memento。备忘录有两个接口，Caretaker
 *  只能看到备忘录的窄接口，它只能将备忘录传递给其他对象。Originator能够看到一个宽接口，允许它访问返回到先前状态所需的所有数据
 */
class Memento {

    var state: String = _

    def this(state: String) = {
        this
        this.state = state
    }
}
