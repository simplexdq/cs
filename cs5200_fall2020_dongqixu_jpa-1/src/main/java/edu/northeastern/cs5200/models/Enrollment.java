package edu.northeastern.cs5200.models;

import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.springframework.transaction.annotation.Transactional;


@Transactional
@Entity
public class Enrollment {
	@Id
	@GeneratedValue
	(strategy=GenerationType.IDENTITY)
	private int id;
	private Integer grade;
	private String feedback;
	@ManyToOne
	private Student student;
	@ManyToOne
	private Section section;
	
	public Enrollment() {
		
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getFeedback() {
		return feedback;
	}
	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
		if(!student.getEnrollment().contains(this)) {
			student.getEnrollment().add(this);
		}
	}

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
		if(!section.getEnrollment().contains(this)) {
			section.getEnrollment().add(this);
		}
	}
	
	
	

}
