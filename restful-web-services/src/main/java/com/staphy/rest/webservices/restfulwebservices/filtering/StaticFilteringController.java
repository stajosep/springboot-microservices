package com.staphy.rest.webservices.restfulwebservices.filtering;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StaticFilteringController {
	
	@GetMapping("/static-filtering")
	public SomeBeanForStaticFiltering retrieveSomeBean() {
		return new SomeBeanForStaticFiltering("value1","value2","value3");
	}
	
	
	@GetMapping("/static-filtering-list")
	public List<SomeBeanForStaticFiltering> retrieveSomeBeanList() {
		return Arrays.asList(new SomeBeanForStaticFiltering("value1","value2","value3"),
				new SomeBeanForStaticFiltering("value12","value22","value32"));
	}

}
