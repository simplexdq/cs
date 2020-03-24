package edu.northeastern.cs5200;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import edu.northeastern.cs5200.daos.UniversityDao;
import edu.northeastern.cs5200.models.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidateData {
	
	@Autowired
	UniversityDao universityDao;
	
	@Test
	public void validatesUsers() {
		List<Person> persons = universityDao.findAllUsers();
		Assert.assertEquals("validate users", 9, persons.size());
	}
	
	@Test
	public void validatesFaculty() {
		List<Faculty> faculty = universityDao.findAllFaculty();
		Assert.assertEquals("validate faculties", 2, faculty.size());
	}
	
	@Test
	public void validatesStudents() {
		List<Student> students = universityDao.findAllStudents();
		Assert.assertEquals("validate students", 7, students.size());

	}
	
	@Test
	public void validatesCourses() {
		List<Course> courses = universityDao.findAllCourses();
		Assert.assertEquals("validate courses", 4, courses.size());

	}
	
	@Test
	public void validatesSections() {
		List<Section> sections = universityDao.findAllSections();
		Assert.assertEquals("validate sections", 4, sections.size());

	}
	
	@Test
	public void validatesCourseAuthorship() {
		Faculty alan = universityDao.findFacultyByUsername("alan");
		Faculty ada = universityDao.findFacultyByUsername("ada");
		
		List<Course> coursesForAlan = universityDao.findCoursesForAuthor(alan);
		List<Course> coursesForAda = universityDao.findCoursesForAuthor(ada);
		
		Assert.assertEquals("validate courses for alan", 2, coursesForAlan.size());
		Assert.assertEquals("validate courses for ada", 2, coursesForAda.size());
		
	}
	
	@Test
	public void validatesSectionPerCourse() {
		Course cs1234 = universityDao.findCourseByLabel("CS1234");
		Course cs2345 = universityDao.findCourseByLabel("CS2345");
		Course cs3456 = universityDao.findCourseByLabel("CS3456");
		Course cs4567 = universityDao.findCourseByLabel("CS4567");
		
		List<Section> sec1234 = universityDao.findSectionForCourse(cs1234);
		List<Section> sec2345 = universityDao.findSectionForCourse(cs2345);
		List<Section> sec3456 = universityDao.findSectionForCourse(cs3456);
		List<Section> sec4567 = universityDao.findSectionForCourse(cs4567);
		
		Assert.assertEquals("validate section for cs1234", 2, sec1234.size());
		Assert.assertEquals("validate section for cs2345", 1, sec2345.size());
		Assert.assertEquals("validate section for cs3456", 1, sec3456.size());
		Assert.assertEquals("validate section for cs4567", 0, sec4567.size());
		
	}
	
	@Test
	public void validatesSectionEnrollments() {
		Section sec4321 = universityDao.findSectionByTitle("SEC4321");
		Section sec5432 = universityDao.findSectionByTitle("SEC5432");
		Section sec6543 = universityDao.findSectionByTitle("SEC6543");
		Section sec7654 = universityDao.findSectionByTitle("SEC7654");
		List<Student> stu4321 = universityDao.findStudentsInSection(sec4321);
		List<Student> stu5432 = universityDao.findStudentsInSection(sec5432);
		List<Student> stu6543 = universityDao.findStudentsInSection(sec6543);
		List<Student> stu7654 = universityDao.findStudentsInSection(sec7654);
		Assert.assertEquals("ValidateSectionSEC4321",1, stu4321.size());
		Assert.assertEquals("ValidateSectionSEC5432",2, stu5432.size());
		Assert.assertEquals("ValidateSectionSEC6543",1, stu6543.size());
		Assert.assertEquals("ValidateSectionSEC7654",0, stu7654.size());	
	}
	@Test
	public void validatesStudentEnrollments() {
		Student alice = universityDao.findStudentByUsername("alice");
		Student bob = universityDao.findStudentByUsername("bob");
		Student charlie = universityDao.findStudentByUsername("charlie");
		Student dan = universityDao.findStudentByUsername("dan");
		Student edward = universityDao.findStudentByUsername("edward");
		Student frank = universityDao.findStudentByUsername("frank");
		Student gregory = universityDao.findStudentByUsername("gregory");
		
		List<Section> s_alice = universityDao.findSectionsForStudent(alice);
		List<Section> s_bob = universityDao.findSectionsForStudent(bob);
		List<Section> s_charlie = universityDao.findSectionsForStudent(charlie);
		List<Section> s_dan = universityDao.findSectionsForStudent(dan);
		List<Section> s_edward = universityDao.findSectionsForStudent(edward);
		List<Section> s_frank = universityDao.findSectionsForStudent(frank);
		List<Section> s_gregory = universityDao.findSectionsForStudent(gregory);
		
		Assert.assertEquals("ValidateStudentAlice",2, s_alice.size());
		Assert.assertEquals("ValidateStudentBob",1, s_bob.size());
		Assert.assertEquals("ValidateStudentCharlie",1, s_charlie.size());
		Assert.assertEquals("ValidateStudentDan",0, s_dan.size());
		Assert.assertEquals("ValidateStudentEdward",0, s_edward.size());
		Assert.assertEquals("ValidateStudentFrank",0, s_frank.size());
		Assert.assertEquals("ValidateStudentGregory",0, s_gregory.size());
	}
	@Test
	public void validatesSectonSeats() {
		Section sec4321 = universityDao.findSectionByTitle("SEC4321");
		Section sec5432 = universityDao.findSectionByTitle("SEC5432");
		Section sec6543 = universityDao.findSectionByTitle("SEC6543");
		Section sec7654 = universityDao.findSectionByTitle("SEC7654");

		Assert.assertEquals("ValidateSEC5432", 49, (int)sec4321.getSeats());
		Assert.assertEquals("ValidateSEC5432",48, (int)sec5432.getSeats());
		Assert.assertEquals("ValidateSEC6543",49, (int)sec6543.getSeats());
		Assert.assertEquals("ValidateSEC7654",50, (int)sec7654.getSeats());			
	}
	
	

}
