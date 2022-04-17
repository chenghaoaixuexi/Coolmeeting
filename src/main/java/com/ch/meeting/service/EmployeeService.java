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

    public Integer doreg(Employee employee) {
        //从控制层传入employee对象，更具用户名判断是否已经存在该员工，避免重复注册
        Employee emp = employeeMapper.loadEmpByUsername(employee.getUsername());
        //如果没有，则设置表单没有填写的数据，并执行插入
        if (emp == null) {
            employee.setRole(1);
            employee.setStatus(2);
            //调用到层进行插入
            employeeMapper.insertEmp(employee);
            return 1;
        }
        return -1;

    }
}
