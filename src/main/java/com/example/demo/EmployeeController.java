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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.SearchOperation;
import com.google.common.base.Joiner;

@RestController
public class EmployeeController {
 
    @Autowired
    private EmplRepo repo;
 
    @RequestMapping(method = RequestMethod.GET, value = "/employees")
    @ResponseBody
    public Page<Employee> search(@RequestParam(value = "search") String search,Pageable pageable){//List<Employee>
        /*EmployeeSpecificationsBuilder builder = new EmployeeSpecificationsBuilder();
        Pattern pattern = Pattern.compile("(\\w+?)(:|<|>)(\\w+?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(matcher.group(1), matcher.group(2), matcher.group(3));
        }
         
        Specification<Employee> spec = builder.build();
//		return repo.findAll(spec);//comment
		
		//
		final Page<Employee> page = new PageImpl<>(repo.findAll(spec));//--uncomment
		return page;//--uncomment*/
	
		//
    	EmployeeSpecificationsBuilder builder = new EmployeeSpecificationsBuilder();
        String operationSetExper = Joiner.on("|").join(SearchOperation.SIMPLE_OPERATION_SET);
        Pattern pattern = Pattern.compile("(\\w+?)(" + operationSetExper + ")(\\p{Punct}?)(\\w+?)(\\p{Punct}?),");
        Matcher matcher = pattern.matcher(search + ",");
        while (matcher.find()) {
            builder.with(
              matcher.group(1), 
              matcher.group(2), 
              matcher.group(4), 
              matcher.group(3), 
              matcher.group(5));
        }
     
        Specification<Employee> spec = builder.build();
//        return repo.findAll(spec);
        final Page<Employee> page = new PageImpl<>(repo.findAll(spec));//--uncomment
		return page;
    }
    
    //complex search
    @GetMapping(value = "/Employees/spec/adv")
    @ResponseBody
    public List<Employee> findAllByAdvPredicate(@RequestParam(value = "search") String search) {
        Specification<Employee> spec = resolveSpecificationFromInfixExpr(search);
        return repo.findAll(spec);
    }

    protected Specification<Employee> resolveSpecificationFromInfixExpr(String searchParameters) {
        CriteriaParser parser = new CriteriaParser();
        GenericSpecificationsBuilder<Employee> specBuilder = new GenericSpecificationsBuilder<>();
        return specBuilder.build(parser.parse(searchParameters), EmployeeSpecification::new);
    }
    
    
    
}