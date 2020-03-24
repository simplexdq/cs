package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.models.Section;

@Repository
public interface SectionRepository 
extends CrudRepository<Section, Integer>{
	//@Query("SELECT s FROM Section s WHERE s.course=:course")
	 //public Section findSectionByCourse (@Param("course")String course);
	@Query("SELECT s FROM Section s Where s.title=:title")
	public Section findSectionByTitle (@Param("title") String title);

}
