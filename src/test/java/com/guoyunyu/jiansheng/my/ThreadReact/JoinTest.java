package com.guoyunyu.jiansheng.my.ThreadReact;



/**
 * join test  线程加入等待
 * 顺序输出ABC
 *
 * @author Yongjian.Liu
 * @date 2019/1/8 17:12
 */
public class JoinTest {
    public volatile static int i = 0;

    public static void main(String[] args) throws Exception {
        Thread3 t3 = new Thread3();
        t3.start();
    }


    public static class Thread1 extends Thread {
        @Override
        public void run() {
            System.out.println("A");
        }
    }

    public static class Thread2 extends Thread {
        @Override
        public void run() {
            Thread1 t1 = new Thread1();
            t1.start();
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");

        }
    }

    public static class Thread3 extends Thread {
        @Override
        public void run() {
            Thread2 t2 = new Thread2();
            t2.start();
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("C");
        }

    }
}
