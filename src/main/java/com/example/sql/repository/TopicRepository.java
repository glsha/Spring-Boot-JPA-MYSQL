package com.example.sql.repository;

import com.example.sql.entity.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TopicRepository extends JpaRepository<Topic, Integer> {

    Topic findByName(String name);
}
