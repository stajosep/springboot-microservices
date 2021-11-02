package com.oracle.hr;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pathology")
public class PathologyResource {
	
	List<Disease> diseases = Arrays.asList(
			new Disease("D1", "Asthama", "Hot Water Vapour"),
			new Disease("D2", "Headache", "Hot water bath"),
			new Disease("D3", "Corona", "Wash hands and Stay safe"));

	
	@RequestMapping("/diseases")
	public DiseaseList diseases() {
		DiseaseList diseaseList = new DiseaseList();
		diseaseList.setDiseases(diseases);
		return diseaseList;
	}
	
	@RequestMapping("/diseases/{id}")
	public Disease getDiseaseById(@PathVariable("id")String Id) {
		Disease d = diseases.stream().filter(disease -> disease.getId().equals(Id)).findAny().orElse(null);
		return d;
	}
	

}
