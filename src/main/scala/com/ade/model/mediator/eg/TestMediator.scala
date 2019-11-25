package com.ade.model.mediator.eg

/**
  * @author: shudj
  * @time: 2019/11/25 16:55
  * @description:
  */
object TestMediator {

    def main(args: Array[String]): Unit = {
        val UNSC = new UniteNationsSecurityCouncil

        val usa = new USA(UNSC)
        val iraq = new Iraq(UNSC)

        UNSC.usa = usa
        UNSC.iraq = iraq

        usa.declare("不准研制核武器，否则发动战争")
        iraq.declare("我们没有核武器，也不怕侵略")
    }
}
