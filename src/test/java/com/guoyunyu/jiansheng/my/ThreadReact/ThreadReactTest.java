package com.guoyunyu.jiansheng.my.ThreadReact;

import org.junit.Test;

/**
 * @author Yongjian.Liu
 * @date 2019/1/4 15:36
 */
public class ThreadReactTest {


    /**
     * 线程状态枚举
     * NEW
     * RUNNABLE
     * BLOCKED
     * WAITING
     * TIMED_WAITING
     * TERMINATED
     *
     * @author Yongjian.Liu
     * @date 2019/1/4 15:41
     */
    @Test
    public void threadStateTest() {
        for (Thread.State curState : Thread.State.values()) {
            System.out.println(curState.toString());
        }
    }

    
    /**
     * 初始化线程
     *
     * @author Yongjian.Liu
     * @date 2019/1/8 17:11
     */
    @Test
    public void initThread(){
        Thread thread = new Thread(() -> System.out.println("sdf"));
        thread.start();
        thread.stop();
    }

    
    /**
     * wait test
     *
     * @author Yongjian.Liu
     * @date 2019/1/8 17:11
     */
    @Test
    public void notifyTest(){
        Thread thread1 = new Thread(() ->{
            System.out.println("begin");
            try {
                synchronized (this){
                    wait();
                    System.out.println("sdfsd");
                }

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        thread1.start();
    }

}
