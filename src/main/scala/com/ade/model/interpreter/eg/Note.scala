package com.ade.model.interpreter.eg

/**
  * @author: shudj
  * @time: 2019/11/27 11:08
  * @description:
  */
class Note extends Expression {
    override def execute(str: String, d: Double): Unit = {
        val note = str match {
            case "C" => 1
            case "D" => 2
            case "E" => 3
            case "F" => 4
            case "G" => 5
            case "A" => 6
            case "B" => 7
            case _ => -1
        }

        print(note + " ")
    }
}
