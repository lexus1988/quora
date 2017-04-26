package com.wlewicki.view;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by wlewicki on 3/22/2017.
 */

@Controller
public class ViewController {


    @RequestMapping("/")
    String home(ModelMap modal) {
        return "index";
    }

    @RequestMapping("/partials/{page}")
    String partialHandler(@PathVariable("page") final String page) {
        return page;
    }





}
