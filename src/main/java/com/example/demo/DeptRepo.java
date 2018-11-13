package com.example.demo;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Department;
import com.example.demo.model.Employee;

@RepositoryRestResource(collectionResourceRel="departments",path="departments")
public interface DeptRepo extends JpaRepository<Department, Integer> {
	
	@RestResource(path = "bydepartmentname", rel = "bydepartmentname")
    Page<Department> findAllBydepartmentnameContaining(@Param("departmentname") String departmentname,Pageable pageable);

	@RestResource(path = "bydepthead", rel = "bydepthead")
    Page<Department> findAllBydeptheadContaining(@Param("depthead") String depthead,Pageable pageable);
}