package com.ade.model.flyweight.eg

/**
  * @author: shudj
  * @time: 2019/11/27 10:00
  * @description:
  */
object TestWebsite {

    def main(args: Array[String]): Unit = {
        val factory = new WebsiteFactory
        val fx = factory.getWebsiteCategory("产品展示")
        fx.user(new User("wsq"))

        val fy = factory.getWebsiteCategory("博客")
        fy.user(new User("ade"))

        val fz = factory.getWebsiteCategory("博客")
        fz.user(new User("wsq"))

        println(s"网站总数为：${factory.getWebsiteCount()}")
    }

}
