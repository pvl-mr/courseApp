package com.maripavlova.courseApp.DataApacheDerbyData.controllers;

import com.maripavlova.courseApp.DataApacheDerbyData.resources.Topic;
import com.maripavlova.courseApp.DataApacheDerbyData.services.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/topics")
    public List<Topic> getAllTopics() {
        return topicService.getTopics();
    }

    @GetMapping("/topics/{id}")
    public Topic getTopic(@PathVariable String id) {
        return topicService.getTopic(id);
    }

    @PostMapping("/topics")
    public boolean addTopic(@RequestBody Topic topic) {
        return topicService.addTopic(topic);
    }

    @PutMapping("/topics/{id}")
    public boolean updateTopic(@PathVariable String id, @RequestBody Topic topic) {
        return topicService.updateTopic(id, topic);
    }

    @DeleteMapping("/topics/{id}")
    public boolean deleteTopic(@PathVariable String id) {
        return topicService.deleteTopic(id);
    }
}
