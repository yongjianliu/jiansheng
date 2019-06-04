package com.guoyunyu.jiansheng.my.ThreadReact;



/**
 * 死锁模拟
 * 死锁线程不占用CPU
 *
 * @author Yongjian.Liu
 * @date 2019/4/3 9:23
 */
public class DeadLockTest extends Thread {
    Object tool;
    static Object fork1 = new Object();
    static Object fork2 = new Object();

    public DeadLockTest(Object obj) {
        this.tool = obj;
        if (tool == fork1) {
            this.setName("artest A");
        }
        if (tool == fork2) {
            this.setName("artest B");
        }

    }

    @Override
    public void run() {
        //持有锁A 等待锁B
        if (tool == fork1) {
            synchronized (fork1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (fork2) {
                    System.out.println("artest A eating");
                }

            }


        }

        //持有锁B等待锁A
        if (tool == fork2) {
            synchronized (fork2) {
                try {
                    //保证能获取锁
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (fork1) {
                    System.out.println("artest B eating");
                }

            }


        }
    }


    public static void main(String[] args) throws Exception {
        DeadLockTest artestA = new DeadLockTest(fork1);
        DeadLockTest artestB = new DeadLockTest(fork2);

        artestA.start();
        artestB.start();
        artestA.join();
        artestB.join();

        System.out.println("done");

    }
}
