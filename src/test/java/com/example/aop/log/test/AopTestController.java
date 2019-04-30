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
 * ��ע�ⷽʽ����Junit��Ԫ���Կ�ܲ�����
 */
//@RunWith(SpringRunner.class)
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringConfig.class})//��Ҫע��˴��������������ļ���ע�⻻�ɼ����������ע��
//@SpringBootTest
public class AopTestController {

	@Autowired
	TestController testController;//���Ե�controller��
	
	MockMvc mockMvc;
	
	@org.junit.Before
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(testController).build();
    }
	
	@org.junit.Test // get����
    public void getListTest() throws Exception {
        // ��������
        ResultActions resultActions = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/paytype/list/all").accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("�ͻ��˻������:" + result);
    }
	
	@org.junit.Test // post����
    public void addTest() throws Exception {
        // ��������
        ResultActions resultActions = this.mockMvc.perform(MockMvcRequestBuilders.post("/testAop/log")
                .accept(MediaType.APPLICATION_JSON).param("typename", "һ��ͣ").param("payfee","4444.0").param("payto", "post"));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("�ͻ��˻������:" + result);
    }
	
	@org.junit.Test
	public void testAopLog() throws Exception {
		  // ��������
        ResultActions resultActions = this.mockMvc
                .perform(MockMvcRequestBuilders.get("/testAop/log").accept(MediaType.APPLICATION_JSON));
        MvcResult mvcResult = resultActions.andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        System.out.println("�ͻ��˻������:" + result);
	}
}
