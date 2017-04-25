package conf.repo;

import java.util.List;

import conf.model.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project, Long> {

    List<Project> findByName(String name);
}
