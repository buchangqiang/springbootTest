package com.myspringboot.mapper;

import com.myspringboot.entity.MyUser;

import java.util.List;

public interface MyUserMapper {
    List<MyUser> findAllUsers();
    MyUser findUserById(long id);
    int insertUser(MyUser user);
    int deleteById(long id);
    int updateUser(MyUser user);
}
