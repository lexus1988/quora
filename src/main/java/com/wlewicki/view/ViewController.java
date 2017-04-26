package com.wlewicki.view;

import com.wlewicki.repo.ProjectRepository;
import net.sf.ehcache.CacheManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wlewicki on 3/22/2017.
 */

@Controller
public class ViewController {

    @Autowired
    ProjectRepository repo;

    @RequestMapping("/")
    String home(ModelMap modal) {
        modal.addAttribute("title","CRUD Example");
        return "index";
    }

    @RequestMapping("/partials/{page}")
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }


    @RequestMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("project", repo.findByName("test").get(0) );


        return "hello";
    }


}
