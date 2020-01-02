package com.ade.scala.json

import java.text.SimpleDateFormat

import org.json4s.DefaultFormats
import org.json4s._
import org.json4s.jackson.JsonMethods._
/**
  * @author: shudj
  * @time: 2020/1/2 14:22
  * @description:
  */
object Demo5 extends App {

    //implicit val format = DefaultFormats
    implicit val format = new DefaultFormats {
        override def dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")
    }
    case class Child(name: String, age: Int, birthdate: Option[java.util.Date])
    case class Address(street: String, city: String)
    case class Person(name: String, address: Address, children: List[Child])

    val json = parse("""
         { "name": "joe",
           "address": {
             "street": "Bulevard",
             "city": "Helsinki"
           },
           "children": [
             {
               "name": "Mary",
               "age": 5,
               "birthdate": "2004-09-04T18:06:22Z"
             },
             {
               "name": "Mazy",
               "age": 3
             }
           ]
         }
       """)
    // Person(joe,Address(Bulevard,Helsinki),List(Child(Mary,5,Some(Sun Sep 05 02:06:22 CST 2004)), Child(Mazy,3,None)))
    private val person: Person = json.extract[Person]
    println(person)
}
