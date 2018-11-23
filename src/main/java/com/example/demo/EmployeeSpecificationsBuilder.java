package com.example.demo;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.data.jpa.domain.Specification;


import com.example.demo.model.Employee;
import com.example.demo.model.SearchOperation;
import com.example.demo.model.SpecSearchCriteria;

public final class EmployeeSpecificationsBuilder {
    
	 private final List<SpecSearchCriteria> params;

	    public EmployeeSpecificationsBuilder() {
	        params = new ArrayList<>();
	    }

	    // API

	    public final EmployeeSpecificationsBuilder with(final String key, final String operation, final Object value, final String prefix, final String suffix) {
	        return with(null, key, operation, value, prefix, suffix);
	    }

	    public final EmployeeSpecificationsBuilder with(final String orPredicate, final String key, final String operation, final Object value, final String prefix, final String suffix) {
	        SearchOperation op = SearchOperation.getSimpleOperation(operation.charAt(0));
	        if (op != null) {
	            if (op == SearchOperation.EQUALITY) { // the operation may be complex operation
	                final boolean startWithAsterisk = prefix != null && prefix.contains(SearchOperation.ZERO_OR_MORE_REGEX);
	                final boolean endWithAsterisk = suffix != null && suffix.contains(SearchOperation.ZERO_OR_MORE_REGEX);

	                if (startWithAsterisk && endWithAsterisk) {
	                    op = SearchOperation.CONTAINS;
	                } else if (startWithAsterisk) {
	                    op = SearchOperation.ENDS_WITH;
	                } else if (endWithAsterisk) {
	                    op = SearchOperation.STARTS_WITH;
	                }
	            }
	            params.add(new SpecSearchCriteria(orPredicate, key, op, value));
	        }
	        return this;
	    }

	    public Specification<Employee> build() {
	        if (params.size() == 0)
	            return null;

	        Specification<Employee> result = new EmployeeSpecification(params.get(0));
	     
	        for (int i = 1; i < params.size(); i++) {
	            result = params.get(i).isOrPredicate()
	              ? Specification.where(result).or(new EmployeeSpecification(params.get(i))) 
	              : Specification.where(result).and(new EmployeeSpecification(params.get(i)));
	        }
	        
	        return result;
	    }

	    public final EmployeeSpecificationsBuilder with(EmployeeSpecification spec) {
	        params.add(spec.getCriteria());
	        return this;
	    }

	    public final EmployeeSpecificationsBuilder with(SpecSearchCriteria criteria) {
	        params.add(criteria);
	        return this;
	    }
	}