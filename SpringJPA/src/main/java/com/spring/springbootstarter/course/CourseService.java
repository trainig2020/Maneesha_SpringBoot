package com.spring.springbootstarter.course;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	
	
	public List<Course> getAllCourses(String topicid){
		
		List<Course> courses = new ArrayList<Course>();
		courseRepository.findByTopicId(topicid).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(String id) {
		return courseRepository.findById(id).get();
	}

	public void addCourse(Course course) {
		courseRepository.save(course);
		
	}

	public void updateCourse( Course topic) {
		courseRepository.save(topic);
		
	}

	public void deleteCourse(String id) {
		courseRepository.deleteById(id);
		
	}

}
