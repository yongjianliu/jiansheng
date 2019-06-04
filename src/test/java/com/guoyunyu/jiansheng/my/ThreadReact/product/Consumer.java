package com.guoyunyu.jiansheng.my.ThreadReact.product;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * desc
 *
 * @author Yongjian.Liu
 * @date 2019/4/3 14:43
 */
public class Consumer implements Runnable {
    private BlockingQueue<ProcessData> blockingQueue;

    public Consumer(BlockingQueue blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1000l);
                ProcessData processData =  blockingQueue.poll(10, TimeUnit.SECONDS);
                System.out.println("consumer" + Thread.currentThread().getId()  + "data value" + processData.toString());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
