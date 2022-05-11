package com.springrest.springrest.services;

import java.util.List;

import com.springrest.springrest.entities.Course;

public interface CourseService {
	public List<Course> getCourses();
	public Course getCourse(long CourseId);
	public Course addCourse(Course course);
	public Course updateCourse(long courseId, Course course);
	public int deleteCourse(long courseId);
	
}