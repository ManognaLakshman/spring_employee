package com.example.demo;

import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;

@RestController
public class EmployeeController {
 
    @Autowired
    private EmplRepo repo;
 
    @RequestMapping(method = RequestMethod.GET, value = "/Employees")
    @ResponseBody
    public Page<Employee> search(@RequestParam(value = "search") String search,Pageable pageable){//List<Employee>
        EmployeeSpecificationsBuilder builder = new EmployeeSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
         
        Specification<Employee> spec = builder.build();
//		return repo.findAll(spec);//comment
		
		//
		final Page<Employee> page = new PageImpl<>(repo.findAll(spec));//--uncomment
		return page;//--uncomment
	
		//
    }
    
    
    
}