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

    private String title;

    private Integer numberOfEpisodes;

    private LocalDate releaseDate;

    @ManyToOne
    private Series series;

    @OneToMany(mappedBy = "season", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Singular
    @EqualsAndHashCode.Exclude
    private Set<Episode> episodes;
}

