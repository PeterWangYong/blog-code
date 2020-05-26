package com.peter.mybatisplus.generator.service.impl;

import com.peter.mybatisplus.generator.entity.User;
import com.peter.mybatisplus.generator.mapper.UserMapper;
import com.peter.mybatisplus.generator.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author peter
 * @since 2020-05-26
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
