package com.example.footballquizproject.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;

@Entity
@Getter
public class AliasCategory {

    @Id
    private String alias;

    private int correctedAnswer;
}
