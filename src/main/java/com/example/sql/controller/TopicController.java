package com.example.sql.controller;

import com.example.sql.entity.Topic;
import com.example.sql.service.TopicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicController
{
    @Autowired
    private TopicService topicService;


    @PostMapping("/topics")
    @CrossOrigin(origins = "http://localhost:4200")
    public Topic addTopic(@RequestBody Topic topic) {
        return topicService.saveTopic(topic);
    }

    @PostMapping("/topicsMultiple")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Topic> addTopics(@RequestBody List<Topic> topics) {
        return topicService.saveTopics(topics);
    }

    @GetMapping("/topics")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<Topic> findTopics() {
        return topicService.getTopics();
    }

    @GetMapping("/topicById/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Topic findProductById(@PathVariable int id) {
        return topicService.getTopicsById(id);
    }

    @GetMapping("/topic/{name}")
    @CrossOrigin(origins = "http://localhost:4200")
    public Topic findProductByName(@PathVariable String name) {
        return topicService.getTopicsByName(name);
    }

    @PutMapping("/topics")
    @CrossOrigin(origins = "http://localhost:4200")
    public Topic updateProduct(@RequestBody Topic product) {
        return topicService.updateTopic(product);
    }

    @DeleteMapping("/topics/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public String deleteProduct(@PathVariable int id) {
        return topicService.deleteTopic(id);
    }
}

