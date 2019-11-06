package com.ade.model.prototype

class WorkExperience {
    var workDate: String = _
    var company: String = _
    def this(workDate: String, company: String) = {
        this
        this.workDate = workDate
        this.company = company
    }
    override def clone(): AnyRef = super.clone()

    override def toString: String = {
        "[worDate: " + this.workDate + ", company: " + this.company + "]"
    }
}
