package com.example.java.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.common.SpringConfig;
import com.example.common.TestService;

/*
 * ��ע�ⷽʽ����Junit��Ԫ���Կ�ܲ�����
 */
@RunWith(value=SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes={SpringConfig.class})//��Ҫע��˴��������������ļ���ע�⻻�ɼ����������ע��
public class CommonTest {

	@Resource
	private TestService testService;
	
	@Test
	public void testDemo() {
		testService.play();
	}
}
