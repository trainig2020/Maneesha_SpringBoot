package com.spring.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllCourses(@PathVariable String id){
		return courseService.getAllCourses(id);
	}
	
	@RequestMapping("/topic/{topicid}/courses/{courseid}")
	public Course getCourse(@PathVariable String courseid) {
		return courseService.getCourse(courseid);
	}
	
	@RequestMapping(value = "/add/{topicid}/courses" , method = RequestMethod.POST)
	public void addCourse(@RequestBody Course course, @PathVariable String topicid) {
		course.setTopic(new Topic(topicid, "", ""));
		courseService.addCourse(course);
	}
	
	
	@RequestMapping(value = "/update/{topicid}/courses/{courseid}" , method = RequestMethod.PUT)
	public void updateCourse(@RequestBody Course course,@PathVariable String topicid, @PathVariable String courseid) {
		course.setTopic(new Topic(topicid, "", ""));
		courseService.updateCourse(course);
	}
	
	@RequestMapping(value = "/delete/{topicid}/courses/{courseid}" , method = RequestMethod.DELETE)
	public void deletetopic(@PathVariable String courseid) {
		courseService.deleteCourse(courseid);
	}

}
