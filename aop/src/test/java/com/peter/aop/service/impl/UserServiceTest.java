package com.peter.aop.service.impl;

import com.peter.aop.model.User;
import com.peter.aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceTest {

  @Autowired
  UserService userService;

  @Test
  void loginTest() {
//    userService.login("admin", "123456");
  }

  @Test
  void registerTest() {
    userService.register(new User());
  }

}
