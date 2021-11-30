package com.staphy.rest.webservices.restfulwebservices.filtering.dynamic;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@RestController
public class DynamicFilteringController {
	
	//If only field1 and field2 need to be added to the response
	@GetMapping("/dynamic-filtering")
	public MappingJacksonValue retrieveSomeBean() {
		SomeBeanForDynamicFiltering someBeanForDynamicFiltering = new SomeBeanForDynamicFiltering("value1","value2","value3");
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field2");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanDynamicFilter", filter );
		MappingJacksonValue mapping = new MappingJacksonValue(someBeanForDynamicFiltering);
		
		mapping.setFilters(filters);
		return mapping;
	}
	
	//If only field2 and field3 need to be added to the response
	@GetMapping("/dynamic-filtering-list")
	public MappingJacksonValue retrieveSomeBeanList() {
		List<SomeBeanForDynamicFiltering> beanlist = Arrays.asList(new SomeBeanForDynamicFiltering("value1","value2","value3"),
				new SomeBeanForDynamicFiltering("value12","value22","value32"));
		
		SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
		FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanDynamicFilter", filter );
		MappingJacksonValue mapping = new MappingJacksonValue(beanlist);
		
		mapping.setFilters(filters);
		return mapping;
	}

}
