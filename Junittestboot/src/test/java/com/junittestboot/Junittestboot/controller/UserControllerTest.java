package com.junittestboot.Junittestboot.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.junittestboot.Junittestboot.model.User;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.io.File;
import java.util.regex.Matcher;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    private UserController userController;

    @Before
    public void setUpTest() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void testGetUserNames() throws Exception{
        mockMvc.perform(
                get("/user/getUserName")
        )
                .andExpect(status().isOk())
                .andExpect(content().string("dibya"));
    }

    @Test
    public void testGetUserName() throws Exception{
        mockMvc.perform(get("/user").accept(MediaType.APPLICATION_JSON_VALUE)
        ).andExpect(status().isOk())
        .andExpect(jsonPath("$.username", Matchers.is("dibya")))
        .andExpect(jsonPath("$.phone",Matchers.is(1234)));

    }

    @Test
    public void testSaveUser() throws Exception{
        User user = new User();
        user.setPhone(1234);
        user.setUsername("dibya");
        System.out.println(new ObjectMapper().writeValueAsString(user));
        mockMvc.perform(post("/user")
        .content(new ObjectMapper().writeValueAsString(user))
        .contentType(MediaType.APPLICATION_JSON_VALUE)
        .accept(MediaType.APPLICATION_JSON_VALUE))

                .andExpect(status().isOk());
    }

    @Test
    public void testSaveUserFronJsonFile() throws Exception{

        int i =2233;
        float n = 123.233f;
        double d = 123;
        i= (int) n;
        n=i;
        

        User user = new User();
        user.setPhone(1234);
        user.setUsername("dibya");
        System.out.println(new ObjectMapper().writeValueAsString(user));
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = objectMapper.writeValueAsString(
                objectMapper.readValue(new File("src/main/resources/static/user.json"),Object.class));
        mockMvc.perform(post("/user")
                .content(jsonString)
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))

                .andExpect(status().isOk());
    }


}