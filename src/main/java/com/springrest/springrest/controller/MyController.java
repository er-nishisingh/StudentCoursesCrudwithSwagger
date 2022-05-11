package com.springrest.springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springrest.springrest.entities.Course;
import com.springrest.springrest.services.CourseService;

import io.swagger.annotations.ApiOperation;

@RestController
public class MyController {
	
	
	@Autowired
	private CourseService courseService; 
	@GetMapping("/home") 
	public String home() {
		return "This is home page";
	}
	// get the course details 
	@GetMapping("/courses")
	@ApiOperation(value = "This API is fetching all courses")
	public List<Course> getCourses(){
		return this.courseService.getCourses();
	}
	@GetMapping("/courses/{courseId}")
	@ApiOperation(value = "This API  is fetching course by courseID")
	public Course getCourse(@PathVariable String courseId) {
		return this.courseService.getCourse(Long.parseLong(courseId));
	}
	
	@PostMapping(path = "/courses", consumes = "application/json")
	@ApiOperation(value = "This API  is adding new courses")
	public Course addCourse(@RequestBody Course course) {
		return this.courseService.addCourse(course);
	}
	
	
	@PutMapping("/courses/{courseId}")
	@ApiOperation(value = "This API is updating the courses with course id")
	public Course updateCourse(@PathVariable String courseId, @RequestBody Course course) {
		return this.courseService.updateCourse(Long.parseLong(courseId), course);
	}
	@DeleteMapping( "/courses/{courseId}" )
	@ApiOperation(value = "This API is deleting  the courses with course id")
	public ResponseEntity<HttpStatus> deleteCourse(@PathVariable String courseId) {
		if (this.courseService.deleteCourse(Long.parseLong(courseId)) == 0) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(HttpStatus.ACCEPTED);
	}
}


