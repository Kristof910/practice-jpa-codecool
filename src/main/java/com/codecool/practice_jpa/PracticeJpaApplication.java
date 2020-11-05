package com.codecool.practice_jpa;

import com.codecool.practice_jpa.entity.AgeRating;
import com.codecool.practice_jpa.entity.Episode;
import com.codecool.practice_jpa.entity.Season;
import com.codecool.practice_jpa.entity.Series;
import com.codecool.practice_jpa.repository.SeasonRepository;
import com.codecool.practice_jpa.repository.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.List;

@SpringBootApplication
public class PracticeJpaApplication {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    public static void main(String[] args) {
        SpringApplication.run(PracticeJpaApplication.class, args);
    }

    @Bean
    @Profile("production")
    public CommandLineRunner init() {
        return args -> {
            Episode episode1season1 = Episode.builder()
                    .title("Episode 1 Season 1")
                    .length(120)
                    .build();

            Episode episode1season2 = Episode.builder()
                    .title("Episode 1 Season 2")
                    .length(40)
                    .build();

            Season season1 = Season.builder()
                    .title("Season 1")
                    .releaseDate(LocalDate.of(2012,4,4))
                    .episode(episode1season1)
                    .build();

            Season season2 = Season.builder()
                    .title("Season 2")
                    .releaseDate(LocalDate.of(2013,6,8))
                    .episode(episode1season2)
                    .build();

            Series breakingBad = Series.builder()
                    .title("Breaking Bad")
                    .numberOfSeasons(6)
                    .price(200.0)
                    .season(season1)
                    .season(season2)
                    .ageRating(AgeRating.AGE_18)
                    .actorsAndActress("Bryan Cranston")
                    .actorsAndActress("Aaron Paul")
                    .actorsAndActress("Dean Norris")
                    .build();

            episode1season1.setSeason(season1);
            episode1season2.setSeason(season2);
            season1.setSeries(breakingBad);
            season2.setSeries(breakingBad);

            // ?
            breakingBad.calculateNumberOfSeasons();
            season1.calculateNumberOfEpisodes();
            season2.calculateNumberOfEpisodes();

            seriesRepository.save(breakingBad);
        };
    }

}
