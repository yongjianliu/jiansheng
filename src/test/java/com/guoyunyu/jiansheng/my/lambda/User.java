package com.guoyunyu.jiansheng.my.lambda;

import lombok.Data;

/**
 * lambda user
 *
 * @author Yongjian.Liu
 * @date 2018/12/19 14:56
 */
@Data
public class User {

    public User (String name,Integer age){
        this.age = age;
        this.name = name;
    }

    private String name;

    private Integer age;


}
