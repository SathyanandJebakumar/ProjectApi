package com.ul.api.business.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ul.api.business.core.utility.ObjectConverter;
import com.ul.api.db.entities.ProjectEntity;
import com.ul.api.db.repository.ProjectRepository;
import com.ul.api.request.model.ProjectCreationReqObj;
import com.ul.api.response.model.ProjectResponseObj;

/**
 * Class Intended For Core Business Logic
 * 
 * @author Sathyanand.Jebakumar
 *
 */

@Service
public class ProjectBusinessCoreImpl implements ProjectBusinessCore {

	@Autowired
	ProjectRepository projRepository;

	@Autowired
	ObjectConverter objConverter;

	/**
	 * Method Intended To Save The Project Creation Request To DB
	 * Adds An Entry To the Project Table in the DB
	 * For Each Request One Record is Inserted
	 */
	public ProjectResponseObj saveProject(ProjectCreationReqObj projectReq) {

		ProjectEntity projEntityObj = objConverter.toDBObjectType(projectReq);
		ProjectEntity savedObj = projRepository.save(projEntityObj);

		List<ProjectResponseObj> projectResponseList = objConverter.toProjectResponseType(Arrays.asList(savedObj));

		if (projectResponseList != null && !projectResponseList.isEmpty())
			return projectResponseList.get(0);
		else
			return new ProjectResponseObj();
	}

	/**
	 * Method Retrieves All the Project Records In the DB
	 * Return The Records As a Form Of List
	 */
	public List<ProjectResponseObj> getAllProjects() {
		List<ProjectResponseObj> response = new ArrayList<>();

		List<ProjectEntity> allProjectsInDB = new ArrayList<>();
		projRepository.findAll().forEach(allProjectsInDB::add);

		response = objConverter.toProjectResponseType(allProjectsInDB);

		return response;
	}
	/**
	 * Method Intended To Update the Archive status of the Project Record In DB
	 * Upon Calling With the Correct Project Id the Record Would Be Updated
	 */
	public ProjectResponseObj updateProjectArchiveToCompleted(Long projectId) {
		Optional<ProjectEntity> entityObj = projRepository.findById(projectId);
		ProjectEntity updatedObj = null;
		if (entityObj.isPresent()) {
			ProjectEntity proEntityToUpdate = entityObj.get();
			proEntityToUpdate.setArchived(true);
			updatedObj = projRepository.save(proEntityToUpdate);
		}

		List<ProjectResponseObj> projectResponseList = objConverter.toProjectResponseType(Arrays.asList(updatedObj));

		if (projectResponseList != null && !projectResponseList.isEmpty())
			return projectResponseList.get(0);
		else
			return new ProjectResponseObj();
	}

}
