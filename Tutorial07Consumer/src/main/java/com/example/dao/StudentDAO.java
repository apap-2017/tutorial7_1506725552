package com.example.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.StudentModel;

public interface StudentDAO {
	
	StudentModel selectStudent ( String npm );
	
	List < StudentModel > selectAllStudents ();
}
