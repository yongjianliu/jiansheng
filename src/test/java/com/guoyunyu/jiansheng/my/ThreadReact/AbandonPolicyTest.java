package com.guoyunyu.jiansheng.my.ThreadReact;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 丢弃策略模拟
 *
 *
 * @author Yongjian.Liu
 * @date 2019/4/1 16:41
 */
public class AbandonPolicyTest {
    static class innerThread implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(100l);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "线程正在执行");
        }
    }

    public static void main(String[] args) throws  Exception{
        ExecutorService threadPool = new ThreadPoolExecutor(5, 5, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<>(5), Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
                System.out.println("was abondon" + r.toString());
            }
        });

        for(int i =0 ; i < 100; i ++){
            //5个常驻线程的name并不是在这里指定的，而是在beanFactory里指定的
            threadPool.submit(new Thread(new innerThread(),i+"oioio"));
            Thread.sleep(10l);
        }
        threadPool.shutdown();

    }
}
