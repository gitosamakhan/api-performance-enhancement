package com.performance.apiperformanceenhancement.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.performance.apiperformanceenhancement.dao.StudentDao;
import com.performance.apiperformanceenhancement.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaService {

    private static final String TOPIC = "your-topic";

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private StudentDao studentDao;

    public void sendMessage(String message) {
        System.out.println("Sending message to kafka");
        kafkaTemplate.send(TOPIC, message);
    }

    @KafkaListener(topics = "your-topic", groupId = "your-consumer-group-id")
    public void listen(String message) {
        System.out.println("Received Message: " + message);
        try {
            Student student = objectMapper.readValue(message, Student.class);
            studentDao.save(student);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }
}
