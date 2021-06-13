package com.example.sql.service;

import com.example.sql.entity.Topic;
import com.example.sql.repository.TopicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;


    public Topic saveTopic(Topic topic) {
        return topicRepository.save(topic);
    }

    public List<Topic> saveTopics(List<Topic> topics) {
        return topicRepository.saveAll(topics);
    }

    public List<Topic> getTopics() {
        return topicRepository.findAll();
    }

    public Topic getTopicsById(int id) {
        if (topicRepository.findById(id).isPresent()){
            return topicRepository.findById(id).orElse(null);
        }
        else {
            return new Topic(id,"This id does not exist!!!!", "N/A");
        }
    }

    public Topic getTopicsByName(String name) {
        return topicRepository.findByName(name);
    }

    public String deleteTopic(int id) {
        topicRepository.deleteById(id);
        return "Topic deleted!!";
    }

    public Topic updateTopic(Topic topic) {
        Topic existingTopic = topicRepository.findById(topic.getId()).orElse(null);
        existingTopic.setName(topic.getName());
        existingTopic.setDescription(topic.getDescription());
        return  topicRepository.save(existingTopic);
    }

}
