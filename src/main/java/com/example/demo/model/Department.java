package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@Table(name="department")
public class Department {

	@Id
	private String deptname;
	private String depthead;
	
//	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	//
	
	
	@OneToMany(mappedBy="department")
//	@JoinColumn(name="deptname", referencedColumnName = "dept",nullable = false)//comment this acc to akar code
	private List<Employee> department=new ArrayList<Employee>();
//	private String deptname;
	
	
	
	
	public List<Employee> getdepartment() {
		return department;
	}
	public void setdepartment(List<Employee> department) {
		this.department = department;
	}
	
	
	public String getDepthead() {
		return depthead;
	}
	public void setDepthead(String depthead) {
		this.depthead = depthead;
	}
	
	
	//comment below if list is used
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getDeptname() {
		return deptname;
	}
	
	
	
	
	
}
