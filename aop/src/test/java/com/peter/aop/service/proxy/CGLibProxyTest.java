package com.peter.aop.service.proxy;

import com.peter.aop.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@SpringBootTest
public class CGLibProxyTest {

  @Autowired
  UserService userService;

  @Test
  void mainTest() {

    MethodInterceptor interceptor = new MethodInterceptor() {
      @Override
      public Object intercept(Object o, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
        System.out.println("--- cglib proxy before ---");
        Object ret = method.invoke(userService, args);
        return ret;
      }
    };

    Enhancer enhancer = new Enhancer();
    enhancer.setClassLoader(CGLibProxyTest.class.getClassLoader());
    enhancer.setSuperclass(userService.getClass());
    enhancer.setCallback(interceptor);

    UserService userServiceProxy = (UserService) enhancer.create();
    userServiceProxy.login("admin", "123456");
  }

}
