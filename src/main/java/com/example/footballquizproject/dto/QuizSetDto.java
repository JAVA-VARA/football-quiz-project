package com.example.footballquizproject.dto;

import com.example.footballquizproject.domain.Players;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class QuizSetDto{

    private Long teamId;
    private List<Players> playersList;


}
