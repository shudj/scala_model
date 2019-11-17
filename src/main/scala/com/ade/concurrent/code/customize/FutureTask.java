package com.ade.concurrent.code.customize;

public class FutureTask<T> implements Runnable, Future<T> {

    private Callable<T> callable;

    private T result;

    private Object notify;

    public FutureTask(Callable<T> callable) {
        this.callable = callable;
        notify = new Object();
    }

    public T get() throws InterruptedException {
        synchronized (notify) {
            while (null == result) {
                notify.wait();
            }

            return result;
        }
    }

    public void run() {

        T call = callable.call();
        this.result = call;
        synchronized (notify) {
            notify.notify();
        }
    }
}
