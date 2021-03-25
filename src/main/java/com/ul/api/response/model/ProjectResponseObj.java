package com.ul.api.response.model;

import java.time.LocalDateTime;

import com.ul.api.app.enums.Status;
/**
 * Class Intended To Serve The Project Response
 * Maintains the Response Structure
 * @author Sathyanand.Jebakumar
 *
 */
public class ProjectResponseObj {

	private Long id;
	private String name;
	private Status status;
	private LocalDateTime dateCreated;
	Boolean archived;
	
	public ProjectResponseObj(){
		
	}
	
	public ProjectResponseObj(Long id, String name, Status status, LocalDateTime time, Boolean isArchived) {
		this.id = id;
		this.name = name;
		this.status = status;
		this.dateCreated = time;
		this.archived = isArchived;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public LocalDateTime getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(LocalDateTime dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Boolean getArchived() {
		return archived;
	}

	public void setArchived(Boolean archived) {
		this.archived = archived;
	}

}
