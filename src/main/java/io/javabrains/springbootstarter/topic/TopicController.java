package io.javabrains.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {

	@Autowired
	private TopicService topicService;

	@RequestMapping("/topics")
	private List<Topic> getAllTopics() {
		return topicService.getAllTopics();
	}

	@RequestMapping("/topics/{id}")
	private Topic getTopic(@PathVariable("id") String id) {
		return topicService.getTopic(id);
	}

	@RequestMapping(method = RequestMethod.POST, value = "/topics")
	private void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}

	@RequestMapping(method = RequestMethod.PUT, value = "/topics/{id}")
	private void updateTopic(@RequestBody Topic topic) {
		topicService.updateTopic(topic);
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/topics/{id}")
	private void deleteTopic(@PathVariable("id") String id) {
		topicService.deleteTopic(id);
	}

}