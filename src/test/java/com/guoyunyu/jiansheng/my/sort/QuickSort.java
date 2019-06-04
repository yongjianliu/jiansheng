package com.guoyunyu.jiansheng.my.sort;

import java.util.Arrays;

/**
 * desc
 *
 * @author Yongjian.Liu
 * @date 2019/5/8 16:27
 */
public class QuickSort {
    public static void main(String[] args) {
        int a[] = {49, 38, 65, 97, 76, 13, 27, 51};
        sort(a, 0, a.length - 1);
        System.out.println(Arrays.toString(a));

    }

    public static void sort(int[] a, int low, int hight) {

        int i;
        int j;
        int index;

        if (low > hight) {//指针相遇： 结束
            return;
        }

        i = low;
        j = hight;
        index = a[i];//用数组的第一个记录作为基准数

        while (i < j) {//从数组两端交替向中间扫描
            while (i < j && a[j] >= index) {//右边数据比基准数大 指针左移
                j--;
            }
            //右边数据 小于 左                                                                                                                                                                                                    边数据
            if (i < j) {
                a[i++] = a[j];//用比基准数小的记录替代低位记录
            }

            while (i < j && a[i] < index) {//左边数据比基准数小 指针右移
                i++;
            }

            if (i < j) {//用比基准数大的记录替换高位记录
                a[j--] = a[i];
            }

        }
        a[i] = index;//替换基准数
        sort(a, low, i - 1);//对低表进行递归排序
        sort(a, i + 1, hight);//对高表进行递归排序

    }

}
