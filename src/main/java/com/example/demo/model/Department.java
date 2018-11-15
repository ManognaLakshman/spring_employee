package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@Table(name="department")
public class Department {

	@Id
	private String deptname;
//	private String depthead;
	
//	@OneToOne(mappedBy="empname")
	@OneToOne
	@JoinColumn(name="empname")
	private Employee depthead;
	
		

//	public String getDepthead() {
//		return depthead;
//	}
//	public void setDepthead(String depthead) {
//		this.depthead = depthead;
//	}
	
	
	
//	public List<Employee> getDeptname() {
//		return deptname;
//	}
//	public void setDeptname(List<Employee> deptname) {
//		this.deptname = deptname;
//	}

	
	
	
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	
	

	
	
}
