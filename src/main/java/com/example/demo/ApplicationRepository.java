package com.example.demo;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin()
@NoRepositoryBean
public interface ApplicationRepository<T, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor {
	@RestResource
	Page<T> findAll(Specification spec,Pageable pageable);
}
