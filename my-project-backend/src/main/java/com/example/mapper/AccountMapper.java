package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.entity.dto.Account;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

public interface AccountMapper extends BaseMapper<Account> {
    @Insert("insert into account(username, password, email, role, register_time, update_time)" +
            " values(#{username},#{password},#{email},#{role},now(), now()) ")
    int add(String username, String password, String email, String role);
}
