package com.performance.apiperformanceenhancement.controller;

import com.performance.apiperformanceenhancement.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private KafkaService kafkaService;

    @PostMapping
    public void saveStudent(@RequestBody String student) {
        kafkaService.sendMessage(student);
    }
}
