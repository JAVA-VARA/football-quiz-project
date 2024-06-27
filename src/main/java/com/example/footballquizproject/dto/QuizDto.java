package com.example.footballquizproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class QuizDto {

    private Long quizId;
    private String question;
    private String fullName;
    private String firstName;
    private String middleName;
    private String lastName;

}
