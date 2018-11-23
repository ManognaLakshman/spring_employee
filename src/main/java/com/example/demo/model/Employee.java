package com.example.demo.model;

import java.io.Serializable;
import java.util.Date;


import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
//import org.springframework.data.jpa.repository.Temporal;
//import org.jboss.logging.Field;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="employee")
public class Employee implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id//UNCOMMENT ID and next two lines
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_seq_gen")
	@SequenceGenerator(name="my_seq_gen", sequenceName="id_seq",allocationSize=1)
	private int empid;	
	
	private String empname;
	
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="deptid")
	//this is written to avoid infinite recursion
	@JsonManagedReference
	//	
	private Department deptid;
	
	
	
	
	private String skill;
	private float salary;
	private int grade;
	private String city;
	private String country;
	@Temporal(TemporalType.DATE)
	private Date doj;
	private String designation;//total 10 attributes
	
	
	/////deptid setter and getter
	public Department getDeptid() {
		return deptid;
	}
	public void setDeptid(Department deptid) {
		this.deptid = deptid;
	}
	
	
	
	
	public int getGrade() {
		return grade;
	}
	
	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public float getSalary() {
		return salary;
	}
	public void setSalary(float salary) {
		this.salary = salary;
	}
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	//----------
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	
	
	
	//----------
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	
	public Date getDoj() {
		return doj;
	}
	public void setDoj(Date doj) {
		this.doj = doj;
	}
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	
	
	
}
