package com.ade.model.observer

import scala.collection.mutable.ArrayBuffer

abstract class Subject {

    private val observers = ArrayBuffer[Observer]()

    /**
     * 增加观察者
     * @param observer  观察者
     */
    def attach(observer: Observer): Unit = observers += observer

    /**
     *  删除观察者
     * @param observer  观察者
     */
    def detach(observer: Observer): Unit = observers -= observer

    def notifyObserver(): Unit = {
        observers.foreach(_.update)
    }
}
