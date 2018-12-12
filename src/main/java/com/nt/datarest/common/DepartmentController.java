package com.nt.datarest.common;

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

import com.nt.datarest.model.Department;
import com.nt.datarest.projections.DepartmentProjection;
import com.nt.datarest.repository.DeptRepo;
import com.querydsl.core.types.Predicate;


import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
@CrossOrigin()
@EnableSpringDataWebSupport
@RestController

public class DepartmentController extends GenericController<Department,Integer>{

	public DepartmentController(ApplicationRepository<Department, Integer> repo) {
		super(repo);
		// TODO Auto-generated constructor stub
	}

	@Autowired
    private DeptRepo deptrepo;

	@Autowired
	private ProjectionFactory factory;
	@Autowired
	private PagedResourcesAssembler<DepartmentProjection> assembler;
	
//	@Autowired
//	public DepartmentController(ApplicationRepository<Department, Integer> repo) {
//		super(repo);
//	}

//    protected Specification<Department> resolveSpecificationFromInfixExpr(String searchParameters) {
//        CriteriaParser parser = new CriteriaParser();
//        GenericSpecificationsBuilder<Department> specBuilder = new GenericSpecificationsBuilder<>();
//        return specBuilder.build(parser.parse(searchParameters), BaseGenericSpecification::new);
//    }
    
    @GetMapping(value = "/departments/search/byadvsearch",produces = "application/json")//remove "produces" key
    @ResponseBody
    public ResponseEntity<?> findAllByAdvPredicate(@RequestParam(value = "advsearch") String search,Pageable pageable) throws BadRequestException{
    	Page<Department> emplo;
    	if(search!=null && !search.isEmpty()) {
    	Specification<Department> spec = resolveSpecificationFromInfixExpr(search);
    	emplo = deptrepo.findAll(spec, pageable);
        }
        else {
        emplo= deptrepo.findAll(pageable);
        }
        
        Page<DepartmentProjection> projected = emplo.map(l -> factory.createProjection(DepartmentProjection.class, l));
        PagedResources<Resource<DepartmentProjection>> resources = assembler.toResource(projected);
        return ResponseEntity.ok(resources);
       	
	}
    
    
}
