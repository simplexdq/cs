package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.models.Enrollment;

@Repository
public interface EnrollmentRepository 
extends CrudRepository<Enrollment, Integer>{
	//@Query("SELECT e FROM Enrollment e WHERE e.student=:student")
	 //public List<Enrollment> findEnrollmentByStudent (@Param("student")Student student);
	

}
