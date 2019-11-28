package com.ade.model.visitor

/**
  * 访问者模式（Visitor）：表示一个作用于某对象结构中的各元素的操作，它使你可以在改变各元素的类的前提下定义作用于这些元素的新操作
  *
  * 访问者模式适用于数据结果相对的稳定的系统
  * 他把数据结构作用于结构上的操作之间的耦合解脱开，使得操作集合可以相对自由地演化
  * 访问者模式的目的是要把处理从数据结构分离出来。
  * 有比较稳定的数据结构，又有易于变化的算法的话，使用访问者模式就是比较合适的，因为访问者模式使得算法操作的增加变得容易
  *
  * 访问者模式的有点就是增加新的操作很容易，因为增加新的操作就意味着增加一个新的访问者。访问者模式将有关的行为集中到一个访问者对象中
  * 缺点：就是增加新的数据结构变得困难了
  */
object TestVisitor {

    def main(args: Array[String]): Unit = {
        val structure = new ObjectStructure
        structure.add(new ConcreteElementA)
        val b = new ConcreteElementB
        structure.add(b)

        structure.accept(new ConcreteVisitor1)

        structure.remove(b)

        structure.accept(new ConcreteVisitor2)
    }
}
