package com.ade.scala.json

import com.ade.scala.json.Demo2.Lotto
import org.json4s.{DefaultFormats, JValue}
import org.json4s.jackson.JsonMethods._
/**
  * @author: shudj
  * @time: 2020/1/2 11:05
  * @description:
  */
object Demo3 extends App {

    val lott1 = parse(
        """
          |{
          |  "lotto" : {
          |    "lotto-id" : 5,
          |    "winning-numbers" : [ 2, 45, 34 ],
          |    "winners" : [ {
          |      "winner-id" : 23,
          |      "numbers" : [ 2, 45, 34 ]
          |    }, {
          |      "winner-id" : 54,
          |      "numbers" : [ 52, 3, 56 ]
          |    } ]
          |  }
          |}
          |
          |Process finished with exit code 0
          |
        """.stripMargin)
    val lott2 = parse(
        """
          |{
          |   "lotto": {
          |     "winners":[{
          |         "winner-id":35,
          |         "numbers": [34, 57, 89]
          |     }]
          |   }
          |}
        """.stripMargin)
    val meg = lott1 merge lott2
    //println(pretty(render(meg)))
    private val jValue: JValue = meg \\ "winners"
    /**
      * [{"winner-id":23,"numbers":[2,45,34]},
      * {"winner-id":54,"numbers":[52,3,56]},
      * {"winner-id":35,"numbers":[34,57,89]}]
      */
    //private val str: String = compact(render(jValue))
    // [23,54,35]
    private val value: JValue = meg \ "lotto" \ "winners" \ "winner-id"
    //private val str1: String = compact(render(value))
    println(meg.values)

    implicit val format = DefaultFormats
    // 字段要一一对应上
    private val lotto: Lotto = meg.extract[Lotto]
    println(lotto)
}
