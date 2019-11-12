package com.ade.model.observer

/**
 * 观察者模式特点：
 *     将一个系统分割成一系列相互协作的类有一个很不好的副作用，那就是需要维护相关对象间的一致性。我们不希望为了维持一致性而使各类紧密耦合，
 *     这样会给维护、扩展和重用都带来不便
 *
 * 使用场景：
 *     但一个对象的改变需要同时改变其他对象的时候，而且它不知道具体有多少对象有改变时，应该考虑使用观察者模式
 *     当一个抽象模型有两个方面，其中一个方面依赖于另一个方面，这时用观察者模式可以将这两者封装在独立的对象中使它们各自独立地改变和复用
 *     总的来说，观察者模式所做的工作其实就是在解耦合，让耦合的双方都依赖于抽象，而不是依赖于具体，从而使得各自的变化都不会影响另一边的变化
 */
object TestObserver {

    def main(args: Array[String]): Unit = {
        val subject = new ConcreteSubject
        val y = new ConcreteObserver(subject, "Y")
        subject.attach(new ConcreteObserver(subject, "X"))
        subject.attach(y)
        subject.attach(new ConcreteObserver(subject, "Z"))

        subject.subjectState = "ABC"

        subject.detach(y)
        subject.notifyObserver()
    }
}