package com.scheduler;

import java.util.Date;

public class ServiceA {

    @ScheduleEveryFiveMins
    public void methodOne() {
        System.out.println("A1: " + new Date());
    }

    @ScheduleEveryFiveMins
    public void methodTwo() {
        System.out.println("A2: " + new Date());
    }
}
