package conf.ws;


import conf.model.Project;
import conf.model.ReleaseItem;
import conf.repo.ProjectRepository;
import conf.repo.ReleaseItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wlewicki on 3/22/2017.
 */

@RestController
public class WSController {

    @Autowired
    ProjectRepository repo;

    @Autowired
    ReleaseItemRepository releaseItemRepository;

    @RequestMapping("/add")
    public void add() {
        Project project = new Project("test", "test");
        ReleaseItem item = new ReleaseItem("df");

        releaseItemRepository.save(item);
        List items = new ArrayList<ReleaseItem>();
        items.add(item);
        project.setReleaseItems(items);

        repo.save(project);
    }

}
