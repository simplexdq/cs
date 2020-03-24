package edu.northeastern.cs5200.models;
import java.util.List;

import javax.persistence.*;

@Entity
public class Student extends Person {

	private Integer gradYear;
	private Long scholarship;
	
	@OneToMany(mappedBy = "student")
	private List<Enrollment> enrollment;
	public void enrollment (Enrollment enrollments) {
		   this.enrollment.add(enrollments);
		   if(enrollments.getStudent() != this) {
			   enrollments.setStudent(this);
		   }
		}
	
	public Student() {
		super();
	}
	
	public Student(String username, String password, String firstName, String lastName, int gradYear, long scholarship) {
			super(username, password, firstName, lastName);
			this.gradYear = gradYear;
			this.scholarship = scholarship;
		}
	
	public Integer getGradYear() {
		return gradYear;
	}

	public void setGradYear(Integer gradYear) {
		this.gradYear = gradYear;
	}

	public Long getScholarship() {
		return scholarship;
	}
	public void setScholarship(Long scholarship) {
		this.scholarship = scholarship;
	}
	public List<Enrollment> getEnrollment() {
		return enrollment;
	}
	public void setEnrollment(List<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}
	
//	public void implementEnrollment(Enrollment enrollments) {
//		   this.enrollment.add(enrollments);
//		   if(enrollments.getStudent() != (this)) {
//			   enrollments.setStudent(this);
//		   }
//		}

}
