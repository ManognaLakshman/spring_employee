package com.example.demo;

import java.util.Date;




import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;



@CrossOrigin()

@RepositoryRestResource(collectionResourceRel="employees",path="employees",excerptProjection = InlineRecords2.class)
public interface EmplRepo extends JpaRepository<Employee, Integer> {

	//
//	Page<Employee> findAll(Pageable pageable);
//	
	@RestResource(path = "byempid", rel = "byempid")
    Page<Employee> findAllByempid(@Param("empid") String empid,Pageable pageable);
	
	@RestResource(path = "byempname", rel = "byempame")
    Page<Employee> findAllByempnameContaining(@Param("empname") String empname,Pageable pageable);//remove StartingWith
	
	@RestResource(path = "byskill", rel = "byskill")
    Page<Employee> findByskillContaining(@Param("skill") String skill,Pageable pageable);
	
//	@RestResource(path = "bydept", rel = "bydept")
//	Page<Employee> findAllBydept(@Param("dept") String dept,Pageable pageable);
	@RestResource(path = "bydeptid", rel = "bydeptid")
	List<Employee> findBydeptid(@Param("deptid") int deptid);//findAllBydeptDeptname 
	
	@RestResource(path = "bydesignation", rel = "bydesignation")
    Page<Employee> findAllBydesignation(@Param("designation") String desigation,Pageable pageable);
	
	@RestResource(path = "bydoj", rel = "bydoj")
    List<Employee> findAllBydoj(@Param("doj")Date doj);
//	List<Employee> findAllByOrderBydojAsc();
//	List<Employee> findAllByOrderBydojDesc();
	
	
	
	@RestResource(path = "bysalary", rel = "bysalary")
    Page<Employee> findAllBysalary(@Param("salary") float salary,Pageable pageable);
//	//
	
	
	@RestResource(path = "bygrade", rel = "bygrade")
    Page<Employee> findAllBygrade(@Param("grade") int grade,Pageable pageable);
	
	
	@RestResource(path = "bycity", rel = "bycity")
    Page<Employee> findAllBycity(@Param("city") String city,Pageable pageable);
	
	
	@RestResource(path = "bycountry", rel = "bycountry")
    Page<Employee> findAllBycountry(@Param("country") String country,Pageable pageable);

	
	
	
	
	//	//
	
	
	//testing delete by
	@Transactional
	@RestResource(path = "deletebyempname", rel = "deletebyempname")
    List<Employee> deleteByempname(@Param("name") String empname);//remove StartingWith
	
	
	
//	
}
