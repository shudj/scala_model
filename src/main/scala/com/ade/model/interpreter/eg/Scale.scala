package com.ade.model.interpreter.eg

/**
  * @author: shudj
  * @time: 2019/11/27 11:11
  * @description:
  */
class Scale extends Expression {
    override def execute(str: String, d: Double): Unit = {
        var scale = d match {
            case 1.0 => "低音"
            case 2.0 => "中音"
            case 3.0 => "高音"
            case _ => "节拍"
        }

        print(scale + " ")
    }
}
