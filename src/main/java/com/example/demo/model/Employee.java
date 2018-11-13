package com.example.demo.model;

import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;
//import org.springframework.data.jpa.repository.Temporal;
//import org.jboss.logging.Field;
//
//@Document(indexName="employees")
//
//enum country{
//	INDIA,USA,UK,JAPAN,PAKISTAN,KAZAKISTAN,AFGHANISTAN,KENYA,UGANDA,NAIROBI,SIRIYA,IRAQ,IRAN,NIGERIA,CZECHREPUBLIC,BRAZIL,MOROCCO,TURKEY,BANGLADESH,WAKANDA,MALDIVES,MALASIA,ASGUARD,AMAZON,ATLANTIS,KNOWWHERE,TITAN,KRYPTON
//}

@Entity
public class Employee {
	//@Id
	//@GeneratedValue
	
//	 @org.hibernate.annotations.GenericGenerator(name="logSequenceGenerator", strategy = "sequence-identity",
//	    parameters = {@org.hibernate.annotations.Parameter(name="sequence", value="id_seq")})
//	  @GeneratedValue(generator = "logSequenceGenerator")
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_seq_gen")
	@SequenceGenerator(name="my_seq_gen", sequenceName="id_seq",allocationSize=1)
	  
	//@GeneratedValue(strategy = GenerationType.SEQUENCE, 
    //generator = "idseq")
	//@SequenceGenerator(name = "idseq", 
    //sequenceName = "id_seq")
	
	private int empid;
	
	private String empname;
	private String dept;
	private String skill;
	
	private float salary;
	private int grade;
	
	private String city,country;
	
	
	
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
	
	
	@Temporal(TemporalType.DATE)
	private Date dOJ;
	private String designation;
	
	
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Date getDOJ() {
		return dOJ;
	}
	public void setDOJ(Date dOJ) {
		this.dOJ = dOJ;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", empname=" + empname + ", dept=" + dept + ", skill=" + skill + ", DOJ="
				+ dOJ + ", designation=" + designation + "]";
	}
	
	
}
