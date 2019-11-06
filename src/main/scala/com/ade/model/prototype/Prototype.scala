package com.ade.model.prototype

object Prototype {

    def main(args: Array[String]): Unit = {
        val wsq = new Resume("wsq", 18)
        wsq.work = new WorkExperience("2019-11-06", "BTJ")

        val wsq1: Resume = wsq.clone().asInstanceOf[Resume]
        wsq1.work = new WorkExperience("2019-08-10", "WY")

        val wsq2: Resume = wsq.clone().asInstanceOf[Resume]
        wsq2.age = 28
        wsq2.work = new WorkExperience("2019-07-10", "nicai")

        println(wsq)
        println(wsq1)
        println(wsq2)
    }
}
