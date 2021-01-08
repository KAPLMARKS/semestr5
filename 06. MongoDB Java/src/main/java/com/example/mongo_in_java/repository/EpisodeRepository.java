package com.example.mongo_in_java.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface EpisodeRepository extends MongoRepository<Episode, String> {
    Episode findByName(String name);
}