package com.example.demo;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;


import com.example.demo.model.Employee;
import com.example.demo.model.SearchCriteria;

public class EmployeeSpecificationsBuilder {
    
    private final List<SearchCriteria> params;
 
    public EmployeeSpecificationsBuilder() {
        params = new ArrayList<SearchCriteria>();
    }
 
    public EmployeeSpecificationsBuilder with(String key, String operation, Object value) {
        params.add(new SearchCriteria(key, operation, value));
        return this;
    }
 
    public Specification<Employee> build() {
        if (params.size() == 0) {
            return null;
        }
 
        @SuppressWarnings("rawtypes")
		List<Specification> specs = params.stream().map(EmployeeSpecification::new).collect(Collectors.toList());
               
              Specification<Employee> result = specs.get(0);
       
              for (int i = 1; i < params.size(); i++) {
                  result = params.get(i).isOrPredicate()? Specification.where(result).or(specs.get(i)): Specification.where(result).and(specs.get(i));
              }       
              return result;
          }
    
    
    
      }
