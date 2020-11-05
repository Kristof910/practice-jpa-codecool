package com.codecool.practice_jpa.repository;

import com.codecool.practice_jpa.entity.Season;
import com.codecool.practice_jpa.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeriesRepository extends JpaRepository<Series, Long> {

    List<Series> findByTitleStartingWith(String letter);

}
