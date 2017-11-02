package com.example.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.CourseModel;

@Service
public class CourseDAOImpl implements CourseDAO{
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	@Override
	public CourseModel selectCourse(String idCourse) {
		CourseModel course = restTemplateBuilder.build()
				.getForObject("http://localhost:8080/rest/course/view/" + idCourse, CourseModel.class);
		return course;
	}

	@Override
	public List<CourseModel> selectAllCourse() {
		ResponseEntity<List<CourseModel>> rateResponse = restTemplateBuilder.build()
				.exchange("http://localhost:8080/rest/course/viewall", HttpMethod.GET, null, new ParameterizedTypeReference<List<CourseModel>>() {});
		return rateResponse.getBody();
	}
	
	
	
}
