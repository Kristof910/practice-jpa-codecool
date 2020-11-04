package com.codecool.practice_jpa.repository;

import com.codecool.practice_jpa.entity.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
