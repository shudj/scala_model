package com.ade.model.interpreter.eg

/**
  * @author: shudj
  * @time: 2019/11/27 10:57
  * @description:
  */
trait Expression {

    def interpret(context: PlayContext): Unit = {
        if (context.text.isEmpty) return
        else {
            val text = context.text.substring(0, 1)
            context.text = context.text.substring(2)
            val i = context.text.indexOf(" ")
            val value = context.text.substring(0, i).toDouble
            context.text = context.text.substring(i + 1)

            execute(text, value)
        }
    }

    def execute(str: String, d: Double)
}
