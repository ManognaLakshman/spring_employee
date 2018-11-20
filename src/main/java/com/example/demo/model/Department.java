package com.example.demo.model;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="department")
public class Department implements Serializable{

	@Id//UNCOMMENT ID and next two lines
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_seq_gene")
	@SequenceGenerator(name="my_seq_gene", sequenceName="depid_seq",allocationSize=1)
	private int deptid;
	
	@Column(unique=true)
	private String deptname;
	
//	@Column(nullable=true)//uncomment if screwed up
//	private String depthead;
	
	
	
	
	//comment if screwed---------
	@OneToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="deptheadid",nullable=true)
//	@Fetch(FetchMode.JOIN)
	private Employee depthead;
	
	public Employee getDepthead() {
		return depthead;
	}
	public void setDepthead(Employee depthead) {
		this.depthead = depthead;
	}
	//---------------------------

		

	
	
	
//	public String getDepthead() {
//		return depthead;
//	}
//	public void setDepthead(String depthead) {
//		this.depthead = depthead;
//	}
	

	
	public int getDeptid() {
		return deptid;
	}
	public void setDeptid(int deptid) {
		this.deptid = deptid;
	}
	
	
	
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	
	
	

	
	
}
