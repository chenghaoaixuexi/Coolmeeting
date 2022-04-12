package com.ch.meeting.controller;

import com.ch.meeting.model.Department;
import com.ch.meeting.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @GetMapping("dep")
    public void getDepById(Integer id) {
        Department department = departmentService.getDepById(2);
        System.out.println(department);

    }
}
