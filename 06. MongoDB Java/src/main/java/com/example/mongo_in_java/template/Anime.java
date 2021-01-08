package com.example.mongo_in_java.template;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Anime {
    private String _id;
    private String title;
    private Map<String, String> episodes;
    private Double rating;
    private Integer countEpisodes;
}