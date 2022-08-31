package com.springboot.pathologyservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pathologyservice.models.Disease;
import com.springboot.pathologyservice.models.DiseasesList;

@RestController
@RequestMapping("/pathology")
public class PathologyService {

	List<Disease> diseases = Arrays.asList(new Disease("A123", "Asthma", "Warm water bath"),
			new Disease("S123", "Thyroid", "Ampicilis Calsules"));

	@RequestMapping("/diseases")
	public DiseasesList getDiseases() {
		
		DiseasesList diseasesList = new DiseasesList();
		diseasesList.setDiseases(diseases);
		return diseasesList;
	}

	@RequestMapping("/diseases/{id}")
	public Disease getDiseaseById(@PathVariable("id") String id) {

		Disease d = diseases.stream().filter(disease -> id.equals(disease.getId())).findAny().orElse(null);

		return d;
	}

}
