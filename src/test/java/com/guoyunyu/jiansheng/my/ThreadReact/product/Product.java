package com.guoyunyu.jiansheng.my.ThreadReact.product;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 基于BlockingQueue实现生产者 消费者模式
 *
 * @author Yongjian.Liu
 * @date 2019/4/3 14:00
 */
public class Product implements Runnable {

    private BlockingQueue<ProcessData> blockingQueue;

    private static AtomicInteger count = new AtomicInteger();

    private static final int SLEEPTIME = 1000;

    public Product(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    @Override
    public void run() {
        while (true) {
            try {
                ProcessData processData = new ProcessData(count.incrementAndGet());
                if (blockingQueue.offer(processData, 10, TimeUnit.SECONDS)) {//如果入队成功
                    System.out.println("thread" + Thread.currentThread().getId() + "offer queue success ,the data is " + processData.toString());

                } else {
                    System.out.println("thread" + Thread.currentThread().getId() + "offer queue failed");
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
