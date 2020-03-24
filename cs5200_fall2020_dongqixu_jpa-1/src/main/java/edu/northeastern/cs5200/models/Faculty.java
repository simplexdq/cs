package edu.northeastern.cs5200.models;
import java.util.List;

import javax.persistence.*;

@Entity
public class Faculty extends Person{

	private String office;
	private Boolean tenured;
	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER)// to distinguish which foreign key
	private List<Course> authoredCourses;
	
	public Faculty() {
		super();
	}
	
	public Faculty(String username, String password, String firstName, String lastName, String office, Boolean tenured) {
			super(username, password, firstName, lastName);
			this.office = office;
			this.tenured = tenured;
		}
	
	public void authoredCourse(Course course) {
	     this.authoredCourses.add(course);
	     if(course.getAuthor() != this)
	        course.setAuthor(this);
	}
	
	public String getOffice() {
		return office;
	}
	public void setOffice(String office) {
		this.office = office;
	}
	public Boolean getTenured() {
		return tenured;
	}
	public void setTenured(Boolean tenured) {
		this.tenured = tenured;
	}
	
	public List<Course> getAuthoredCourses() {
		return authoredCourses;
	}
	public void setAuthoredCourses(List<Course> authoredCourses) {
		this.authoredCourses = authoredCourses;
	}
	//to be able to insert courses for instance and save them into the faculty
//		public void authoredCourse(Course course) {
//		     this.authoredCourses.add(course);
//		     if(course.getAuthor() != this)
//		        course.setAuthor(this);
//		}
	

}
