package com.performance.apiperformanceenhancement.controller;

import com.performance.apiperformanceenhancement.dao.StudentDao;
import com.performance.apiperformanceenhancement.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/student")
public class StudentController {

    @Autowired
    private StudentDao studentDao;

    @PostMapping
    public void saveStudent(@RequestBody Student student) {
        studentDao.save(student);
    }
}
