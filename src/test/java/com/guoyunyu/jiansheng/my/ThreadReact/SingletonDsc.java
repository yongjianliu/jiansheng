package com.guoyunyu.jiansheng.my.ThreadReact;

//DCL
public class SingletonDsc {

    //为什么要使用volatile的： 避免指令重排序
    private static volatile SingletonDsc instance;

    private SingletonDsc(){}

    private static SingletonDsc getInstance(){
        if(instance == null){
            synchronized (SingletonDsc.class){
                if(instance == null){
                    instance = new SingletonDsc();
                }
            }
        }
        return instance;
    }
}
