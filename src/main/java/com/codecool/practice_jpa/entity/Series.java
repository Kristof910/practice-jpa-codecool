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
public class Series {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private Integer numberOfSeasons;

    private Double price;

    @OneToMany(mappedBy = "series", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @Singular
    @EqualsAndHashCode.Exclude
    private Set<Season> seasons;
}

