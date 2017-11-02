package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.StudentModel;

@Service
public class StudentDAOImpl implements StudentDAO{

	@Autowired
	private RestTemplateBuilder restTemplate;
	
	@Override
	public StudentModel selectStudent ( String npm){
		StudentModel student = restTemplate.build().getForObject ( "http://localhost:8080/rest/student/view/" + npm, StudentModel.class );
		return student;
	}
	@Override
	public List < StudentModel > selectAllStudents (){
		ResponseEntity<List<StudentModel>> rateResponse = restTemplate.build().exchange("http://localhost:8080/rest/student/viewall", HttpMethod.GET, null, new ParameterizedTypeReference<List<StudentModel>>() {});
		return rateResponse.getBody();
	}

}
