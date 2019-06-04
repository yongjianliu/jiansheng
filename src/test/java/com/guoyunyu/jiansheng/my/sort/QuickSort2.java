package com.guoyunyu.jiansheng.my.sort;


import java.util.Arrays;

/**
 * 快速排序
 *
 * @author Yongjian.Liu
 * @date 2019/5/8 16:45
 */
public class QuickSort2 {

    public static void main(String[] args) {
        int[] array = {5, 1, 2, 6, 8, 4, 7};
        sort(array, 0, array.length - 1);

        System.out.println(Arrays.toString(array));
    }

    public static void sort(int[] array, int low, int high) {
        if (low > high) {//遍历下标相遇，跳出
            return;
        }
        int i = low;
        int j = high;
        int target = array[i];//目标值约定为遍历数组的起始下标

        while (i < j) {//下标相遇后 跳出循环
            //首先进行右序 遍历，从右边开始，如果值大于target,则下标左移，不做任何操作
            while (i < j && array[j] >= target) {
                j--;
            }
            //右序遍历后两种情况 i=j，说明target右边的值都比target大，无需与target交换位置，此时应该跳出进行 左侧的递归
            //i < j，说明 右序遍历中，遇到了比target值小的值，需要将 target所在的值替换成小值，并且i + 1，准备进行左序遍历
            if (i < j) {
                array[i] = array[j];
                i++;
            }

            //开始进行左序遍历
            while (i < j && array[i] < target) {
                i++;
            }

            if (i < j) {
                array[j] = array[i];
                j--;
            }


        }
        array[i] = target;
        sort(array, low, i - 1);
        sort(array, i + 1, high);

    }
}
