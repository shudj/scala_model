package com.ade.model.interpreter
import scala.collection.immutable

/**
  * 解释器模式（interpreter）：给定一个语言，定义它的语法的一种表示，并定一个解释器，这个解释器使用该表示来解释语言中的句子
  *     如果一种特定类型的问题发生频率足够高，那么可能就值得将该问题的各个实例表述为一个简单语言中的句子，这样就可以构建一个解释器，
  *     该解释器通过解释这些句子来解决该问题
  *
  *  当有一个语言需要解释执行，并且你可将该语言中的句子表示为一个抽象语法树时，可使用解释器模式
  *  使用了解释器，就意味着很容易改变和扩展语法，因为该模式使用类来表示语法规则，你可使用继承来改变或扩展该语法，也比较容易实现语法，因为
  *  定义了抽象语法树中各个节点类的实现大体类似，这些都易于直接编写
  *
  *  不足：
  *     解释器模式为语法中的每一条规则至少定义了一个类，因此包含许多规则的语法可能难以管理和维护
  *     建议语法非常复杂时，使用其他技术如语法分析器或编译器生成来处理
  */
object TestInterpreter {

    def main(args: Array[String]): Unit = {
        val context = new Context
        var list: immutable.Seq[Expression] = List[Expression]()

        list = list :+ (new TerminalExpression)
        list = list :+ (new NonTerminalExpression)
        list = list :+ (new TerminalExpression)
        list = list :+ (new TerminalExpression)

        list.foreach(_.interpret(context))
    }
}
