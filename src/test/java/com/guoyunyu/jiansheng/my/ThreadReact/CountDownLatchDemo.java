package com.guoyunyu.jiansheng.my.ThreadReact;


import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 倒计时器门闩demo
 *
 * @author Yongjian.Liu
 * @date 2019/4/1 14:45
 */
public class CountDownLatchDemo {
    static CountDownLatch countDownLatch = new CountDownLatch(10);

    static class PrepareWork implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(1000);
                //一项准备工作已完成
                System.out.println("job done");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws Exception {

        //利用线程池模拟10项准备工作
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.submit(new CountDownLatchDemo.PrepareWork());
        }

        //主线程必须要等待门闩完全解锁后才可以继续执行
        countDownLatch.await();
        System.out.println("done");
        executorService.shutdown();

    }
}
