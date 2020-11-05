package com.codecool.practice_jpa.repository;

import com.codecool.practice_jpa.entity.AgeRating;
import com.codecool.practice_jpa.entity.Series;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class AllRepositoryTest {

    @Autowired
    private SeriesRepository seriesRepository;

    @Autowired
    private SeasonRepository seasonRepository;

    @Autowired
    private EpisodeRepository episodeRepository;

    @Test
    public void saveSeries() {
        Series testSeries = Series.builder()
                .title("Black Mirror")
                .ageRating(AgeRating.AGE_18)
                .price(300.0)
                .build();

        seriesRepository.save(testSeries);

        List<Series> allSeries = seriesRepository.findAll();
        assertThat(allSeries).hasSize(1);
    }

    @Test
    public void seriesTitleCantBeNull() {
        assertThrows(DataIntegrityViolationException.class, () -> {
            Series testSeries = Series.builder()
                    .ageRating(AgeRating.AGE_18)
                    .price(300.0)
                    .build();

            seriesRepository.save(testSeries);
        });
    }

    @Test
    public void seriesRepositoryFindByTitleStartingWith() {
        Series testSeries1 = Series.builder()
                .title("Test Series")
                .build();

        Series testSeries2 = Series.builder()
                .title("Not Test Series")
                .build();

        seriesRepository.save(testSeries1);
        seriesRepository.save(testSeries2);

        List<Series> results = seriesRepository.findByTitleStartingWith("T");

        assertThat(results).contains(testSeries1);

    }

}