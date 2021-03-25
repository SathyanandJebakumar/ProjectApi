package com.ul.api.business.core.utility;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.ul.api.app.utility.AppUtility;
import com.ul.api.db.entities.ProjectEntity;
import com.ul.api.request.model.ProjectCreationReqObj;
import com.ul.api.response.model.ProjectResponseObj;

/**
 * Class Intended For Object Type Conversion
 * 
 * @author Sathyanand.Jebakumar
 *
 */
@Component
public class ObjectConverter {

	/**
	 * Converts Project Creation Request Type To Project Entity Type
	 * 
	 * @param projectReq
	 * @return
	 */
	public ProjectEntity toDBObjectType(ProjectCreationReqObj projectReq) {
		ProjectEntity projEntity = new ProjectEntity();

		projEntity.setName(projectReq.getName());
		projEntity.setStatus(projectReq.getStatus());
		projEntity.setArchived(false);
		projEntity.setCreationDate(new Date());

		return projEntity;

	}

	/**
	 * Converts A List Of Project Entity Objects To Project Response Type
	 * 
	 * @param projectDBObjs
	 * @return
	 */
	public List<ProjectResponseObj> toProjectResponseType(List<ProjectEntity> projectDBObjs) {
		List<ProjectResponseObj> response = new ArrayList<>();

		if (projectDBObjs != null) {
			response = projectDBObjs.parallelStream()
					.map(projectDBEntity -> new ProjectResponseObj(projectDBEntity.getId(), projectDBEntity.getName(),
							projectDBEntity.getStatus(),
							AppUtility.convertDateToLocalDate(projectDBEntity.getCreationDate()),
							projectDBEntity.getArchived()))
					.collect(Collectors.toList());
		}

		return response;

	}

}
