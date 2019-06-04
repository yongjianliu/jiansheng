package com.guoyunyu.jiansheng.my.ThreadReact;


/**
 * 计数时，不要同步Integer类型，Integer是不可变
 *
 * @author Yongjian.Liu
 * @date 2019/1/15 15:31
 */
public class CountTest {
    public static Integer count = 0;
    public static Object lock = new Object();

    static class InnerThread implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 1000000; i++) {
                synchronized (count) {
                    count++;
                }
            }
        }
    }

    

    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(new CountTest.InnerThread());
        Thread t2 = new Thread(new CountTest.InnerThread());
        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(count);

    }

}
