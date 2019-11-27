package com.ade.model.interpreter.eg

/**
  * @author: shudj
  * @time: 2019/11/27 11:14
  * @description:
  */
object TestMusic {

    def main(args: Array[String]): Unit = {
        val context = new PlayContext
        println("上海滩：")
        context.text = "O 2 E 0.5 G 0.5 A 3 E 0.5 G 0.5 D 3 E 0.5 G 0.5 A 0.5 C 3 C 1 O 2 A 0.5 G 1 C 0.5 E 0.5 D 3 "

            while (context.text.length > 0) {
                val str = context.text.substring(0, 1)
                val expression = str match {
                    case "O" => new Scale
                    case "A" => new Note
                    case "B" => new Note
                    case "C" => new Note
                    case "D" => new Note
                    case "E" => new Note
                    case "F" => new Note
                    case "G" => new Note
                    case "P" => new Note
                }
                expression.interpret(context)
            }
    }
}
