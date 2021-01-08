package com.example.mongo_in_java.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Document(collection = "animes")
public class Anime {
    @Id
    private String _id;
    private String title;
    private Double rating;
    private Integer countEpisodes;
    @DBRef
    private List<Episode> episodes;
}