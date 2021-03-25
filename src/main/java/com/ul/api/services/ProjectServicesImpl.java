package com.ul.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ul.api.business.core.ProjectBusinessCore;
import com.ul.api.request.model.ProjectCreationReqObj;
import com.ul.api.response.model.ProjectResponseObj;
/**
 * Application Service Layer
 * Please Do Not Write Any Logic Here
 * @author Sathyanand.Jebakumar
 *
 */
@Service
public class ProjectServicesImpl implements ProjectServices {

	@Autowired
	ProjectBusinessCore projectBusinessCore;

	public ProjectResponseObj saveProject(ProjectCreationReqObj projectReq) {
		return projectBusinessCore.saveProject(projectReq);
	}

	public List<ProjectResponseObj> getAllProjects() {
		return projectBusinessCore.getAllProjects();
	}

	public ProjectResponseObj updateProject(Long projectId) {
		return projectBusinessCore.updateProjectArchiveToCompleted(projectId);
	}

}
