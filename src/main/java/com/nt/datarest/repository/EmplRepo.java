package com.nt.datarest.repository;

import java.util.Date;




import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.nt.datarest.model.QEmployee;
import com.nt.datarest.common.ApplicationRepository;
import com.nt.datarest.model.Department;
import com.nt.datarest.model.Employee;
import com.nt.datarest.projections.EmployeeProjection;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;

import io.swagger.annotations.Api;



@CrossOrigin()
@Api(tags = "Employee Entity")
@RepositoryRestResource(collectionResourceRel="employees",path="employees",excerptProjection = EmployeeProjection.class)
public interface EmplRepo extends ApplicationRepository<Employee, Integer>{//JpaRepository<Employee, Integer>{

//	@RestResource
//	Page<Employee> findAll(Specification spec,Pageable pageable);
////	
//	@RestResource(path = "byid", rel = "byid")
//    Page<Employee> findAllByid(@Param("id") Integer id,Pageable pageable);
//	
//	
//	@RestResource(path = "byname", rel = "byname")
//    Page<Employee> findAllBynameContaining(@Param("name") String name,Pageable pageable);
//	
//	@RestResource(path = "byskill", rel = "byskill")
//    Page<Employee> findByskillContaining(@Param("skill") String skill,Pageable pageable);
//	
//	@RestResource(path = "bydept", rel = "bydept")
//	List<Employee> findBydept(@Param("dept") Department dept);//findAllBydeptDeptname 
//	
//	@RestResource(path = "bydesg", rel = "bydesg")
//    Page<Employee> findAllBydesgContaining(@Param("desg") String desg,Pageable pageable);
//	
//	@RestResource(path = "bydoj", rel = "bydoj")
//    List<Employee> findAllBydoj(@Param("doj")Date doj);
////	List<Employee> findAllByOrderBydojAsc();
////	List<Employee> findAllByOrderBydojDesc();
//	
//	
//	
//	@RestResource(path = "bysalary", rel = "bysalary")
//    Page<Employee> findAllBysalary(@Param("salary") float salary,Pageable pageable);
////	//
//	
//	
//	@RestResource(path = "bygrade", rel = "bygrade")
//    Page<Employee> findAllBygrade(@Param("grade") Integer grade,Pageable pageable);
//	
//	
//	@RestResource(path = "bycity", rel = "bycity")
//    Page<Employee> findAllBycityContaining(@Param("city") String city,Pageable pageable);
//	
//	
//	@RestResource(path = "bycountry", rel = "bycountry")
//    Page<Employee> findAllBycountryContaining(@Param("country") String country,Pageable pageable);

	
	
	
	

	
	
	//testing delete by
//	@Transactional
//	@RestResource(path = "deletebyname", rel = "deletebyname")
//    List<Employee> deleteBynameContaining(@Param("name") String name);
	//
	
	
//	
}
