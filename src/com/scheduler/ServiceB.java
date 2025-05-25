package com.scheduler;

import java.util.Date;

public class ServiceB {

    @ScheduleEveryFiveMins
    public void methodOne() {
        System.out.println("B1: " + new Date());
    }
}
