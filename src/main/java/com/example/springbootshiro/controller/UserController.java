package com.example.springbootshiro.controller;


import com.example.springbootshiro.model.User;
import com.example.springbootshiro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author astupidcoder
 * @since 2021-11-09
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

//    用户注册
    @RequestMapping("/register")
    public String register(User user){
        try {
            userService.register(user);
            System.out.println("注册成功");
            return "redirect:/login.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/register.jsp";
        }
    }
}
