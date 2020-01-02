package com.ade.scala.json

import org.json4s.JsonAST
import org.json4s._
import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._

/**
  * @author: shudj
  * @time: 2020/1/2 11:42
  * @description:
  */
object Demo4 {

    val map: (String, JsonAST.JObject) =
        ("person" ->
            ("name" -> "Joe") ~
                ("age" -> 35) ~
                ("spouse" ->
                    ("person" ->
                        ("name" -> "Marilyn") ~
                            ("age" -> 33)
                        )
                    )
            )
    val json = render(map)

    def main(args: Array[String]): Unit = {
        test2()
    }

    def test1(): Unit = {
        // JObject(List((person,JObject(List((name,JString(Marilyn)), (age,JInt(33)))))))
        var value = json \\ "spouse"
        // {"person":{"name":"Marilyn","age":33}}
        var str = compact(render(value))

        // {"name":"Joe","name":"Marilyn"}
        val name = compact(render(json \\ "name"))
        // "Joe"
        val str_name = compact(render((json removeField { _ == JField("name", JString("Marilyn")) }) \\ "name"))
        // "Joe"
        val str_name1 = compact(render(json \ "person" \ "name"))
        // Marilyn
        val str_name2 = compact(render(json \ "person" \ "spouse" \ "person" \ "name"))

        // Some((name,JString(Joe)))
        val maybeField = json findField {
            case JField("name", _) => true
            case _ => false
        }

        // List((name,JString(Joe)), (name,JString(Marilyn)))
        val fields = json filterField {
            case JField("name", _) => true
            case _ => false
        }

        /**
          * JObject(
          *     List(
          *         (person,JObject(List((NAME,JString(JOE)), (age,JInt(35)), (spouse,JObject(List((person,JObject(List((NAME,JString(MARILYN)), (age,JInt(33)))))))))))))
          */
        value = json transformField {
            case JField("name", JString(s)) => ("NAME", JString(s.toUpperCase))
        }

        // Map(person -> Map(name -> Joe, age -> 35, spouse -> Map(person -> Map(name -> Marilyn, age -> 33))))
        println(json.values)
    }

    def test2(): Unit = {
        val js = parse("""
         { "name": "joe",
           "children": [
             {
               "name": "Mary",
               "age": 5
             },
             {
               "name": "Mazy",
               "age": 3
             }
           ]
         }
       """)
        // JObject(List((name,JString(Mary)), (age,JInt(5))))
        var value = (js \ "children")(0)
        // JString(Mazy)
        value = (js \ "children")(1) \ "name"
        // List(5, 3)
        val int = js \\ classOf[JInt]
        // List(Mary, Mazy)
        val str = js \ "children" \\ classOf[JString]
        println(str)
    }
}
