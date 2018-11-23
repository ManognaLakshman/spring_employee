package com.example.demo;

import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;

@Projection(name = "inlineRecords2", types = { Employee.class }) //FOR EMPLOYEE
public interface InlineRecords2 {
	int getEmpid();
	String getEmpname();
	Department getDeptid();//uncomment
	String getSkill();
	float getSalary();
	int getGrade();
	String getCity();
	String getCountry();
	Date getDoj();
	String getDesignation();
}