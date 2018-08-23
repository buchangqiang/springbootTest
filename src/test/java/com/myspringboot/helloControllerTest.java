package com.myspringboot;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.alibaba.fastjson.JSON;
import com.myspringboot.entity.TestUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class helloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getHello() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello...")));
    }

    @Test
    public void getHello2() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello2"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hello2...")));
    }

    @Test
    public  void  getUserById() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/hello/user/122"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("name",equalTo("test111")));
    }

    @Test
    public  void saveUserByXmlType() throws Exception {

        TestUser user = new TestUser("test111", 100);

        //Xml格式模式请求
        mvc.perform(MockMvcRequestBuilders.post("/hello/user",user)
                .contentType(MediaType.APPLICATION_XML_VALUE)
                .content("<TestUser><name>test111</name><age>100</age></TestUser>"))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("add:"+user.toString())));
    }

    @Test
    public  void saveUserByJsonType() throws Exception {

        //Json格式模式请求
        TestUser user = new TestUser("test111", 100);
        String jsonRequestBody = JSON.toJSONString(user);
        mvc.perform(MockMvcRequestBuilders.post("/hello/user",user)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(jsonRequestBody))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("add:"+user.toString())));
    }
}
