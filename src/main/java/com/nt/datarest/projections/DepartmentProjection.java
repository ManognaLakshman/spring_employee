package com.nt.datarest.projections;

import org.springframework.data.rest.core.config.Projection;

import com.nt.datarest.model.Department;
import com.nt.datarest.model.Employee;

@Projection(name = "inlineRecords", types = { Department.class })// THIS IS FOR DEPARTMENT
public interface DepartmentProjection {
	
	int getDeptid();
	String getDeptname();
	
//	Employee getDepthead();
	EmployeeProjection2 getDepthead();
}

