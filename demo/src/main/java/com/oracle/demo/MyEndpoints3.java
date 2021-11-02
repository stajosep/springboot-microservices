package com.oracle.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyEndpoints3 {
	@Autowired
	ExampleProperties props;
	
	@RequestMapping("/greetothers")
	public String greet(@RequestParam String detail) {
		return props.getGreeting()+" : "+detail;
	}

}
