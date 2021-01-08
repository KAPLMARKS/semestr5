package com.example.mongo_in_java.repository;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(RepositoriesConfig.class);
        EpisodeRepository episodeRepository = context.getBean(EpisodeRepository.class);
        AnimeRepository animeRepository = context.getBean(AnimeRepository.class);
        // Save
        Episode first = Episode.builder()
                .name("Первая серия")
                .build();
        Episode second = Episode.builder()
                .name("Вторая серия не вышла")
                .build();
        episodeRepository.save(first);
        episodeRepository.save(second);

        Anime anime = Anime.builder()
                .title("Нарута")
                .episodes(Collections.singletonList(first))
                .countEpisodes(700)
                .rating(8.5)
                .build();
        animeRepository.save(anime);

        System.out.println(animeRepository.findAllByCountEpisodesMoreThan(500));

        Episode deleteFirst = episodeRepository.findByName("Первая серия");
        episodeRepository.delete(deleteFirst);

        Episode updateSecond = episodeRepository.findByName("Вторая серия не вышла");
        updateSecond.setName("Ура Вторая серия вышла");
        episodeRepository.save(updateSecond);
    }
}