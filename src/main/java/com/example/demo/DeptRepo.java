package com.example.demo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.example.demo.model.Department;

@CrossOrigin()
@RepositoryRestResource(collectionResourceRel="departments",path="departments",excerptProjection = InlineRecords.class)
public interface DeptRepo extends JpaRepository<Department, Integer> {
	
	@RestResource(path = "bydeptid", rel = "bydeptid")
	Page<Department> findAllBydeptid(@Param("deptid") int deptid,Pageable pageable);
	
	@RestResource(path = "bydeptname", rel = "bydeptname")
	Page<Department> findAllBydeptnameContaining(@Param("deptname") String deptname,Pageable pageable);
	
	@RestResource(path = "bydepthead", rel = "bydepthead")
	Page<Department> findAllBydepthead(@Param("depthead") int depthead,Pageable pageable);//UNCOMMENT
	
	//
	
	//
}