package com.example.mongo_in_java.template;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MongoTConfig.class);
        MongoTemplate template = context.getBean(MongoTemplate.class);
        // Save
        Episode episode = Episode.builder()
                .name("Первая серия")
                .build();
        template.save(episode, "episodes");

        Query query = new Query();
        query.addCriteria(Criteria.where("name").is("Первая серия"));
        Update update = new Update();
        update.set("name", "Первая серия еще не вышла");
        template.updateFirst(query, update, Episode.class);

        template.findAndRemove(query, Episode.class);
    }
}