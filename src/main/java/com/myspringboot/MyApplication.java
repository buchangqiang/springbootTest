package com.myspringboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
@MapperScan("com.myspringboot.mapper")
public class MyApplication extends  SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        // 注意这里要指向原先用main方法执行的Application启动类
        return builder.sources(MyApplication.class);
    }

    //使用SpringBootServletInitializer 自己的tomcat容器执行，此处不会执行
    //
    public  static  void main(String[] args)  throws  Exception{
        SpringApplication.run(com.myspringboot.MyApplication.class,args);
    }
}