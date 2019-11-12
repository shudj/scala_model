package com.ade.model.state

/**
 * 上午上班状态
 */
class ForenoonState extends State {
    override def writeProgram(work: Work): Unit = {
        if (work.hour < 12) {
            println(s"当前时间：${work.hour}点，上午工作精神百倍")
        } else {
            work.state = new NoonState
            work.writeProgram
        }
    }
}

/**
 * 中午午休状态
 */
class NoonState extends State {
    override def writeProgram(work: Work): Unit = {
        if (work.hour < 13) {
            println(s"当前时间：${work.hour}点，饿了，午饭；犯困，午休。")
        } else {
            work.state = new AfternoonState
            work.writeProgram
        }
    }
}

/**
 * 下午上班状态
 */
class AfternoonState extends State {
    override def writeProgram(work: Work): Unit = {
        if (work.hour < 17) {
            println(s"当前时间：${work.hour}点，下午状态不错，继续努力")
        } else {
            work.state = new EveningState
            work.writeProgram
        }
    }
}

/**
 * 夜晚加班状态
 */
class EveningState extends State {
    override def writeProgram(work: Work): Unit = {
        if (work.finish) {
            work.state = new RestState
            work.writeProgram
        } else if (work.hour < 21){
            println(s"当前时间：${work.hour}点，加班哦，疲累之极")
        } else {
            work.state = new SleepingState
            work.writeProgram
        }
    }
}

/**
 * 睡觉了
 */
class SleepingState extends State {
    override def writeProgram(work: Work): Unit = {
        println(s"当前时间：${work.hour}点，不行了，该睡觉了")
    }
}

/**
 * 下班了，工作完成了
 */
class RestState extends State {
    override def writeProgram(work: Work): Unit = println(s"当前时间：${work.hour}点，下班回家了")
}