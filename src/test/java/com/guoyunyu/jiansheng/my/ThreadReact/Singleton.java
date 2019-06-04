package com.guoyunyu.jiansheng.my.ThreadReact;


/**
 * 单例模式
 *
 * @author Yongjian.Liu
 * @date 2019/4/3 13:25
 */
public class Singleton {

    private static  Singleton singleton;
    private Singleton(){};


    /**
     * 加锁 为了防止并发下多个对象的创建
     *
     * @author Yongjian.Liu
     * @date 2019/4/3 13:33
     */
    public static synchronized Singleton getInstance(){
        return singleton == null ? new Singleton() : singleton;
    }
}
