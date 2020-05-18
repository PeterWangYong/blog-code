package com.peter.test;

import com.peter.model.Account;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Test1 {
  public static void main(String[] args) throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(inputStream);
    SqlSession session = factory.openSession();
    // 查询所有数据
    String statement = "mapper.accountMapper.findAll";
    List<Account> list = session.selectList(statement);
    System.out.println(list);
    // 查询单条数据
    Account account = session.selectOne("mapper.accountMapper.findById", 1L);
    System.out.println(account);
    session.close();
  }
}
