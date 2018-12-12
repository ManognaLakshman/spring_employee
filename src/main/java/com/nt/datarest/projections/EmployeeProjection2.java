package com.nt.datarest.projections;


import java.util.Date;


import org.springframework.data.rest.core.config.Projection;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.datarest.model.Department;
import com.nt.datarest.model.Employee;


@Projection(name = "inlineRecords3", types = { Employee.class }) //FOR EMPLOYEE
public interface EmployeeProjection2 {
	int getId();
	String getName();
	String getSkill();
	float getSalary();
	int getGrade();
	String getCity();
	String getCountry();
	Date getDoj();
	String getDesg();
}