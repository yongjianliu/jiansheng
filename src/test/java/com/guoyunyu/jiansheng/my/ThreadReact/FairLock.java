package com.guoyunyu.jiansheng.my.ThreadReact;

import javax.security.auth.login.FailedLoginException;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 公平锁实现线程的交替执行
 *
 * @author Yongjian.Liu
 * @date 2019/1/15 16:39
 */
public class FairLock implements Runnable {
    public static ReentrantLock reentrantLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true) {
            try {
                reentrantLock.lock();
                System.out.println(Thread.currentThread().getName() + "获得锁");
            } finally {
                reentrantLock.unlock();
            }

        }
    }

    public static void main(String[] args) throws Exception {
        FairLock fairLock = new FairLock();
        Thread t1 = new Thread(fairLock, "thread_t1");
        Thread t2 = new Thread(fairLock, "thread_t2");
        t1.start();
        t2.start();
    }
}
