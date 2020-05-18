package com.peter.test;

import com.peter.mapper.StudentLazyMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test5 {
  public static void main(String[] args) throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(inputStream);
    SqlSession session = factory.openSession();
    StudentLazyMapper studentLazyMapper = session.getMapper(StudentLazyMapper.class);
    System.out.println(studentLazyMapper.findById(1));
    System.out.println(studentLazyMapper.findLazyById(1));
    session.close();
  }
}
