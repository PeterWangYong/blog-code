package com.peter.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.peter.mybatisplus.model.User;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface UserMapper extends BaseMapper<User> {
//  User findById(int id);
//  int add(User user);
  @Select("select name from user where id = #{id}")
  User findBySql(int id);
}
