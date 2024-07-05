package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.PlayerInQuizSet;
import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.QuizSet;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.repository.QuizSetRepository;
import com.example.footballquizproject.repository.TeamCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class QuizSetServiceTest {

    @InjectMocks
    private QuizSetService quizSetService;

    @Mock
    private TeamCategoryRepository teamCategoryRepository;

    @Mock
    private QuizSetRepository quizSetRepository;

    @Mock
    private PlayerInQuizSetService playerInQuizSetService;

    private TeamCategory teamCategory;
    private QuizSet quizSet;
    private List<Players> selectedPlayers;
    private List<PlayerInQuizSet> playerInQuizSets;

    @BeforeEach
    void setup() {
        teamCategory = new TeamCategory();
        quizSet = new QuizSet();
        selectedPlayers = new ArrayList<>();
        playerInQuizSets = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Players player = new Players();
            selectedPlayers.add(player);

            PlayerInQuizSet playerInQuizSet = new PlayerInQuizSet();
            playerInQuizSets.add(playerInQuizSet);
        }
    }

    @Test
    void saveQuizSet() {
        //given
        when(teamCategoryRepository.findByTeamId(any(Long.class))).thenReturn(teamCategory);
        when(quizSetRepository.save(any(QuizSet.class))).thenReturn(quizSet);
        when(playerInQuizSetService.createPlayerInQuizSet(any(QuizSet.class), any(Players.class), anyInt()))
                .thenReturn(playerInQuizSets.get(0));

        //when
        Long quizId = quizSetService.saveQuizSet(1L,selectedPlayers);

        //then
        assertEquals(quizSet.getQuizId(), quizId);
    }
}