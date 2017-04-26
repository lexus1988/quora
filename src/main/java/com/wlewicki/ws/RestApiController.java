package com.wlewicki.ws;

import com.wlewicki.model.Project;
import com.wlewicki.service.ProjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
@RequestMapping("/api")
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    ProjectService projectService;

    @RequestMapping(value = "/project/", method = RequestMethod.GET)
    public ResponseEntity<List<Project>> listAllProjects() {
        List<Project> projects = projectService.findAllProjects();
        if (projects.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Project>>(projects, HttpStatus.OK);
    }


    @RequestMapping(value = "/project/", method = RequestMethod.POST)
    public ResponseEntity<?> createProject(@RequestBody Project project, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Project : {}", project);
        projectService.saveProject(project);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }


}