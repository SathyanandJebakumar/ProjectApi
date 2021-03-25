package com.ul.api.db.repository.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.ul.api.app.enums.Status;
import com.ul.api.db.entities.ProjectEntity;
import com.ul.api.db.repository.ProjectRepository;

/**
 * Repository Test Cases
 * 
 * @author Sathyanand.Jebakumar
 *
 */
@RunWith(SpringRunner.class)
@DataJpaTest
public class ProjectRespositoryTest {

	@Autowired
	private ProjectRepository repository;

	/**
	 * Test Case To Add A Project Record To DB Fetch the Values And Test It
	 */
	@Test
	public void addProjectRecord() {
		ProjectEntity dbProject = new ProjectEntity();
		dbProject.setArchived(false);
		dbProject.setCreationDate(new Date());
		dbProject.setName("Test 123");
		dbProject.setStatus(Status.IN_PROGRESS);
		ProjectEntity savedProject = repository.save(dbProject);

		Long savedProjectId = savedProject.getId();

		ProjectEntity projectObjInDB = repository.findById(savedProjectId).get();

		assertEquals(projectObjInDB.getName(), "Test 123");
		assertNotEquals(projectObjInDB.getName(), "Test 122");
	}

	/**
	 * Test Case To Update A Project Record In the Repository
	 * 
	 */
	@Test
	public void updateProjectRecord() {

		ProjectEntity dbProjectObj = new ProjectEntity();
		dbProjectObj.setId(1L);
		dbProjectObj.setArchived(true);
		dbProjectObj.setCreationDate(new Date());
		dbProjectObj.setName("Test 123");
		dbProjectObj.setStatus(Status.FINISHED);
		ProjectEntity savedProject = repository.save(dbProjectObj);

		Long savedProjectId = savedProject.getId();

		ProjectEntity projectObjInDB = repository.findById(savedProjectId).get();

		assertEquals(projectObjInDB.getStatus(), Status.FINISHED);
		assertNotEquals(projectObjInDB.getStatus(), Status.IN_PROGRESS);

	}

}
