package com.myspringboot;

import com.myspringboot.controller.HelloController;
import com.myspringboot.entity.MyStudent;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class hello2Controller {
    @RequestMapping("/hello2")
    public  String home(){

        MyStudent student=new MyStudent();
        student.setId(100);

        return  "hello2...";
    }
}
