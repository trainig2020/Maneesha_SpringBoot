package com.spring.springbootstarter.topic;

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
	public List<Topic> getAllTopics(){
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable String id) {
		return topicService.getTopic(id);
	}
	
	@RequestMapping(value = "/add" , method = RequestMethod.POST)
	public void addtopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	
	@RequestMapping(value = "/update/{id}" , method = RequestMethod.PUT)
	public void updatetopic(@RequestBody Topic topic,@PathVariable String id) {
		topicService.updateTopic(id,topic);
	}
	
	@RequestMapping(value = "/delete/{id}" , method = RequestMethod.DELETE)
	public void deletetopic(@PathVariable String id) {
		topicService.deleteTopic(id);
	}

}
