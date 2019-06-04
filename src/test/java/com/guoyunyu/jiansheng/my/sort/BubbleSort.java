package com.guoyunyu.jiansheng.my.sort;


import java.util.Arrays;

/**
 * bubble sort
 * 从小到大排序： 大的放到最右边 遍历减1
 *
 * @author Yongjian.Liu
 * @date 2019/4/4 10:26
 */
public class BubbleSort {

    //比较次数 array.lenth - 1次
    public static int[] array = new int[]{6, 9, 3, 1, 4, 8, 7, 2};

    public static void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        sort(array);
        System.out.println(Arrays.toString(array));
    }
}
