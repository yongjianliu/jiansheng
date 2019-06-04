package com.guoyunyu.jiansheng.my.ThreadReact;


public class PlaneTest2 {
    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;

        System.out.println(a + "" + b);

        swap(a,b);
        System.out.println(a + "" + b);
    }

    public static void swap(Integer a, Integer b) {
        Integer temp = a;
        b = a;
        a = temp;

    }
}
