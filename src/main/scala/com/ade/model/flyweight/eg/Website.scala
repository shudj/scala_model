package com.ade.model.flyweight.eg

/**
  * @author: shudj
  * @time: 2019/11/27 9:37
  * @description:
  */
trait Website {

    def user(user: User): Unit
}

class WebsiteImpl extends Website {

    private var name: String = _
    def this(name: String) = {
        this
        this.name = name
    }

    override def user(user: User): Unit = println(s"网站分类：$name，用户为：${user.name}")
}