package com.satya.learn_spring_aop.aopexamples.data;

import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    public int[] retriveData() {
        return new int[]{1, 2, 3, 4, 5, 6};
    }
}
