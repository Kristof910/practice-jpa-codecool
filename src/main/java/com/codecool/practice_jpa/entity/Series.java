package com.codecool.practice_jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Series {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;

    private Integer numberOfSeasons;

    private Double price;

    @OneToMany(mappedBy = "series", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Singular
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Season> seasons;

    @Enumerated(EnumType.STRING)
    private AgeRating ageRating;

    @ElementCollection
    @Singular
    private List<String> actorsAndActresses;

    public void calculateNumberOfSeasons() {
        numberOfSeasons = seasons.toArray().length;
    }
}

