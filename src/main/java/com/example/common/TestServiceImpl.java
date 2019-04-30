package com.example.common;

import org.springframework.stereotype.Service;

import com.example.aop.log.WebTestLog;

@Service
public class TestServiceImpl implements TestService{

	@Override
	@WebTestLog(description = "11111111111")
	public void play() {
		System.out.println("123");
		
	}

}
