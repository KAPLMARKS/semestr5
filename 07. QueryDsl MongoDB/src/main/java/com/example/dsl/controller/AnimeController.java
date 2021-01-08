package com.example.dsl.controller;

import com.example.dsl.dto.AnimeDto;
import com.example.dsl.model.Anime;
import com.example.dsl.repository.AnimeRepository;
import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.ArrayList;
import java.util.List;

@Controller("/anime/")
public class AnimeController {
    @Autowired
    private AnimeRepository animeRepository;

    @GetMapping("/search")
    public ResponseEntity<?> find(@QuerydslPredicate(root = Anime.class) Predicate predicate){
        Iterable<Anime> courses = animeRepository.findAll(predicate);
        List<AnimeDto> dtos = new ArrayList<>();
        for (Anime anime :
                courses) {
            dtos.add(new AnimeDto(anime.get_id(), anime.getTitle(), anime.getRating()));
        }
        return ResponseEntity.ok(dtos);
    }
}