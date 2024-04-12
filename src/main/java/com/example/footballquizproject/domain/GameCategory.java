package com.example.footballquizproject.domain;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class GameCategory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long categoryId;
    @Column
    private String categoryThumbnail;

    @Column
    private String categoryUrl;

    @Column private String categoryName;

    @Column private String categoryDescription;
}
