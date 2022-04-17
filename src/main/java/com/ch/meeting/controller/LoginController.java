package com.ch.meeting.controller;

import com.ch.meeting.model.Department;
import com.ch.meeting.model.Employee;
import com.ch.meeting.service.DepartmentService;
import com.ch.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class LoginController {

    /*自动装配业务层对象*/
    @Autowired
    EmployeeService employeeService;
    @Autowired
    DepartmentService departmentService;



    /*项目启动初始路径
    * 跳转到登录页面
    * */
    @RequestMapping ("/")
    public String login() {
        return "login";
    }


    /*
     * @Description:调用Service层，处理用户登录请求
     * @Author: chenghao
     * @Date: 2022/4/13 16:45
     * @param username
     * @param password
     * @param model·
     * @param session
     * @return: java.lang.String
     **/
    @PostMapping ("/dologin")
    public String toLogin(String username, String password, Model model, HttpSession session) {

        Employee employee = employeeService.doLogin(username, password);
        if (employee == null) {
            model.addAttribute("error", "用户名不存在，或者密码错误");
            return "forward:/";
        } else {
            if (employee.getStatus() == 0) {
                model.addAttribute("error", "用户待审批");
                return "forward:/";
            } else if (employee.getStatus() == 2) {
                model.addAttribute("error", "用户审批未通过");
                return "forward:/";
            } else {
                session.setAttribute("currentUser", employee);
                return "redirect:/notifications";
            }
        }


    }

/*
 * @Description:映射登录页面
 * @Author: chenghao
 * @Date: 2022/4/17 15:46
 * @param model
 * @return: java.lang.String
 **/
    @RequestMapping("/register")
    public String register(Model model){
        List<Department> allDep = departmentService.getAllDep();
        model.addAttribute("deps",allDep);
        return "register";
    }


/*
 * @Description:处理登录
 * @Author: chenghao
 * @Date: 2022/4/17 15:47
 * @param employee
 * @param model
 * @return: java.lang.String
 **/
    @RequestMapping("/doreg")
    public String doreg(Employee employee,Model model){
        /*
        调用处理注册的业务方法
                返回值为1或-1
         */
        Integer doreg = employeeService.doreg(employee);

        //注册成功，重定向到登录页面
        if (doreg == 1){
            return "redirect:/";
        }else {
        //注册失败，回填转发到注册页面并回传数据
            model.addAttribute("emp",employee);
            return "register";
        }

    }
}
