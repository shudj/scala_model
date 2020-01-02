package com.ade.scala.json

import org.json4s.JsonDSL._
import org.json4s.jackson.JsonMethods._
/**
  * @author: shudj
  * @time: 2020/1/2 10:45
  * @description:
  */
object Demo2 extends App {

    case class Winner(id: Long, numbers: List[Int])
    case class Lotto(id: Long, winningNumbers: List[Int], winners: List[Winner], drawDate: Option[java.util.Date])

    val winners = List(Winner(23, List(2, 45, 34)), Winner(54, List(52, 3, 56)))
    val lotto = Lotto(5, List(2, 45, 34), winners, None)

    val json = (
        "lotto" ->
            ("lotto-id" -> lotto.id) ~
            ("winning-numbers" -> lotto.winningNumbers) ~
            ("draw-date" -> lotto.drawDate.map(_.toString)) ~
            ("winners" ->
                lotto.winners.map(w =>
                    (
                        ("winner-id" -> w.id) ~
                        ("numbers" -> w.numbers)
                    )
                )
            )
        )
    println(pretty(render(json)))
}
