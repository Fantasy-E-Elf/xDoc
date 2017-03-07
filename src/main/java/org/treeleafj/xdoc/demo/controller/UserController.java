package org.treeleafj.xdoc.demo.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.treeleafj.xdoc.demo.vo.User;

/**
 * 用户模块
 *
 * @author leaf
 * @date 2017-03-03 10:11
 */
@Controller
@RequestMapping("user")
public class UserController {

    /**
     * 注册用户
     *
     * @param username 用户名
     * @param password 密码
     * @return 用户注册后的信息
     * @see org.treeleafj.xdoc.demo.vo.User
     */
    @RequestMapping(value = "register", method = RequestMethod.POST)
    public User register(User user, int num, String username, String password) {
        return null;
    }

    /**
     * 查询当前登录用户的基本信息
     *
     * @param user 当前登录用户
     * @return 当前登录用户的基本信息
     * @see org.treeleafj.xdoc.demo.vo.User
     */
    @ResponseBody
    @RequestMapping("info")
    public User info(User user) {
        return new User();
    }


    /**
     * 注册
     *
     * @param user :username 用户名|必填
     * @param user :password 密码|必填
     * @return 当前登录用户的基本信息
     * @title 用户注册
     * @respbody {"id":"123","password":"123456","username":"admin"}
     * @see org.treeleafj.xdoc.demo.vo.User
     */
    @ResponseBody
    @RequestMapping("register2")
    User register(User user) {
        return new User();
    }
}
