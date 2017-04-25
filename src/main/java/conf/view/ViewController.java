package conf.view;

import conf.repo.ProjectRepository;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wlewicki on 3/22/2017.
 */

@Controller
public class ViewController {

    @Autowired
    ProjectRepository repo;

    @Autowired
    CacheManager manago;




    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("project", repo.findByName("test").get(0) );


        return "hello";
    }


}
