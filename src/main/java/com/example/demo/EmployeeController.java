package com.example.demo;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Employee;
import com.example.demo.model.EmployeeSpecification;
import com.example.demo.model.GenericSpecificationsBuilder;
import com.querydsl.core.types.Predicate;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
@CrossOrigin()
@EnableSpringDataWebSupport
@RestController

public class EmployeeController{

	@Autowired
    private EmplRepo emplrepo;
	
////REST Query Language with Querydsl Web Support
//	@RequestMapping(method = RequestMethod.GET, value = "/Employees")
//    @ResponseBody
//    public Iterable<Employee> findAllByWebQuerydsl(@QuerydslPredicate(root = Employee.class) Predicate predicate) {
//        return emplrepo.findAll(predicate);
//    }
//	
	//comment these
	@Autowired
	private ProjectionFactory factory;
	@Autowired
	private PagedResourcesAssembler<InlineRecords2> assembler;

	//
	
//	@GetMapping(value = "/employees/search/byadvsearch",produces = "application/json")//remove "produces" key
//    @ResponseBody
//    public Page<Employee> findAllByAdvPredicate(@RequestParam(value = "advsearch") String search,Pageable pageable){
//        Specification<Employee> spec = resolveSpecificationFromInfixExpr(search);
//        return emplrepo.findAll(spec, pageable);
//       
//	}
    protected Specification<Employee> resolveSpecificationFromInfixExpr(String searchParameters) {
        CriteriaParser parser = new CriteriaParser();
        GenericSpecificationsBuilder<Employee> specBuilder = new GenericSpecificationsBuilder<>();
        return specBuilder.build(parser.parse(searchParameters), EmployeeSpecification::new);
    }
    
    @GetMapping(value = "/employees/search/byadvsearch",produces = "application/json")//remove "produces" key
    @ResponseBody
    public ResponseEntity<?> findAllByAdvPredicate(@RequestParam(value = "advsearch") String search,Pageable pageable){
        Specification<Employee> spec = resolveSpecificationFromInfixExpr(search);
        Page<Employee> emplo= emplrepo.findAll(spec, pageable);
        Page<InlineRecords2> projected = emplo.map(l -> factory.createProjection(InlineRecords2.class, l));
        PagedResources<Resource<InlineRecords2>> resources = assembler.toResource(projected);
        return ResponseEntity.ok(resources);
       
	}
    
    
}
