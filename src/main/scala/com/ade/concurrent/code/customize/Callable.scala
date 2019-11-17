package com.ade.concurrent.code.customize

trait Callable[T] {

    /**
     * 执行任务
     * @return  执行结果
     */
    def call: T
}
