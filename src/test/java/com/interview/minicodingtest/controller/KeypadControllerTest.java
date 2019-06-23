package com.interview.minicodingtest.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
public class KeypadControllerTest {
    @Autowired
    private WebApplicationContext wac;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }


    @Test
    public void printComplexTest1() throws Exception {
        List<String> mockList = new ArrayList<>();
        mockList.add("1");
        mockList.add("2");
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/keys/key", mockList)
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSON(mockList).toString())).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("[A, B, C]")))
                .andReturn().getResponse().getContentAsString();
        log.info(mvcResult);

    }

    @Test
    public void printComplexTest2() throws Exception {
        List<String> mockList = new ArrayList<>();
        mockList.add("2");
        mockList.add("3");
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/keys/key", mockList)
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSON(mockList).toString())).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("[AD, AE, AF, BD, BE, BF, CD, CE, CF]")))
                .andReturn().getResponse().getContentAsString();
        log.info(mvcResult);
    }

    @Test
    public void printComplexTest3() throws Exception {
        List<String> mockList = new ArrayList<>();
        mockList.add("0");
        mockList.add("1");
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/keys/key", mockList)
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSON(mockList).toString())).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("[]")))
                .andReturn().getResponse().getContentAsString();
        log.info(mvcResult);
    }

    @Test
    public void printComplexTest4() throws Exception {
        List<String> mockList = new ArrayList<>();
        mockList.add("22");
        mockList.add("33");
        String mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("/keys/key", mockList)
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON)
                .content(JSON.toJSON(mockList).toString())).andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string(equalTo("[AD, AE, AF, AD, AE, AF, BD, BE, BF, BD, BE, BF, CD, CE, CF, CD, CE, CF, AD, AE, AF, AD, AE, AF, BD, BE, BF, BD, BE, BF, CD, CE, CF, CD, CE, CF]")))
                .andReturn().getResponse().getContentAsString();
        log.info(mvcResult);
    }

    @Test
    public void printComplexTest5() throws Exception {
        List<String> mockList = new ArrayList<>();
        mockList.add("");
        mockList.add("");
        mockMvc.perform(MockMvcRequestBuilders.post("/keys/key", mockList)
                .accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @After
    public void tearDown() throws Exception {
    }
}