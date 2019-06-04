package com.guoyunyu.jiansheng.my.ThreadReact;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 除0异常展示
 *
 * @author Yongjian.Liu
 * @date 2019/4/1 17:29
 */
public class ZeroExceptionTest implements  Runnable{
    private int a,b;

    public ZeroExceptionTest(int a , int b){
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        System.out.println(a/b);
    }

    public static void main(String[] args) {
        ExecutorService threadPool = new ThreadPoolExecutor(0,1000,0l, TimeUnit.SECONDS,new SynchronousQueue<>());
        for(int i = 0 ; i < 5 ; i++){
            //除零被吃掉
            threadPool.submit(new ZeroExceptionTest(100,i));
        }
        threadPool.shutdown();

    }
}
