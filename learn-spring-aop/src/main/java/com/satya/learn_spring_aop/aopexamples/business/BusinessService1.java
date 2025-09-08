package com.satya.learn_spring_aop.aopexamples.business;

import com.satya.learn_spring_aop.annotations.TrackTime;
import com.satya.learn_spring_aop.aopexamples.data.DataService1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {
    @Autowired
    private DataService1 dataService1;

    @TrackTime
    public int calculateMax() {
        int[] data = dataService1.retriveData();
        return Arrays.stream(data).max().orElse(0);
    }
}
