package io.javabrains.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.javabrains.springbootstarter.topic.Topic;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;

	@RequestMapping("/topics/{topicId}/courses")
	private List<Course> getAllCourses(@PathVariable("topicId") String topicId) {
		return courseService.getAllCourses(topicId);
	}

	@RequestMapping("/topics/{topicId}/courses/{id}")
	private Course getCourse(@PathVariable("id") String id) {
		return courseService.getCourse(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
	private void addCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.addCourse(course);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{id}")
	private void updateCourse(@RequestBody Course course, @PathVariable("topicId") String topicId) {
		course.setTopic(new Topic(topicId, "", ""));
		courseService.updateCourse(course);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/course/{id}")
	private void deleteCourse(@PathVariable("id") String id) {
		courseService.deleteCourse(id);
	}

}