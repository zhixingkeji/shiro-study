package com.example.springbootshiro.service;

import com.example.springbootshiro.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author astupidcoder
 * @since 2021-11-09
 */
public interface UserService extends IService<User> {
    void register(User user);
    User findByUsername(String username);
}
