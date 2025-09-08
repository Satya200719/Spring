package com.satya.learn_spring_aop.aopexamples.data;

import com.satya.learn_spring_aop.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataService1 {

    @TrackTime
    public int[] retriveData() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return new int[]{1, 2, 3, 4, 5, 6};
    }
}
