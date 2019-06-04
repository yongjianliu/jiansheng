package com.guoyunyu.jiansheng.my.structure;

/**
 * desc
 *
 * @author Yongjian.Liu
 * @date 2019/5/13 10:57
 */
public class DumpTest {

    public static void main(String[] args) {
        int[] array = {1,1,2,3,3,4,4,5,5};
        int result = array[0];
        for(int i = 0 ; i < array.length; i++){
            result ^= array[i];
            System.out.println(result);
        }
    }
}
