package com.ade.model.prototype

class Resume {
    var name: String = _
    var age: Int = _
    var work: WorkExperience = _
    def this(name: String, age: Int) = {
        this
        this.name = name
        this.age = age
    }

    def this(work: WorkExperience) = {
        this
        this.work = work
    }

    override def toString: String = {
        "[" + "name: " + this.name + ", age: " + this.age + ", work: " + work + "]"
    }

    override def clone(): AnyRef = {
        val res = new Resume(this.work)
        res.name = this.name
        res.age = this.age
        res
    }
}
