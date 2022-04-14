package com.ch.meeting.controller;

import com.ch.meeting.model.Employee;
import com.ch.meeting.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {
    @Autowired
    EmployeeService employeeService;



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

}
