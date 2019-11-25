package com.ade.model.mediator

/**
  * 中介者模式（mediator）：用一个中介对象来封装一些列的对象交互。中介者使个对象不需要显示地相互引用，从而使其耦合松散
  *     而且可以独立地改变它们之间的交互
  *
  * 优缺点：
  *     中介者模式很容易在系统中应用，也很容易在系统中误用，当系统出现了““”“”"多对多"交互复杂的对象群时，不要急于使用中介者模式，而要先反思你的
  *     系统在设计是不是合理
  *     中介者的出现减少了各个Colleague的耦合，使得可以独立地改变和复用各个Colleague类何Mediator，
  *     其次，由于把对象如何协作进行了抽象，将中介作为一个独立的概念并将其封装在一个对象中，这样关注的对象就从对象各自本身的行为转移到它们之间
  *     的交互上来，也就是站在一个更宏观的角度去看待系统
  *     由于ConcreteMediator控制了集中化，于是就把交互复杂性变为中介者的复杂性，这就使得中介者会变得比任何一个ConcreteColleague都复杂
  *
  *     中介者模式一般用于一组对象以定义良好但是复杂的方式进行通信的场合，以及想定制一个分布式在对个类中的行为，而又不想生成太多的子类的场合
  */
object TestMediator {

    def main(args: Array[String]): Unit = {
        val mediator = new ConcreteMediator

        val c1 = new ConcreteColleague1(mediator)
        val c2 = new ConcreteColleague2(mediator)

        mediator.colleague1 = c1
        mediator.colleague2 = c2

        c1.send("吃了饭了吗？")
        c2.send("还没有，怎么准备情况?")
    }
}
