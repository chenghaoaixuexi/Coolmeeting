package com.ch.meeting.mapper;

import com.ch.meeting.model.Department;

import java.util.List;

public interface DepartmentMapper {
   public Department getDepartmentById(Integer id);

    List getAllDept();
}
