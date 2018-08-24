package com.myspringboot.controller;

import com.myspringboot.entity.TestUser;
import org.springframework.http.MediaType;
import org.springframework.scheduling.support.SimpleTriggerContext;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloController {

    /**
     * 无参Get请求
     * @return
     */
    @RequestMapping("")
    public  String home(){
        DateFormat format=new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String msg=String.format("hello my spring boot,curDate=%s",format.format(new Date()));
        return  "hello...";
    }

    /**
     * 有参数Get请求(path路径中解析)
     * @param name
     * @return
     */
    @RequestMapping("/sayhello/{namepath}")
    public  String sayHello(@PathVariable("namepath") String namepath,String name){
        return String.format("hello:%s,%s",namepath,name);
    }

    /**
     * 通过请求类型获取数据(Xml、Json)
     * @param id
     * @return
     */
    @RequestMapping(value = "/user/{id}/xml",produces = MediaType.APPLICATION_XML_VALUE)
    public TestUser getUserXml(@PathVariable("id")long id){
        TestUser user=new TestUser(id,"test111",100);
        return  user;
    }

    @RequestMapping(value = "/user/all",produces = MediaType.APPLICATION_XML_VALUE)
    public List<TestUser> getUserList(){
        TestUser user=new TestUser(1,"test111",100);
        TestUser user2=new TestUser(2,"test222",200);
        List<TestUser> userList=new ArrayList<TestUser>();
        userList.add(user);
        userList.add(user2);
        return  userList;
    }

    @RequestMapping(value = "/user/{id}")
    public TestUser getUser(@PathVariable("id")long id){
        TestUser user=new TestUser(id,"test111",100);
        return  user;
    }

    @PostMapping(value = "/user")
    //@RequestMapping(path ="/user",method = RequestMethod.POST)
    public String addUser(@RequestBody TestUser user){
        return "add:"+user.toString();
    }

    @PutMapping("/user/{id}")
    public  String updateUser(@PathVariable("id")long id,@RequestBody TestUser user){
        return  String.format("update[%d]:%s",id,user.toString());
    }

    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable("id")long id){
        return  "delete:"+id;
    }
}
