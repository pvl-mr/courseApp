package com.maripavlova.courseApp.ListData.services;

import com.maripavlova.courseApp.ListData.resources.Topic;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {

    private List<Topic> topics = new ArrayList<>(Arrays.asList(
            new Topic("1", "topic name 1", "topic description 1"),
            new Topic("2", "topic name 2", "topic description 2"),
            new Topic("3", "topic name 3", "topic description 3")
    ));

    public List<Topic> getTopics() {
        return topics;
    }

    public Topic getTopic(String id) {
        return topics.stream().filter(topic -> topic.getId().equals(id)).findFirst().get();
    }

    public boolean addTopic(Topic topic) {
        return topics.add(topic);
    }

    public boolean updateTopic(String id, Topic topic) {
        for (int i = 0; i < topics.size(); i++) {
            if (topics.get(i).getId().equals(id)) {
                topics.set(i, topic);
                return true;
            }
        }
        return false;
    }

    public boolean deleteTopic(String id) {
        return topics.removeIf(topic -> topic.getId().equals(id));
    }
}
