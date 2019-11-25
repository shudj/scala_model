package com.ade.model.mediator.eg

/**
  * @author: shudj
  * @time: 2019/11/25 16:46
  * @description:
  */
trait UniteNations {

    def declare(message: String, country: Country)
}

class UniteNationsSecurityCouncil extends UniteNations {

    var usa: USA = _
    var iraq: Iraq = _

    override def declare(message: String, country: Country): Unit = {
        if (country.equals(usa)) {
            iraq.getMessage(message)
        } else {
            usa.getMessage(message)
        }
    }
}