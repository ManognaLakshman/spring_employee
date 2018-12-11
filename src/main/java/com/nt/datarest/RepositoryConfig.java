package com.nt.datarest;

import org.springframework.context.annotation.Configuration;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.http.MediaType;

import com.nt.datarest.projections.DepartmentProjection;
import com.nt.datarest.projections.EmployeeProjection;
import com.nt.datarest.projections.EmployeeProjection2;

@Configuration
public class RepositoryConfig extends RepositoryRestConfigurerAdapter {

  @Override
  public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
    config.getProjectionConfiguration().addProjection(DepartmentProjection.class);
    
    config.getProjectionConfiguration().addProjection(EmployeeProjection.class);

    config.getProjectionConfiguration().addProjection(EmployeeProjection2.class);
    
    //
    config.setDefaultMediaType(MediaType.APPLICATION_JSON);
    config.useHalAsDefaultJsonMediaType(false);
    //
  }
}