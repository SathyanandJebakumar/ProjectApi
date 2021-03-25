package com.ul.api.services;

import java.util.List;

import com.ul.api.request.model.ProjectCreationReqObj;
import com.ul.api.response.model.ProjectResponseObj;

public interface ProjectServices {

	public ProjectResponseObj saveProject(ProjectCreationReqObj projectReq);

	public List<ProjectResponseObj> getAllProjects();

	public ProjectResponseObj updateProject(Long projectId);

}
