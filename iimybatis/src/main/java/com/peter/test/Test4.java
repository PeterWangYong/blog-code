package com.peter.test;

import com.peter.mapper.CustomerMapper;
import com.peter.mapper.GoodsMapper;
import com.peter.model.Customer;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class Test4 {
  public static void main(String[] args) throws IOException {
    InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
    SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
    SqlSessionFactory factory = builder.build(inputStream);
    SqlSession session = factory.openSession();
    CustomerMapper customerMapper = session.getMapper(CustomerMapper.class);
    System.out.println(customerMapper.findById(1));
    GoodsMapper goodsMapper = session.getMapper(GoodsMapper.class);
    System.out.println(goodsMapper.findById(2));
  }
}
