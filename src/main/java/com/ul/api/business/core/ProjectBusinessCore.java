package com.ul.api.business.core;

import java.util.List;

import com.ul.api.request.model.ProjectCreationReqObj;
import com.ul.api.response.model.ProjectResponseObj;

public interface ProjectBusinessCore {
	
	public ProjectResponseObj saveProject(ProjectCreationReqObj projectReq);

	public List<ProjectResponseObj> getAllProjects();

	public ProjectResponseObj updateProjectArchiveToCompleted(Long projectId);

}
