package com.peter;

public class Main {
  public static void main(String[] args) {
      // 耦合
//    UserService userService = new UserServiceImpl();
      // 简单工厂
//    UserService userService = BeanFactory.getUserService();
      // 通用工厂
      UserService userService = (UserService)BeanFactory.getBean("userService");
      userService.getUser();
  }
}
