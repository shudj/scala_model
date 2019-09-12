package com.ade.concurrent.code.thread.sqlpool

import java.lang.reflect.{InvocationHandler, Method, Proxy}
import java.sql.Connection
import java.util.concurrent.TimeUnit

/**
  * @author: shudj
  * @time: 2019/9/12 9:32
  * @description:
  */

class ConnectionDriver {

}
object ConnectionDriver {

    class ConnectionHandler extends InvocationHandler {
        override def invoke(proxy: Any, method: Method, args: Array[AnyRef]): AnyRef = {
            if (method.getName.equals("commit")) {
                TimeUnit.MILLISECONDS.sleep(100)
            }

            null
        }
    }

    def createConnection(): Connection = {
        Proxy.newProxyInstance(classOf[ConnectionDriver].getClassLoader, Array[Class[_]](classOf[Connection]), new ConnectionHandler).asInstanceOf[Connection]
    }
}
