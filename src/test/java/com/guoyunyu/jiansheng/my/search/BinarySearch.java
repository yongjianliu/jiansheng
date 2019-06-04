package com.guoyunyu.jiansheng.my.search;


/**
 * desc
 *
 * @author Yongjian.Liu
 * @date 2019/5/9 9:28
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] arry = {1,3,5,9,11,18,27,88,112};
        System.out.println(search(arry,3,0,arry.length - 1));
    }


    public static int search(int[] arr, int key, int low, int high) {
        if (key < arr[low] || key > arr[high] || low > high) {
            return -1;
        }
        int middle = (low + high) / 2;
        if (arr[middle] > key) {
            return search(arr, key, low, middle - 1);
        } else if (arr[middle] < key) {
            return search(arr, key, middle + 1, high);
        } else {
            return middle;
        }


    }


}
