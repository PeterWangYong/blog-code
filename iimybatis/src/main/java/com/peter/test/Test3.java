package com.peter.test;

import com.peter.mapper.ClassesMapper;
import com.peter.mapper.StudentMapper;
import com.peter.model.Classes;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test3 {
  public static void main(String[] args) throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(inputStream);
    SqlSession session = factory.openSession();
    StudentMapper studentMapper = session.getMapper(StudentMapper.class);
    System.out.println(studentMapper.findById(1));
    ClassesMapper classesMapper = session.getMapper(ClassesMapper.class);
    System.out.println(classesMapper.findById(1));
    session.close();
  }
}
