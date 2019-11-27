package com.ade.model.interpreter

/**
  * 声明一个抽象的解释操作，这个接口为抽象语法树中所有的节点共享
  */
trait Expression {

    def interpret(context: Context)
}

/**
  * TerminalExpression（终结符表达式），实现与语法中的终结符县关联的解释操作
  * 实现抽象表达式中所要求的接口，主要是一个interpret方法，语法中每一个终结符都有一个具体终结表达式与之相对应
  */
class TerminalExpression extends Expression {
    override def interpret(context: Context): Unit = println("终端解释器")
}

/**
  * NonTerminalExpression（非终结符表达式）：为语法中的非终结符实现解释操作
  * 对语法中每一条规则R1、R2······Rn都需要一个具体的非终结符表达式类，通过实现抽象表达式的interpret方法实现解释操作
  */
class NonTerminalExpression extends Expression {
    override def interpret(context: Context): Unit = println("非终端解释器")
}