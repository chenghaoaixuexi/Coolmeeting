package com.ch.meeting.service;

import com.ch.meeting.mapper.DepartmentMapper;
import com.ch.meeting.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    public Department getDepById(Integer id){
        Department dept = departmentMapper.getDepartmentById(id);
        return dept;
    }
}
