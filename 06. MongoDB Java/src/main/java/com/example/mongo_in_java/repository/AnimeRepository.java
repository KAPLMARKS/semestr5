package com.example.mongo_in_java.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface AnimeRepository extends MongoRepository<Anime, String> {

    @RestResource(path = "byCountEpisodesMore", rel = "episodesMore")
    @Query(value = "{countEpisodes: {$gt: ?0}}")
    List<Anime> findAllByCountEpisodesMoreThan(@Param("countEpisodes") int pages);
}