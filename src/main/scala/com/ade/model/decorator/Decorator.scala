package com.ade.model.decorator

abstract class Decorator extends Component {

    protected var component: Component = null

    def setComponent(component: Component): Unit = {
        this.component = component
    }

    override def operation(): Unit = {
        if (null != component) {
            component.operation()
        }
    }
}
