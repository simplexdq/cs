package edu.northeastern.cs5200.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.northeastern.cs5200.models.Person;

@Repository
public interface PersonRepository 
extends CrudRepository<Person, Integer>{
	 //@Query("SELECT p FROM Person p WHERE p.username=:username")
	 //public Person findPersonByUsername (@Param("username")String username);
	 
	 //@Query("SELECT p FROM Person p WHERE p.username =:username AND p.password =:password")
	 //public Person findPersonByCredentials (@Param("username")String username, @Param("password") String password);
		
}
