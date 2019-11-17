package com.ade.concurrent.code.customize

trait Future[T] {

    @throws[InterruptedException] def get: T
}
