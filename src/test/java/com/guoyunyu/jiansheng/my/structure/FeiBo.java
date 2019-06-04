package com.guoyunyu.jiansheng.my.structure;

/**
 * desc
 *
 * @author Yongjian.Liu
 * @date 2019/5/14 17:17
 */
public class FeiBo {

    public static void main(String[] args) {
        for(int i = 1; i <= 10; i++){
            System.out.println(recursion(i));
        }
    }

    public static int recursion(int n){
        if(n == 1){
            return 0;
        }
        if(n == 2){
            return 1;
        }

        return recursion(n - 2)  + recursion(n - 1);
    }
}
