package com.guoyunyu.jiansheng.my.ThreadReact;



/**
 * 线程交替执行
 *
 * @author Yongjian.Liu
 * @date 2019/1/15 17:00
 */
public class ThreadSwitch implements Runnable {

    @Override
    public void run() {
        synchronized (this){
            while(true){
                try {
                    notify();
                    System.out.println(Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(1000l);
                    wait();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadSwitch instance = new ThreadSwitch();
        Thread t1 = new Thread(instance,"thread1");
        Thread t2 = new Thread(instance,"thread2");
        t1.start();
        t2.start();
    }
}
