package com.example.common;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/*
 * ��ע�ⷽʽ����Junit��Ԫ���Կ�ܲ�����
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringConfig.class})//��Ҫע��˴��������������ļ���ע�⻻�ɼ����������ע��
public class Demo {

	/*
	 * @Resource(name="customerService") private CustomerService customerService;
	 * 
	 * @Test public void fun() { customerService.save(); }
	 */
	
	
}
