package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.models.Course;

@Repository
public interface CourseRepository 
extends CrudRepository<Course, Integer> {
	@Query("SELECT c FROM Course c Where c.label=:label")
	public Course findCourseByLabel
	(@Param("label") String label);
//	@Query("SELECT c FROM Course c WHERE c.author=:author")
//	 public Course findCourseByAuthor (@Param("author")String author);
	
}


// SELECT c FROM Course c Where c.title=:title