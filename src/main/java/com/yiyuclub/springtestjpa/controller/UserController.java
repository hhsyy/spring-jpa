package com.yiyuclub.springtestjpa.controller;

import com.yiyuclub.springtestjpa.models.IdeaUserModel;
import com.yiyuclub.springtestjpa.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"getUserList","getUserList1"})
    private   List<IdeaUserModel> getUserList(){
        List<IdeaUserModel> userList = userService.getUserByDiy();
        return userList;
    }
}
