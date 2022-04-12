package com.ch.meeting.service;

import com.ch.meeting.mapper.EmployeeMapper;
import com.ch.meeting.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public Employee doLogin(String username,String password){

        Employee employee = employeeMapper.loadEmpByUsername(username);
        if (employee == null || !employee.getPassword().equals(password))
        {
            return null;
        }
        return employee;
    }
}
