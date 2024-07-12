package com.dev.spring_aop.service;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

    public String performTask() throws InterruptedException {
        // Simulating some work with a delay
        Thread.sleep(1000);
        return "Task Completed!";
    }

    public String anotherTask() throws InterruptedException {
        // Simulating some work with a delay
        Thread.sleep(500);
        return "Another Task Completed!";
    }

    public String taskWithException() throws InterruptedException {
        // Simulating some work with a delay
        Thread.sleep(500);
        throw new RuntimeException("Exception Occurred");
    }
}
