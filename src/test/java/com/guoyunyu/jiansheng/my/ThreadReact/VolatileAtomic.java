package com.guoyunyu.jiansheng.my.ThreadReact;

/**
 * Volatile原子性验证
 *
 * 值覆盖，得到的最终结果，会小于20000
 *
 * @author Yongjian.Liu
 * @date 2019/1/14 14:48
 */
public class VolatileAtomic {
    public volatile static int count = 0;

    private static class CountThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                count++;
            }
        }
    }

    public static void main(String[] args) throws  Exception{
        Thread t1 = new Thread(new CountThread(),"thread1");
        Thread t2 = new Thread(new CountThread(),"thread2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        //保证了两个线程执行完毕后 才输出结果
        System.out.println(count);

    }
}
