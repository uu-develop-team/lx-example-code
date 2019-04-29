package com.example.java.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.common.SpringConfig;
import com.example.common.TestService;

/*
 * 纯注解方式整合Junit单元测试框架测试类
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringConfig.class})//需要注意此处，将加载配置文件的注解换成加载配置类的注解
public class CommonTest {

	@Resource
	private TestService testService;
	
	@Test
	public void testDemo() {
		testService.play();
	}
}
