package com.example.aop.log.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.example.aop.log.TestController;
import com.example.common.SpringConfig;
/*
 * 纯注解方式整合Junit单元测试框架测试类
 */
//@RunWith(SpringRunner.class)
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringConfig.class})//需要注意此处，将加载配置文件的注解换成加载配置类的注解
//@SpringBootTest
public class AopTestController {

	@Autowired
	TestController testController;//测试的controller类
	
	MockMvc mockMvc;
	
	@org.junit.Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }
	
	@org.junit.Test // get请求
    public void getListTest() throws Exception {
        // 发送请求
        ResultActions resultActions = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/paytype/list/all").accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("客户端获的数据:" + result);
    }
	
	@org.junit.Test // post请求
    public void addTest() throws Exception {
        // 发送请求
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/testAop/log")
                .accept(MediaType.APPLICATION_JSON).param("typename", "一年停").param("payfee","4444.0").param("payto", "post"));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("客户端获的数据:" + result);
    }
	
	@org.junit.Test
	public void testAopLog() throws Exception {
		  // 发送请求
        ResultActions resultActions = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/testAop/log").accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("客户端获的数据:" + result);
	}
}
