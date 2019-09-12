package com.ade.concurrent.code.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author: shudj
 * @time: 2019/9/11 11:00
 * @description:
 */
public class WaitNotify {
    static boolean flag = true;
    static Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread waitThread = new Thread(new Wait(), "WaitThread");
        waitThread.start();
        TimeUnit.SECONDS.sleep(1);
        Thread notifyThread = new Thread(new Notify(), "NotifyThread");
        notifyThread.start();
    }

    static class Wait implements Runnable {

        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized(lock) {
            // 当条件不满足时，继续wait，同时释放了lock的锁
            while (flag) {
                try {
                    System.out.println(Thread.currentThread() + " flag is true. wait @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    lock.wait();
                } catch (Exception e) {

            }
            // 条件满足时，完成工作
            System.out.println(Thread.currentThread() + " flag is false. wait @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
            }
        }
        }
    }

    static class Notify implements Runnable {
        @Override
        public void run() {
            // 加锁，拥有lock的Monitor
            synchronized(lock) {
                try {
                    // 获取lock的锁，然后通知，通知时不会释放lock的锁，直至当前线程释放了lock后，WaitThread才能从wait方法中返回
                    System.out.println(Thread.currentThread() + " hold lock. notify @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    lock.notifyAll();
                    flag = false;
                    Thread.sleep(5);
                } catch (Exception e) {

                }
            }
            synchronized(lock) {
                try {
                    System.out.println(Thread.currentThread() + " hold lock again. notify @ " + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                    Thread.sleep(5);
                } catch (Exception e) {

                }
            }
        }
    }
}
