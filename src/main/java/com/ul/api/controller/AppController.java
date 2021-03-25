package com.ul.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ul.api.request.model.ProjectCreationReqObj;
import com.ul.api.response.model.ProjectResponseObj;
import com.ul.api.services.ProjectServices;

/**
 * Application Controller
 * Specifies the REST Endpoints For Project Service Operations
 * @author Sathyanand.Jebakumar
 *
 */
@RestController
@RequestMapping(value="/")
public class AppController {
	
	@Autowired
	ProjectServices projectServices;
	/**
	 * REST Based Project Creation Endpoint
	 * Takes In Project Name and Status As Input
	 * @param projectReq
	 * @return
	 */
	@PostMapping(value="projects")
	public ProjectResponseObj createProject(@RequestBody ProjectCreationReqObj projectReq){
		return projectServices.saveProject(projectReq);
	}
	
	/**
	 * REST Based Get All Project Records From DB Endpoint
	 * @return
	 */
	@GetMapping(value="projects")
	public List<ProjectResponseObj> getAllProjects(){
		return projectServices.getAllProjects();
	}
	
	/**
	 * REST Based update Project Archive Status Endpoint
	 * Taken In the Project Record Id To Update
	 * @param id
	 * @return
	 */
	@PutMapping(value="projects/{id}")
	public ProjectResponseObj updateProjectStatus(@PathVariable("id") Long id) {
		return projectServices.updateProject(id);
	}

}
