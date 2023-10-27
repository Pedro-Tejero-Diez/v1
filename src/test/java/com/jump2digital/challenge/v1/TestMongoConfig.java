package com.jump2digital.challenge.v1;

import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@TestConfiguration
@EnableMongoRepositories(basePackages = "com.jump2digital.challenge.v1.repository")
public class TestMongoConfig {
    @Bean
    public MongoTemplate mongoTemplate() {
        // Set up a test MongoTemplate or use an embedded MongoDB for testing
        // Configure the MongoDB connection settings here.
        return new MongoTemplate(null /* provide your Mongo settings here */);
    }
}

