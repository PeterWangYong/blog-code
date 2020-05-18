package com.peter.test;

import com.peter.mapper.AccountMapper;
import com.peter.model.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2 {
  public static void main(String[] args) throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(inputStream);
    SqlSession session = factory.openSession();
    AccountMapper accountMapper = session.getMapper(AccountMapper.class);
//    List<Account> list = accountMapper.findAll();
//    System.out.println(list);
//    Account account = accountMapper.findById(1L);
//    System.out.println(account);
//    System.out.println(accountMapper.findByUsername("张三"));
//    System.out.println(accountMapper.findByUsernameAndAge("张三", 22));
//    System.out.println(accountMapper.findByAccount(new Account(null, "张三", null, 22)));
//    System.out.println(accountMapper.findCount());
//    System.out.println(accountMapper.findUsernameById(1l));
//    System.out.println(accountMapper.findAgeById(1l));
//    account.setUsername("小明");
//    accountMapper.updateAccount(account);
//    System.out.println(accountMapper.findById(1L));
//    accountMapper.insertAccount(new Account(null, "小红", "123123", 18));
//    System.out.println(accountMapper.findByUsername("小红"));
//    accountMapper.deleteAccount(3);
    System.out.println(accountMapper.findAll());
    session.close();
    SqlSession session1 = factory.openSession();
    AccountMapper accountMapper1 = session1.getMapper(AccountMapper.class);
    System.out.println(accountMapper1.findAll());

//    System.out.println(accountMapper.findByAccount(new Account(null, "张三", "123123", 22)));
//    accountMapper.updateAccount(new Account(1L, "小张", null, 0));
//    System.out.println(accountMapper.findById(1L));
//    System.out.println(accountMapper.findByIds(new Account(null, null, null, 0, Arrays.asList(1L, 2L))));
    session1.close();
  }
}
