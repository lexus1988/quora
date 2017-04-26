package com.wlewicki.service;


import com.wlewicki.model.Project;

import java.util.List;

public interface ProjectService {
	
	Project findById(Long id);
	List<Project>  findByName(String name);
	List<Project> findAllProjects();
}