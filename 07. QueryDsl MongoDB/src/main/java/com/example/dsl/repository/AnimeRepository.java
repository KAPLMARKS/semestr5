package com.example.dsl.repository;


import com.example.dsl.model.Anime;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.List;

public interface AnimeRepository extends MongoRepository<Anime, String>, QuerydslPredicateExecutor<Anime> {
    List<Anime> findAnimeByRatingGreaterThan(Long rating);

}