package com.peter.aop.service;


import com.peter.aop.model.User;

public interface UserService {
  void login(String username, String password);
  void register(User user);
}
