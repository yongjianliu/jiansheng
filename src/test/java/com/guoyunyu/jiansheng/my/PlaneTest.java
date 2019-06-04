package com.guoyunyu.jiansheng.my;


import org.junit.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class PlaneTest {
    @Test
    public void testListNull(){
        System.out.println(new BigDecimal("0.29").multiply(new BigDecimal(100)));


        List list = null;
        list.forEach(cur -> System.out.println(cur));
        for(Object o : list){
            System.out.println(o);
        }
        System.out.println(list);


        new Thread(() -> {}).start();
    }
}
