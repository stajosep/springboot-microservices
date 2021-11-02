package com.oracle.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyEndPoints {
	
	@RequestMapping("/mypage")
	public String myString() {
		return "First Mircoservice end point";
	}
	
	@RequestMapping("/second")
	public String welcome(@RequestParam String name) {
		return "Welcome "+name;
	}

	@RequestMapping("/secondpathvar/{name}")
	public String welcome2(@PathVariable String name) {
		return "Path Definitions : "+name;
	}
	
	@GetMapping(path="/secondbeansample")
	public SecondSampleBean secondSampleBean() {
		return new SecondSampleBean("Oracle Trivandrum");
	}
}
