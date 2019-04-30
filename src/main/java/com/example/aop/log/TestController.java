package com.example.aop.log;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.common.TestService;

@Controller
@RequestMapping("/testAop")
public class TestController {

	private final static Logger logger         = LoggerFactory.getLogger(TestController.class);
	@Resource
	private TestService testService;
	
	@WebTestLog(description = "xxxxxxxxxxxxxxx")
	@RequestMapping("/log")
	public String testAopLog() {
		testService.play();
		logger.info("testAopLog");
		return "success";
	}
}
