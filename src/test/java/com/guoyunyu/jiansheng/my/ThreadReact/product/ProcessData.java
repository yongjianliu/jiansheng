package com.guoyunyu.jiansheng.my.ThreadReact.product;


/**
 * 数据缓冲区中的数据处理对象
 *
 * @author Yongjian.Liu
 * @date 2019/4/3 14:06
 */
public class ProcessData {
    private Integer data;

    public ProcessData(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }


    @Override
    public String toString() {
        return "data" + data;
    }
}
