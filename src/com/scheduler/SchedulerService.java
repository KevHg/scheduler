package com.scheduler;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SchedulerService {

    private final ScheduledExecutorService exec = Executors.newScheduledThreadPool(Runtime.getRuntime().availableProcessors());

    public void schedule(Object object) {
        Class<?> clazz = object.getClass();
        for (Method method : clazz.getDeclaredMethods()) {
            if (method.isAnnotationPresent(ScheduleEveryFiveMins.class)) {
                scheduleMethod(object, method);
            }
        }
    }

    private void scheduleMethod(Object object, Method method) {
        Runnable runnable = () -> {
            try {
                method.invoke(object);
            } catch (IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        };

        exec.scheduleAtFixedRate(runnable, 0, 5, TimeUnit.SECONDS);
//        exec.scheduleAtFixedRate(runnable, 0, 5, TimeUnit.MINUTES);
    }
}
