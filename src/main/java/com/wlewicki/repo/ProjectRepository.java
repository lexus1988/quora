package com.wlewicki.repo;

import java.util.List;

import com.wlewicki.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findByName(String name);
    List<Project> findAll();
}
