package com.peter.aop.service.impl;

import com.peter.aop.annotation.Tx;
import com.peter.aop.model.User;
import com.peter.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

//  @Autowired
  private UserService userService;


  @Autowired
  public void setUserService(UserService userService) {
    System.out.println(userService);
    this.userService = userService;
    userService.login("123", "456");
  }


  @Override
  @Tx
  public void login(String username, String password) {
    System.out.println("login succeed !");
//    this.register(new User());
//    this.userService.register(new User());
//    System.out.println(this.userService);
  }

  @Override
  public void register(User user) {
    System.out.println("register succeed !");
  }
}
