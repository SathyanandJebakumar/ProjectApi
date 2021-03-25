package com.ul.api.db.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ul.api.db.entities.ProjectEntity;
/**
 * Spring Repository Class 
 * For CRUD Operations
 * @author Sathyanand.Jebakumar
 *
 */
@Repository
public interface ProjectRepository extends CrudRepository<ProjectEntity, Long>{

}
