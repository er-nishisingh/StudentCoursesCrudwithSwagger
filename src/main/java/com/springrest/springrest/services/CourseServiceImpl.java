package com.springrest.springrest.services;
import java.util.ArrayList;
import java.util.List;
import com.springrest.springrest.entities.Course;

import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {
	List<Course> list;
	public CourseServiceImpl() {
		// default constructor
		list=new ArrayList<>();
		list.add(new Course(145,"Introduction to Java", "Basic Core Java Course"));
		list.add(new Course(1232,"Spring Boot Course", "Rest API Development using Spring boot"));
	}

	@Override
	public List<Course> getCourses() {
		return list;
	}

	@Override
	public Course getCourse(long CourseId) {
		Course c=null;
		for(Course course:list){
			if(course.getId()==CourseId){
				c=course;
				break;
			}	
		}
		return c;
	}

	@Override
	public Course addCourse(Course course){
		list.add(course);
		return course;
	}
	
	@Override
	public Course updateCourse(long courseId, Course inp){
		Course out = null;
		for(Course course:list) {
			if(course.getId()==courseId) {
				course.setTitle(inp.getTitle());
				course.setDescription(inp.getDescription());
				out = course;
			}
		}
		return out;
	}
	
	@Override
	public int deleteCourse(long courseId) {
		for(Course course:list){
			if(course.getId()==courseId){
				list.remove(course);
				return 1;
			}
		}
		return 0;
	}
}