package com.scheduler;

public class Application {

    public static void main(String[] args) {
        ServiceA serviceA = new ServiceA();
        ServiceB serviceB = new ServiceB();

        SchedulerService scheduler = new SchedulerService();
        scheduler.schedule(serviceA);
        scheduler.schedule(serviceB);

        try {
            Thread.sleep(60 * 1000);
        } catch (InterruptedException _) {
        }
    }
}
