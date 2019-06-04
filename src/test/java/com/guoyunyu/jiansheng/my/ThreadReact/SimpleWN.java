package com.guoyunyu.jiansheng.my.ThreadReact;

/**
 * wait and notify
 *
 * @author Yongjian.Liu
 * @date 2019/1/7 17:07
 */
public class SimpleWN {
    public static final Object object = new Object();

   static  class T1 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + ": start");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + ": end");
            }
        }
    }


    static class T2 extends Thread {
        @Override
        public void run() {
            synchronized (object) {
                System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + ": start");
                object.notify();
                System.out.println(System.currentTimeMillis() + Thread.currentThread().getName() + ": end");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
