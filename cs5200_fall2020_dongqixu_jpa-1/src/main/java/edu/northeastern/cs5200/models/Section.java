package edu.northeastern.cs5200.models;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.springframework.transaction.annotation.Transactional;
@Transactional

@Entity
public class Section extends Course{
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private int seats;
	private String title;
	@ManyToOne()
	private Course course;
	@OneToMany(mappedBy="section")
	private List<Enrollment> enrollment;
	public void enrollment(Enrollment enrollments) {
		   this.enrollment.add(enrollments);
		   if(enrollments.getSection() != this) {
			   enrollments.setSection(this);
		   }
		}
	
	
	public Section() {
		
	}
	
	public Section(String title, int seats) {
		this.title = title;
		this.seats = seats;
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getSeats() {
		return seats;
	}


	public void setSeats(int seats) {
		this.seats = seats;
	}


	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
		if(!course.getSection().contains(this)) {
			course.getSection().add(this);
		}
	}

	public List<Enrollment> getEnrollment() {
		return enrollment;
	}

	public void setEnrollment(List<Enrollment> enrollment) {
		this.enrollment = enrollment;
	}
//	public void enrollment(Enrollment enrollments) {
//		   this.enrollment.add(enrollments);
//		   if(enrollments.getSection() != this) {
//			   enrollments.setSection(this);
//		   }
//		}
}
