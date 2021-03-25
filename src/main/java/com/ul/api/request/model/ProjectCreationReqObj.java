package com.ul.api.request.model;

import com.ul.api.app.enums.Status;
/**
 * Class Intended To Accept Name and Status While Creating A Project
 * 
 * @author Sathyanand.Jebakumar
 *
 */
public class ProjectCreationReqObj {

	private String name;
	private Status status;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

}
