package com.ade.scala.json

import org.json4s.JValue
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._
/**
  * @author: shudj
  * @time: 2020/1/2 10:09
  * @description:
  */
object Demo1 {
    def main(args: Array[String]): Unit = {
        json_map4()
    }

    def json_list(): Unit = {

        val json_list = List(1, 2, 3)
        // JArray(List(JInt(1), JInt(2), JInt(3)))
        val jValue = render(json_list)
        println(jValue)
        // [1,2,3]
        val str = compact(jValue)
        println(str)
    }

    def json_map(): Unit = {
        val map = ("name" -> "ade")
        // JObject(List((name,JString(ade))))
        val jValue: JValue = render(map)
        println(jValue \ "name")
        // {"name":"ade"}
        val str: String = compact(jValue)
        println(str)
    }

    def json_map2(): Unit = {
        val map = ("name" -> "ade") ~ ("age" -> 18)
        // JObject(List((name,JString(ade)), (age,JInt(18))))
        val jValue = render(map)
        println(jValue)
        // {"name":"ade","age":18}
        val str = compact(jValue)
        println(str)
    }

    def json_map3(): Unit = {
        val map = ("name" -> "ade") ~ ("age" -> Some(18))
        // JObject(List((name,JString(ade)), (age,JInt(18))))
        val jValue = render(map)
        println(jValue)
        // {"name":"ade","age":18}
        val str = compact(jValue)
        println(str)
    }

    def json_map4(): Unit = {
        val map = ("name" -> "ade") ~ ("age" -> (None: Option[Int]))
        // JObject(List((name,JString(ade)), (age,JNothing)))
        val jValue = render(map)
        println(jValue)
        // {"name":"ade"}
        val str = compact(jValue)
        println(str)
    }
}
