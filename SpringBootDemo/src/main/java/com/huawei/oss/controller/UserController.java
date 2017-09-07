package com.huawei.oss.controller;

import com.huawei.oss.dao.UserMapper;
import com.huawei.oss.model.User;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {

  @Autowired
  UserMapper userMapper;

  @RequestMapping("/querybyid")
  @ResponseBody
  User queryById(int id) {
    return userMapper.queryById(id);
  }

  @RequestMapping("/queryall")
  @ResponseBody
  List<User> queryAll() {
    return userMapper.queryAll();
  }

  @RequestMapping("/add")
  @ResponseBody
  String add(User user) {
    return userMapper.add(user) == 1 ? "success" : "failed";
  }

  @RequestMapping("/updatebyid")
  @ResponseBody
  String updateById(User user) {
    return userMapper.updateById(user) == 1 ? "success" : "failed";
  }

  @RequestMapping("/delbyid")
  @ResponseBody
  String delById(int id) {
    return userMapper.delById(id) == 1 ? "success" : "failed";
  }
}