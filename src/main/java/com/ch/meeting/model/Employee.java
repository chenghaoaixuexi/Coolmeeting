package com.ch.meeting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    private Integer employeeid;
    private String employeename;
    private String username;
    private String phone;
    private String email;
    private Integer status;
    private Integer departmentid;
    private String password;
    private Integer role;
}



