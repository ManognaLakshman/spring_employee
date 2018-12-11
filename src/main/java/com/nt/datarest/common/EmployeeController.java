package com.nt.datarest.common;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.projection.ProjectionFactory;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nt.datarest.model.Department;
import com.nt.datarest.model.Employee;
import com.nt.datarest.projections.EmployeeProjection;
import com.nt.datarest.repository.EmplRepo;
@CrossOrigin()
@EnableSpringDataWebSupport
@RestController

public class EmployeeController extends GenericController<Employee,Integer>{

	public EmployeeController(ApplicationRepository<Employee, Integer> repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	@Autowired
    private EmplRepo emplrepo;
	

	@Autowired
	private ProjectionFactory factory;
	@Autowired
	private PagedResourcesAssembler<EmployeeProjection> assembler;

	
    protected Specification<Employee> resolveSpecificationFromInfixExpr(String searchParameters) {
        CriteriaParser parser = new CriteriaParser();
        GenericSpecificationsBuilder<Employee> specBuilder = new GenericSpecificationsBuilder<>();
        return specBuilder.build(parser.parse(searchParameters), BaseGenericSpecification::new);
    }
    
    @GetMapping(value = "/employees/search/byadvsearch",produces = "application/json")//remove "produces" key
    @ResponseBody
    public ResponseEntity<?> findAllByAdvPredicate(@RequestParam(value = "advsearch") String search,Pageable pageable){
        Specification<Employee> spec = resolveSpecificationFromInfixExpr(search);
        Page<Employee> emplo= emplrepo.findAll(spec, pageable);
        Page<EmployeeProjection> projected = emplo.map(l -> factory.createProjection(EmployeeProjection.class, l));
        PagedResources<Resource<EmployeeProjection>> resources = assembler.toResource(projected);
        return ResponseEntity.ok(resources);
       
	}
    
    
}
