package com.ch.meeting.mapper;

import com.ch.meeting.model.Employee;

public interface EmployeeMapper {

    Employee loadEmpByUsername(String username);

    void insertEmp(Employee employee);
}
