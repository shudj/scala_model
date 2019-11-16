package com.ade.model.memento

/**
 * Originator（发起人）：负债创建一个备忘录Memento，用以记录当前时刻它的内部状态，并可使用备忘录恢复内部状态。Originator可根据需要决定
 *  Memento存储Originator的哪些内部状态
 */
class Originator {

    var state: String = _

    def createMemento: Memento = new Memento(state)

    def setMemento(memento: Memento): Unit = state = memento.state

    def show(): Unit = println(s"State = $state")
}
