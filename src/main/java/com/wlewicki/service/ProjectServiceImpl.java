package com.wlewicki.service;

import com.wlewicki.model.Project;
import com.wlewicki.repo.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service("projecService")
@Transactional
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectRepository projectRepository;

	public Project findById(Long id) {
		return projectRepository.findOne(id);
	}

	public List<Project> findByName(String name) {
		return projectRepository.findByName(name);
	}

	public List<Project> findAllProjects(){
		return projectRepository.findAll();
	}

	public void saveProject(Project project) { projectRepository.save(project); };

}
