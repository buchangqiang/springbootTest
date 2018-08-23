package com.myspringboot;

import com.myspringboot.controller.HelloController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class hello2Controller {
    @RequestMapping("/hello2")
    public  String home(){
        return  "hello2...";
    }
}
