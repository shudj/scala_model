package com.ade.model.composite

abstract class Component(name: String) {

    def add(component: Component)

    def remove(component: Component)

    def display(depth: Int)
}
