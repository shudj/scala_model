package com.ade.model.flyweight.eg

/**
  * @author: shudj
  * @time: 2019/11/27 9:56
  * @description:
  */
import scala.collection._
class WebsiteFactory {

    private var flyweights = mutable.Map[String, Website]()

    def getWebsiteCategory(key: String): Website = {
        if (!flyweights.contains(key)) {
            flyweights = flyweights + (key -> new WebsiteImpl(key))
        }

        flyweights.get(key).orNull
    }

    def getWebsiteCount(): Int = flyweights.size
}
