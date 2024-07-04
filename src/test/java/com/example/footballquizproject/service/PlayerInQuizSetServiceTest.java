package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.PlayerInQuizSet;
import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.QuizSet;
import com.example.footballquizproject.domain.TeamCategory;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
class PlayerInQuizSetServiceTest {

    @InjectMocks
    private PlayerInQuizSetService playerInQuizSetService;

    @Test
    void createPlayerInQuizSet() {

        //given
        QuizSet quizSet = new QuizSet();
        TeamCategory team = new TeamCategory();
        Players players = new Players("url1", "FullName1", "FirstName1", "MiddleName1", "LastName1", "23/24", team, "1");
        int orderIndex = 1;


        //when
        PlayerInQuizSet playerInQuizSet =  playerInQuizSetService.createPlayerInQuizSet(quizSet, players, orderIndex);

        //then
        assertNotNull(playerInQuizSet);
        assertEquals(orderIndex, playerInQuizSet.getOrderIndex());
        assertEquals(players, playerInQuizSet.getPlayer());
        assertEquals(quizSet, playerInQuizSet.getQuizSet());
    }
}