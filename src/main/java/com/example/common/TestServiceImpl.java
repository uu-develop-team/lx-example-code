package com.example.common;

import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService{

	@Override
	public void play() {
		System.out.println("123");
		
	}

}
