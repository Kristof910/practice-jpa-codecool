package com.codecool.practice_jpa.repository;

import com.codecool.practice_jpa.entity.Season;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonRepository extends JpaRepository<Season, Long> {
}
