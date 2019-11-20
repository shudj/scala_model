package com.ade.scala

/**
  * @author: shudj
  * @time: 2019/11/18 14:29
  * @description:
  */
object Study_Either {

    def main(args: Array[String]): Unit = {

        val result = (a: String) => {
            try {
                Right(a.toInt)
            } catch {
                case e: Exception => Left(a)
            }
        }

        println(result("9"))
        println(result("b"))
    }
}
