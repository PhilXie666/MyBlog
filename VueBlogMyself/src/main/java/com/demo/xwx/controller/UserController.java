package com.demo.xwx.controller;

import com.demo.xwx.dao.LoginDto;
import com.demo.xwx.entity.User;
import com.demo.xwx.mapper.UserMapper;
import com.demo.xwx.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService userService;

    @PostMapping(value = "/login")
    @CrossOrigin("http://localhost:8080")
    public String login(@RequestBody LoginDto loginDto) {

        User user = userService.selectByUsername(loginDto.getUsername());
        if (user == null) {
            System.out.println("无此用户");
            return "no such user";
        }

        if (user.getPassword().equals(loginDto.getPassword())) {
            System.out.println("登录成功");
            return "success";
        } else {
            System.out.println("密码错误");
            System.out.println("测试");
            System.out.println("测试2");
            return "wrong password";
        }
    }

    /*@PostMapping(value = "/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password) {
        System.out.println("登录成功");
        System.out.println(username);
        System.out.println(password);

        return "success";
    }*/

    /*@GetMapping("/getById")
    public User getUserById(String id) {
        return userMapper.selectByPrimaryKey(id);
    }*/

}
