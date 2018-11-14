package com.example.demo.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
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
//@Table(name="employee")
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

	
//	@ManyToOne(fetch = FetchType.EAGER)
	
	//
	@ManyToOne
//	@JoinColumn(name="departmentId")
	//
	private Department department;
//	private String dept1;
	
	
	private String skill;
	private float salary;
	private int grade;
	private String city;
	private String country;
	@Temporal(TemporalType.DATE)
	private Date dOJ;
	private String designation;//total 10 attributes
	
	
	//////uncomment
	public Department getDepartment() {
		return department;
	}
	public void setDepartment(Department department) {
		this.department= department;
	}
	
	///////
//	public String getDept1() {
//		return dept1;
//	}
//	public void setDept1(String dept1) {
//		this.dept1 = dept1;
//	}
	
///////experiment
//	public String getDeptdeptname() {
//		return dept.getDeptname();
//	}
//	public void setDeptdeptname(Department deptdeptname) {
//		this.dept = deptdeptname;
//	}
	
	
	////////
	////////
	
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
	public String getEmpname() {
		return empname;
	}
	public void setEmpname(String empname) {
		this.empname = empname;
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
		return "Employee [empid=" + empid + ", empname=" + empname + ", dept=" +department+ ", skill=" + skill + ", DOJ="
				+ dOJ + ", designation=" + designation + "]";
	}
	
	
}
