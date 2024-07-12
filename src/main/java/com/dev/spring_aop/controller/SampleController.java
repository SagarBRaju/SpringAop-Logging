package com.dev.spring_aop.controller;

import com.dev.spring_aop.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("spring-aop")
public class SampleController {

    @Autowired
    private SampleService sampleService;

    @GetMapping("/task")
    public String performTask() throws InterruptedException {
        return sampleService.performTask();
    }

    @GetMapping("/another-task")
    public String anotherTask() throws InterruptedException {
        return sampleService.anotherTask();
    }

    @GetMapping("/task-with-exception")
    public String taskWithException() throws InterruptedException {
        return sampleService.taskWithException();
    }
}

