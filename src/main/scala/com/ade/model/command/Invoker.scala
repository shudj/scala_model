package com.ade.model.command

/**
  * @author: shudj
  * @time: 2019/11/22 17:57
  * @description:
  */
class Invoker {

    var command: Command = _

    def executeCommand: Unit = command.execute
}
