package com.example.demo;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Employee;
import com.example.demo.model.QEmployee;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;



@CrossOrigin()

@RepositoryRestResource(collectionResourceRel="employees",path="employees",excerptProjection = InlineRecords2.class)
public interface EmplRepo extends JpaRepository<Employee, Integer>{
	//websupport

	//
	
	
	//
	Page<Employee> findAll(Specification spec,Pageable pageable);//comment
//	
	@RestResource(path = "byempid", rel = "byempid")
    Page<Employee> findAllByempidContaining(@Param("empid") String empid,Pageable pageable);
	
	@RestResource(path = "byempname", rel = "byempame")
    Page<Employee> findAllByempnameContaining(@Param("empname") String empname,Pageable pageable);//remove StartingWith
	
	@RestResource(path = "byskill", rel = "byskill")
    Page<Employee> findByskillContaining(@Param("skill") String skill,Pageable pageable);
	
//	@RestResource(path = "bydept", rel = "bydept")
//	Page<Employee> findAllBydept(@Param("dept") String dept,Pageable pageable);
	@RestResource(path = "bydeptid", rel = "bydeptid")
	List<Employee> findBydeptidContaining(@Param("deptid") int deptid);//findAllBydeptDeptname 
	
	@RestResource(path = "bydesignation", rel = "bydesignation")
    Page<Employee> findAllBydesignationContaining(@Param("designation") String desigation,Pageable pageable);
	
	@RestResource(path = "bydoj", rel = "bydoj")
    List<Employee> findAllBydojContaining(@Param("doj")Date doj);
//	List<Employee> findAllByOrderBydojAsc();
//	List<Employee> findAllByOrderBydojDesc();
	
	
	
	@RestResource(path = "bysalary", rel = "bysalary")
    Page<Employee> findAllBysalaryContaining(@Param("salary") float salary,Pageable pageable);
//	//
	
	
	@RestResource(path = "bygrade", rel = "bygrade")
    Page<Employee> findAllBygradeContaining(@Param("grade") int grade,Pageable pageable);
	
	
	@RestResource(path = "bycity", rel = "bycity")
    Page<Employee> findAllBycityContaining(@Param("city") String city,Pageable pageable);
	
	
	@RestResource(path = "bycountry", rel = "bycountry")
    Page<Employee> findAllBycountryContaining(@Param("country") String country,Pageable pageable);

	
	
	
	

	
	
	//testing delete by
//	@Transactional
//	@RestResource(path = "deletebyempname", rel = "deletebyempname")
//    List<Employee> deleteByempnameContaining(@Param("name") String empname);
	//
	
	
//	
}
