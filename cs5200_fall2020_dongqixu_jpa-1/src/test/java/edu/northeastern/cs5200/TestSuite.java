package edu.northeastern.cs5200;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200.daos.UniversityDao;
import edu.northeastern.cs5200.models.*;


@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestSuite {
	
	@Autowired
	UniversityDao universityDao;	
	
	@Before
	@Test
	public void A_truncateDatabase() {
		universityDao.truncateDatabase();
	}
	
	@Test
	public void B_createFaculty() {
		Faculty alan = new Faculty("alan", "password", "Alan", "Turin", "123A", true);
		universityDao.createFaculty(alan);
		Faculty ada = new Faculty("ada", "password", "Ada", "Lovelace", "123B", true);
		universityDao.createFaculty(ada);
 
	}
	
	@Test
	public void C_createStudent() {
		Student Alice = new Student("alice", "password", "Alice", "Wonderland", 2020, 12000);
		universityDao.createStudent(Alice);
		Student Bob = new Student("bob", "password", "Bob", "Hope", 2021, 23000);
		universityDao.createStudent(Bob);
		Student Charlie = new Student("charlie", "password", "Charlie", "Brown", 2019, 21000);
		universityDao.createStudent(Charlie);
		Student Dan = new Student("dan", "password", "Dan", "Craig", 2019, 0);
		universityDao.createStudent(Dan);
		Student Edward = new Student("edward", "password", "Edward", "Scissorhands", 2022, 11000);
		universityDao.createStudent(Edward);
		Student Frank = new Student("frank", "password", "Frank", "Herbert", 2018, 0);
		universityDao.createStudent(Frank);
		Student Gregory = new Student("gregory", "password", "Gregory", "Peck", 2023, 10000);
		universityDao.createStudent(Gregory);

	}
	

	@Test
	public void D_createCourse() {
		Faculty Alan = universityDao.findFacultyByUsername("alan");
		Faculty Ada = universityDao.findFacultyByUsername("ada");
			
		Course CS1234 = new Course("CS1234");
		universityDao.createCourse(CS1234);
		universityDao.setAuthorForCourse(Alan, CS1234);
		
		Course CS2345 = new Course("CS2345");
		universityDao.createCourse(CS2345);
		universityDao.setAuthorForCourse(Alan, CS2345);
		
		Course CS3456 = new Course("CS3456");
		universityDao.createCourse(CS3456);
		universityDao.setAuthorForCourse(Ada, CS3456);
		
		Course CS4567 = new Course("CS4567");
		universityDao.createCourse(CS4567);
		universityDao.setAuthorForCourse(Ada, CS4567);
		
	}
	

	@Test
	public void E_createSection() {
		Course CS1234 = universityDao.findCourseByLabel("CS1234");
		Course CS2345 = universityDao.findCourseByLabel("CS2345");
		Course CS3456 = universityDao.findCourseByLabel("CS3456");
		
		Section SEC4321 = new Section("SEC4321", 50);
		universityDao.createSection(SEC4321);
		universityDao.addSectionToCourse(SEC4321, CS1234);
		
		Section SEC5432 = new Section("SEC5432", 50);
		universityDao.createSection(SEC5432);
		universityDao.addSectionToCourse(SEC5432, CS1234);
		
		Section SEC6543 = new Section("SEC6543", 50);
		universityDao.createSection(SEC6543);
		universityDao.addSectionToCourse(SEC6543, CS2345);
		
		Section SEC7654 = new Section("SEC7654", 50);
		universityDao.createSection(SEC7654);
		universityDao.addSectionToCourse(SEC7654, CS3456);
	}
	

	@Test
	public void F_enrollStudentInSection() {
		Student Alice = universityDao.findStudentByUsername("alice");
		Student Bob = universityDao.findStudentByUsername("bob");
		Student Charlie = universityDao.findStudentByUsername("charlie");
		
		Section SEC4321 = universityDao.findSectionByTitle("SEC4321");
		Section SEC5432 = universityDao.findSectionByTitle("SEC5432");
		Section SEC6543 = universityDao.findSectionByTitle("SEC6543");
	

		universityDao.enrollStudentInSection(Alice, SEC4321);
		universityDao.enrollStudentInSection(Alice, SEC5432);
		universityDao.enrollStudentInSection(Bob, SEC5432);
		universityDao.enrollStudentInSection(Charlie, SEC6543);
	}

}
