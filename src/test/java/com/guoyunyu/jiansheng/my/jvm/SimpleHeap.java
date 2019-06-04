package com.guoyunyu.jiansheng.my.jvm;


public class SimpleHeap {
    private int id;

    public SimpleHeap(int id) {
        this.id = id;
    }

    public void show() {
        System.out.println(id);
    }

    public static void main(String[] args) {
        SimpleHeap simpleHeap1 = new SimpleHeap(3);
        SimpleHeap simpleHeap2 = new SimpleHeap(4);

        simpleHeap1.show();
        simpleHeap2.show();

    }


}
