package com.peter.mapper;

import com.peter.model.Account;

import java.util.List;

public interface AccountMapper {
  List<Account> findAll();
  Account findById(Long id);
  Account findByUsername(String username);
  Account findByUsernameAndAge(String username, int age);
  Account findByAccount(Account account);
  int findCount();
  String findUsernameById(long id);
  int findAgeById(long id);
  int updateAccount(Account account);
  int insertAccount(Account account);
  int deleteAccount(long id);
  List<Account> findByIds(Account account);
}

