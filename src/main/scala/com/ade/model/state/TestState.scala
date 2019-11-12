package com.ade.model.state

object TestState {

    def main(args: Array[String]): Unit = {
        val work = new Work
        work.hour = 9
        work.writeProgram
        work.hour = 10
        work.writeProgram
        work.hour = 12
        work.writeProgram
        work.hour = 13
        work.writeProgram
        work.hour = 14
        work.writeProgram
        work.hour = 17
        work.writeProgram
        work.finish = true
        work.writeProgram
        work.hour = 19
        work.writeProgram
    }
}
