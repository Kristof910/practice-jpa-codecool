package com.codecool.practice_jpa.repository;

import com.codecool.practice_jpa.entity.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
