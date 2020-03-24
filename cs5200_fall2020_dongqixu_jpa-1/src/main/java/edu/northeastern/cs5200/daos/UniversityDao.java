package edu.northeastern.cs5200.daos;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import edu.northeastern.cs5200.models.*;
import edu.northeastern.cs5200.repositories.*;

@Controller
public class UniversityDao {
	@Autowired
	PersonRepository personRepository;
	@Autowired
	FacultyRepository facultyRepository;
	@Autowired
	StudentRepository studentRepository;
	@Autowired
	CourseRepository courseRepository;
	@Autowired
	SectionRepository sectionRepository;
	@Autowired
	EnrollmentRepository enrollmentRepository;
	
	public void truncateDatabase() {
		enrollmentRepository.deleteAll();
		sectionRepository.deleteAll();
		courseRepository.deleteAll();
		facultyRepository.deleteAll();
		studentRepository.deleteAll();
		personRepository.deleteAll();
	}
	
	public Faculty createFaculty(Faculty faculty) {
		return facultyRepository.save(faculty);
	}
	
	public Student createStudent(Student student) {
		return studentRepository.save(student);
	}
	public Course createCourse(Course course) {
		return courseRepository.save(course);
	}
	
	public Section createSection(Section section) {
		return sectionRepository.save(section);
	}
	
	public Course addSectionToCourse(Section section, Course course) {
		course.section(section);
		sectionRepository.save(section);
		return courseRepository.save(course);
	}
	public Course setAuthorForCourse(Faculty faculty, Course course) {
		course.setAuthor(faculty);
		facultyRepository.save(faculty);
		return courseRepository.save(course);
	}
	
	public Boolean enrollStudentInSection(Student student, Section section) {
		if(section.getSeats() == 0) return false;
		
			Enrollment enrollment = new Enrollment();
			enrollment.setSection(section);
			enrollment.setStudent(student);
			enrollmentRepository.save(enrollment);
			section.setSeats(section.getSeats() - 1);
			sectionRepository.save(section);
			return true;
		
	}
	
	public List<Person> findAllUsers() {
		 List<Person> person = (List<Person>) personRepository.findAll();
		 return person;
	}
	
	public List<Faculty> findAllFaculty() {
		List<Faculty> faculty = (List<Faculty>) facultyRepository.findAll();
		return faculty;
	}
	
	public List<Student> findAllStudents() {
		List<Student> student = (List<Student>) studentRepository.findAll();
		return student;
	}
	
	public List<Course> findAllCourses() {
		List<Course> course = (List<Course>) courseRepository.findAll();
		return course;
	}
	
	public List<Section> findAllSections() {
		List<Section> section = (List<Section>) sectionRepository.findAll();
		return section;
	}
	public List<Course> findCoursesForAuthor(Faculty faculty) {
		List<Course> courses = faculty.getAuthoredCourses();
		return courses;
	}
	
	public Faculty findFacultyByUsername(String username) {
		Faculty faculty = facultyRepository.findFacultyByUsername(username);
		return faculty;
	}
	
	public Course findCourseByLabel(String label) {
		Course course = courseRepository.findCourseByLabel(label);
		return course;
	}
	
	public Section findSectionByTitle(String title) {
		Section section = sectionRepository.findSectionByTitle(title);
		return section;
	}
	
	public Student findStudentByUsername(String username) {
		Student student = studentRepository.findStudentByUsername(username);
		return student;
	}
	
	public List<Section> findSectionForCourse(Course course) {
		List<Section> section = course.getSection();
		return section;
	}
	
	public List<Student> findStudentsInSection(Section section) {
		List<Student> student = new ArrayList<Student> ();
		List<Enrollment> enrollments = section.getEnrollment();
		for(Enrollment enrollment : enrollments) {
			student.add(enrollment.getStudent());
		}
		return student;
	}
	
	public List<Section> findSectionsForStudent(Student student) {
		List<Section> section = new ArrayList<Section> ();
		List<Enrollment> enrollments = student.getEnrollment();
		for(Enrollment enrollment : enrollments) {
			section.add(enrollment.getSection());
		}
		return section;
	}

}
