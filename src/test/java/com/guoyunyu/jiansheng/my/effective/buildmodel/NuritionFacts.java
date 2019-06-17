package com.guoyunyu.jiansheng.my.effective.buildmodel;



/**
 * build model
 *
 * @author Yongjian.Liu
 * @date 2019/6/6 10:54
 */
public class NuritionFacts {
    private final int servingSize;
    private final int servings;
    private final int calories;
    private final int fat;

    public static class Builder {
        private final int serviingSize;
        private final int servings;

        private int calories = 0;
        private int fat = 0;

        private Builder(int servingSize, int servings) {
            this.serviingSize = servingSize;
            this.servings = servings;
        }

        private Builder calories(int val) {
            calories = val;
            return this;
        }

        private Builder fat(int val) {
            fat = val;
            return this;
        }

        public NuritionFacts build(){
            return new NuritionFacts(this);
        }
    }

    private NuritionFacts(Builder builder) {
        servingSize = builder.serviingSize;
        servings = builder.servings;
        calories = builder.calories;
        fat = builder.fat;
    }

    public static void main(String[] args) {
        NuritionFacts nuritionFacts = new NuritionFacts.Builder(10,4).calories(4).fat(3).build();
        System.out.println(nuritionFacts.fat);
    }


}
