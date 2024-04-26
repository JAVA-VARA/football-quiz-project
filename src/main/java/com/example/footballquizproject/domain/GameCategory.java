package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class GameCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;

    @Column
    private String categoryThumbnail;

    @Column
    private String categoryUrl;

    @Column
    private String categoryName;

    @Column
    private String categoryDescription;
}
