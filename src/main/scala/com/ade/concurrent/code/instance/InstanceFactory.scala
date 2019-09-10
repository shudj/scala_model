package com.ade.concurrent.code.instance

/**
  * @author: shudj
  * @time: 2019/9/10 17:26
  * @description:
  */
object InstanceFactory {

    private object InstanceHolder {
        var instance = new Instance
    }

    def getInstance: Instance = { // 这将导致InstanceHolder类被初始化
        InstanceHolder.instance
    }
}