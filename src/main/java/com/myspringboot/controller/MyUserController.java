package com.myspringboot.controller;

import com.myspringboot.entity.MyUser;
import com.myspringboot.mapper.MyUserMapper;
import com.myspringboot.model.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("myuser")
public class MyUserController {

    @Autowired
    MyUserMapper myUserMapper;

    @RequestMapping("/all")
    public List<MyUser> getAll(){
        List<MyUser> userList=myUserMapper.findAllUsers();
        return  userList;
    }

    @RequestMapping("/{id}")
    public BaseResponse getById(@PathVariable("id")long id){
        MyUser user = myUserMapper.findUserById(id);
        return new BaseResponse<>(user);
    }

    @PostMapping
    public BaseResponse insertUser(@RequestBody MyUser user){
        int result=myUserMapper.insertUser(user);
        if(result>0)
            return new BaseResponse();
        else
            return  new BaseResponse(-1,"插入失败！");
    }

    @PutMapping("/{id}")
    public BaseResponse updateUser(@PathVariable("id")long id,@RequestBody MyUser user){
        user.setId(id);
        int result=myUserMapper.updateUser(user);
        if(result>0)
            return new BaseResponse();
        else
            return  new BaseResponse(-1,"更新失败！");
    }

    @DeleteMapping("/{id}")
    public BaseResponse deleteById(@PathVariable("id")long id){
        int result=myUserMapper.deleteById(id);
        if(result>0){
            return new BaseResponse();
        }else {
            return  new BaseResponse(-1,"删除失败!");
        }
    }
}
