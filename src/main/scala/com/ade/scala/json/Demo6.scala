package com.ade.scala.json

import org.json4s.JsonAST.{JArray, JInt, JObject}
import org.json4s.Xml._
import org.json4s.jackson.JsonMethods._
/**
  * @author: shudj
  * @time: 2020/1/2 14:44
  * @description:
  */
object Demo6 {

    def main(args: Array[String]): Unit = {
        xml2json()
    }

    def xml2json(): Unit = {
        val xml =
            <users>
                <user>
                    <id>1</id>
                    <name>Harry</name>
                </user>
                <user>
                    <id>2</id>
                    <name>David</name>
                </user>
            </users>

        val value = toJson(xml)

        /**
          * {
          * "users" : {
          * "user" : [ {
          * "id" : "1",
          * "name" : "Harry"
          * }, {
          * "id" : "2",
          * "name" : "David"
          * } ]
          * }
          * }
          */
        println(pretty(render(value)))

        value transformField {
            case ("id", org.json4s.JsonAST.JString(s)) => ("id", JInt(s.toInt))
            case ("user", x: JObject) => ("user", JArray(x :: Nil))
        }
        // <users><user><id>1</id><name>Harry</name></user><user><id>2</id><name>David</name></user></users>
        println(toXml(value))
    }

}
