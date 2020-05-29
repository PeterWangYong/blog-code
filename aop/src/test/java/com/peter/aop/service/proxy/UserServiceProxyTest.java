package com.peter.aop.service.proxy;

import com.peter.aop.model.User;
import com.peter.aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserServiceProxyTest {

  @Autowired
  UserService userServiceProxy;

  @Test
  void loginTest() {
    userServiceProxy.login("admin", "123456");
  }

  @Test
  void registerTest() {
    userServiceProxy.register(new User());
  }
}
