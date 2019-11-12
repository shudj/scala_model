package com.ade.model.state

class Work {

    var hour: Int = 0
    var state: State = new ForenoonState
    var finish: Boolean = false

    def writeProgram = state.writeProgram(this)
}
