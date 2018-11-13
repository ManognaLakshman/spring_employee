package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Department {
//mapping here
	@Id
//	@OneToMany(mappedBy = "dept")
	private String departmentname;
	@OneToMany(cascade=CascadeType.ALL)
	  private List<Employee> employee;

	private String depthead;
	
	
	public String getDepthead() {
		return depthead;
	}

	public void setDepthead(String depthead) {
		this.depthead = depthead;
	}

	public String getDepartmentname() {
		return departmentname;
	}

	public void setDepartmentname(String departmentname) {
		this.departmentname = departmentname;
	}
	
}
