package com.guoyunyu.jiansheng.my.ThreadReact;


import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * list扩容测试
 *
 * @author Yongjian.Liu
 * @date 2019/4/1 14:04
 */
public class ListCapacity {
     static List<Integer> addList = new ArrayList<>();
     static Vector<Integer> vector = new Vector<>();

    static class ListAddThread implements Runnable {
        @Override
        public void run() {
            for(int i = 0 ; i < 10000; i++){
//                addList.add(i);
                vector.add(i);
            }
        }
    }

    public static void main(String[] args) throws Exception{
        Thread t1 = new Thread(new ListAddThread(),"addListThread1");
        Thread t2 = new Thread(new ListAddThread(),"addListThread2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println(addList.size());
        System.out.println(vector.size());

    }
}
