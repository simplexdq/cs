package edu.northeastern.cs5200.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.models.Faculty;

@Repository
public interface FacultyRepository 
extends CrudRepository<Faculty, Integer> {
	@Query("SELECT p FROM Person p WHERE p.username=:username ")
	public Faculty findFacultyByUsername (@Param("username") String username); 
	 //@Query("SELECT f FROM Faculty f WHERE f.username =:username AND f.password =:password")
	 //public Faculty findFacultyByCredentials (@Param("username")String username, @Param("password") String password);
	

}
