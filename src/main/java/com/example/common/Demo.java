package com.example.common;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * 纯注解方式整合Junit单元测试框架测试类
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringConfig.class})//需要注意此处，将加载配置文件的注解换成加载配置类的注解
public class Demo {

	/*
	 * @Resource(name="customerService") private CustomerService customerService;
	 * 
	 * @Test public void fun() { customerService.save(); }
	 */
	
	
}
