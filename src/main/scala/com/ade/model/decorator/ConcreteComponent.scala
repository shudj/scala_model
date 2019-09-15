package com.ade.model.decorator

class ConcreteComponent extends Component {
    override def operation(): Unit = println("具体对象的操作")
}
