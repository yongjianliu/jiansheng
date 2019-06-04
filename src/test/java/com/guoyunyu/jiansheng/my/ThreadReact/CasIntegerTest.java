package com.guoyunyu.jiansheng.my.ThreadReact;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 线程安全的计数器 ： 但并非分布式计数器
 *
 * @author Yongjian.Liu
 * @date 2019/4/2 15:13
 */
public class CasIntegerTest {
    static AtomicInteger i = new AtomicInteger();
    static class addThread implements Runnable{
        @Override
        public void run() {
            for(int k = 0 ; k < 1000; k++){
                i.incrementAndGet();
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(10);
        for(int m = 0 ; m < 10; m++){
            threadPool.execute(new addThread());
        }

        System.out.println("testset" + i);

    }

}

