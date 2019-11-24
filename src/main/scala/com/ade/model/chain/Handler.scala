package com.ade.model.chain

abstract class Handler {

    protected var successor: Handler = _

    def setSuccessor(successor: Handler) = {
        this.successor = successor
    }

    /**
     * 处理请求抽象方法
     * @param request
     */
    def handleRequest(request: Int)
}

class ConcreteHandler1 extends Handler {

    /**
     * 处理请求抽象方法
     *
     * @param request
     */
    override def handleRequest(request: Int): Unit = {
        if (request >= 0 && request < 10) {
            println(s"${this.getClass.getName}：处理请求${request}")
        // 转移到下一位
        } else if (null != successor) {
            successor.handleRequest(request)
        }
    }
}

class ConcreteHandler2 extends Handler {
    /**
     * 处理请求抽象方法
     *
     * @param request
     */
    override def handleRequest(request: Int): Unit = {
        if (request >= 10 && request < 20) {
            println(s"${this.getClass.getName}：处理请求${request}")
        } else if (null != successor) {
            successor.handleRequest(request)
        }
    }
}

class ConcreteHandler3 extends Handler {
    /**
     * 处理请求抽象方法
     *
     * @param request
     */
    override def handleRequest(request: Int): Unit = {
        if (request >= 20 && request < 30) {
            println(s"${this.getClass.getName}：处理请求${request}")
        } else if (null != successor) {
            successor.handleRequest(request)
        }
    }
}