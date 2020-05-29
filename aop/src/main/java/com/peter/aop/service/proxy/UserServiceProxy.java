package com.peter.aop.service.proxy;

import com.peter.aop.model.User;
import com.peter.aop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//@Service
//public class UserServiceProxy implements UserService {
//
//  @Autowired
//  private UserService userServiceImpl;
//
//  @Override
//  public void login(String username, String password) {
//    System.out.println("--- do something before ---");
//    userServiceImpl.login(username, password);
//  }
//
//  @Override
//  public void register(User user) {
//    System.out.println("--- do something before ---");
//    userServiceImpl.register(user);
//  }
//}
