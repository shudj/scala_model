package com.ade.model.build

import java.util

class Product {

    private val parts = new util.ArrayList[String]()

    def add(part: String) = parts.add(part)

    def show = {
        println("产品 创建-------")
        parts.forEach(println)
    }
}
