package com.example.demo;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;

@Projection(name = "inlineRecords", types = { Department.class })// THIS IS FOR DEPARTMENT
public interface InlineRecords {
	
	int getDeptid();
	String getDeptname();
//	Employee getDepthead();

	InlineRecords3 getDepthead();
}

