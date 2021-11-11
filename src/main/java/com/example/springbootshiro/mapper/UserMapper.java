package com.example.springbootshiro.mapper;

import com.example.springbootshiro.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author astupidcoder
 * @since 2021-11-09
 */

@Mapper
public interface UserMapper extends BaseMapper<User> {
    void save(User user);

    User findByUsername(String username);
}
