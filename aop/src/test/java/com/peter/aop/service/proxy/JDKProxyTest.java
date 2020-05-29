package com.peter.aop.service.proxy;

import com.peter.aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SpringBootTest
public class JDKProxyTest {

  @Autowired
  UserService userService;

  @Test
  void mainTest() {
    InvocationHandler handler = new InvocationHandler() {
      @Override
      public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("--- jdk proxy before ---");
        // 这里只需要填入不同的原始类对象就可以实现不同对象的代理
        Object ret = method.invoke(userService, args);
        return ret;
      }
    };
    // JDK动态代理创建并返回了代理对象
    UserService userServiceProxy = (UserService) Proxy.newProxyInstance(JDKProxyTest.class.getClassLoader(), userService.getClass().getInterfaces(), handler);
    userServiceProxy.login("username", "123456");
  }
}
