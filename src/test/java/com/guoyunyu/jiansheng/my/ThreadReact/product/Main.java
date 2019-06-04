package com.guoyunyu.jiansheng.my.ThreadReact.product;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * desc
 *
 * @author Yongjian.Liu
 * @date 2019/4/3 14:51
 */
public class Main {
    public static void main(String[] args)  throws Exception {

        BlockingQueue blockingQueue  = new LinkedBlockingQueue(10);
        Product product1 = new Product(blockingQueue);
        Product product2 = new Product(blockingQueue);
        Product product3 = new Product(blockingQueue);

        Consumer consumer1 = new Consumer(blockingQueue);
        Consumer consumer2 = new Consumer(blockingQueue);
        Consumer consumer3 = new Consumer(blockingQueue);

        ExecutorService threadPool = Executors.newCachedThreadPool();
        threadPool.execute(product1);
        threadPool.execute(product2);
        threadPool.execute(product3);
        threadPool.execute(consumer1);
        threadPool.execute(consumer2);
        threadPool.execute(consumer3);

        Thread.sleep(1000 * 20l);




    }
}
