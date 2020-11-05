package com.codecool.practice_jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Season {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    private Integer numberOfEpisodes;

    private LocalDate releaseDate;

    @ManyToOne
    private Series series;

    @OneToMany(mappedBy = "season", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Singular
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Episode> episodes;

    public void calculateNumberOfEpisodes() {
        numberOfEpisodes = episodes.toArray().length;
    }
}

