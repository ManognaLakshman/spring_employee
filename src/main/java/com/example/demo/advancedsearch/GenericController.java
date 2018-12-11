package com.example.demo.advancedsearch;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.demo.ApplicationRepository;
import com.example.demo.model.Department;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;
import java.util.function.Function;



public abstract class GenericController<T, ID extends Serializable> {

    private final Logger log = LoggerFactory.getLogger(getClass());

    private ApplicationRepository<T, ID> repo;
//    private String baseUri;

    public GenericController(/*String baseUri,*/ ApplicationRepository<T, ID> repo) {
//        this.baseUri = baseUri;
        this.repo = repo;
    }

    protected Logger getLogger() {
        return log;
    }

    
    protected Specification<T> resolveSpecificationFromInfixExpr(String searchParameters) {
        CriteriaParser parser = new CriteriaParser();
        GenericSpecificationsBuilder<T> specBuilder = new GenericSpecificationsBuilder<>();
        return specBuilder.build(parser.parse(searchParameters), BaseGenericSpecification::new);
    }
    
   
}