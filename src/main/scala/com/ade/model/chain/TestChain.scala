package com.ade.model.chain

/**
 * 职责链模式（chain of responsibility）：使多个对象都有机会处理请求，从而避免请求的发送者和接收者之间的耦合关系。将这个对象连成
 *      一条链，并沿着这条链传递该请求，直到有一个对象处理它为止
 *
 * 优点：
 *      当客户提交一个请求时，请求是沿链传递直至有一个ConcreteHandler对象负责处理它
 *      这使得接受者和发送者都没有对方的明确信息，且链中的对象自己也并不知道链的结构。
 *      结果是职责链可简化对象的相互连接，它们仅需保持一个指向其后继者的引用，而不需保持它所有的候选接受者的引用
 *      随时地增加或修改处理一个请求的结构，增强了给对象指派职责的灵活性
 *
 *      不过需要当心，一个请求极有可能到了链的末端都得不到处理，或者因为没有正确配置而得不到处理
 */
object TestChain {

    def main(args: Array[String]): Unit = {
        val h1 = new ConcreteHandler1
        val h2 = new ConcreteHandler2
        val h3 = new ConcreteHandler3

        h1.setSuccessor(h2)
        h2.setSuccessor(h3)

        val requests = Array(2, 5, 14, 23, 4, 27)

        requests.foreach(h1.handleRequest(_))
    }
}
