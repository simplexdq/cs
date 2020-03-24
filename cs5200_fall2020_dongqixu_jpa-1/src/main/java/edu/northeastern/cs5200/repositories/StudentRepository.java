package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.models.Student;

@Repository
public interface StudentRepository 
extends CrudRepository<Student, Integer>{
	@Query("SELECT s FROM Student s Where s.username=:username")
	public Student findStudentByUsername (@Param("username") String username);
//	 @Query("SELECT s FROM Student s WHERE s.username =:username AND s.password =:password")
//	 public Student findStudentByCredentials (@Param("username")String username, @Param("password") String password);
	

}
