package com.myclass.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "targets")
public class Target {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	private int course_id;
	@ManyToOne
	@JoinColumn(name = "course_id", insertable = false, updatable = false)
	private Courses courses_target;
	public Target() {}
	public Target(int id, String title, int course_id, Courses courses_target) {
		super();
		this.id = id;
		this.title = title;
		this.course_id = course_id;
		this.courses_target = courses_target;
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
	public int getCourse_id() {
		return course_id;
	}
	public void setCourse_id(int course_id) {
		this.course_id = course_id;
	}
	public Courses getCourses_target() {
		return courses_target;
	}
	public void setCourses_target(Courses courses_target) {
		this.courses_target = courses_target;
	}
}
