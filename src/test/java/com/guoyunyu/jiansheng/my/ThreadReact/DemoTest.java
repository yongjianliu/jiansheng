package com.guoyunyu.jiansheng.my.ThreadReact;

/**
 * desc
 *
 * @author Yongjian.Liu
 * @date 2019/3/27 14:56
 */
public class DemoTest {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> System.out.println("sdfsdf"));
        t1.start();
    }
}
