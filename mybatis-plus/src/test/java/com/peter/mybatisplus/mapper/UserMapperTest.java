package com.peter.mybatisplus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.peter.mybatisplus.enums.StatusEnum;
import com.peter.mybatisplus.enums.StatusEnum2;
import com.peter.mybatisplus.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class UserMapperTest {

  @Autowired
  UserMapper userMapper;

  @Test
  public void findByIdTest() {
    User user = userMapper.selectById(1);
    System.out.println(user);
  }

  @Test
  public void saveTest() {
    User user = new User();
    user.setName("王五");
    user.setAge(18);
    user.setStatus(StatusEnum.REST);
    System.out.println("userMapper = " + userMapper.insert(user));
  }

  @Test
  void updateTest() {
    User user = userMapper.selectById(3);
    user.setName("赵四");

    User user1 = userMapper.selectById(3);
    user1.setName("赵武");

    userMapper.updateById(user1); // 成功
    userMapper.updateById(user);  // 失败
  }


  @Test
  void updateByWrapper() {
    User user = userMapper.selectById(2);
    user.setName("赵四");
    QueryWrapper wrapper = new QueryWrapper();
    wrapper.eq("age", 20);
    userMapper.update(user, wrapper);
  }

  @Test
  void deleteTest() {
    userMapper.deleteById(3);
    userMapper.deleteBatchIds(Arrays.asList(1,2));
  }

  @Test
  void deleteByWrapperTest() {
    QueryWrapper wrapper = new QueryWrapper();
    wrapper.eq("name", "张三");
    userMapper.delete(wrapper);
  }

  @Test
  void deleteByMapTest() {
    Map<String, Object> map = new HashMap<>();
    map.put("name", "张三");
    userMapper.deleteByMap(map);
  }

  @Test
  void findAll() {
    List<User> users = userMapper.selectList(null);
    System.out.println("users = " + users);
  }

  /**
   * Wrapper条件查询
   * Wrapper用于条件构造
   */
  @Test
  void selectByWrapper() {
    // Wrapper条件构造器
    QueryWrapper wrapper = new QueryWrapper();
    wrapper.eq("name", "张三");
//    wrapper.gt("age", 18);
//    wrapper.lt("age", 22);
//    Map<String, Object> map = new HashMap<>();
//    map.put("name", "张三");
//    map.put("age", 20);
//    wrapper.allEq(map);
//    wrapper.likeLeft("name", "三");
//    wrapper.orderByAsc("age")

    userMapper.selectList(null).forEach(System.out::println);
    userMapper.selectList(wrapper).forEach(System.out::println);
    userMapper.selectOne(wrapper);
    userMapper.selectCount(wrapper);
    userMapper.selectMaps(wrapper).forEach(System.out::println);
    userMapper.selectObjs(wrapper).forEach(System.out::println);
  }

  /**
   * 根据Map条件查询
   * 类似Wrapper的allEq查询
   */
  @Test
  void selectByMap() {
    Map<String, Object> map = new HashMap<>();
    map.put("name", "张三");
    map.put("age", 20);
    userMapper.selectByMap(map).forEach(System.out::println);
  }

  /**
   * 根据主键(ID)值进行查询
   */
  @Test
  void selectById() {
    System.out.println(userMapper.selectById(3));
    userMapper.selectBatchIds(Arrays.asList(1,2,3)).forEach(System.out::println);
  }

  /**
   * 分页查询
   * Page用于提供分页模型
   * 分页本质利用数据库的 LIMIT 语句
   */
  @Test
  void selectInPage() {

//    IPage<User> page = new Page<>(2, 1);
//    IPage<User> ret = userMapper.selectPage(page, null);
//    System.out.println(ret.getSize());
//    System.out.println(ret.getTotal());
//    System.out.println(ret.getPages());
//    ret.getRecords().forEach(System.out::println);

    IPage<Map<String, Object>> page = new Page<>(2, 1, false);
    IPage<Map<String, Object>> ret = userMapper.selectMapsPage(page, null);
    ret.getRecords().forEach(System.out::println);
  }

  @Test
  void selectBySqlTest() {
    System.out.println("userMapper = " + userMapper.findBySql(1));
  }

}
