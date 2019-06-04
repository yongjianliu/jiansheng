package com.guoyunyu.jiansheng.my.ThreadReact;

import java.util.Arrays;

/**
 * volatile不保证原子性
 *
 * @author Yongjian.Liu
 * @date 2019/1/11 16:21
 */
public class VolatileTest {
    public static int i = 0;
    public static Integer lock = 0;

    public static class PlusTask implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                for (int k = 0; k < 10000; k++) {
                    i++;
                }
            }


        }
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[10];
        for (int j = 0; j < 10; j++) {
            threads[j] = new Thread(new PlusTask());
            threads[j].start();
        }
        Arrays.stream(threads).forEach(curThread -> {
            try {
                curThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(i);
    }

}

