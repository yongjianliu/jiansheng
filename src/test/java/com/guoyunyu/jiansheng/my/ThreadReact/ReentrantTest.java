package com.guoyunyu.jiansheng.my.ThreadReact;


import java.util.concurrent.locks.ReentrantLock;

/**
 * 重入锁校验
 *
 * @author Yongjian.Liu
 * @date 2019/1/15 16:02
 */
public class ReentrantTest implements Runnable {
    public static ReentrantLock lock = new ReentrantLock();


    public static int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 1000000; i++) {
            try {
                lock.lock();
                count++;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws Exception {
        ReentrantTest reentrantTest = new ReentrantTest();
        Thread t1 = new Thread(reentrantTest);
        Thread t2 = new Thread(reentrantTest);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(count);
    }
}
