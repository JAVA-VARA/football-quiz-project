package com.example.footballquizproject.service;

import com.example.footballquizproject.config.PlayerSetCache;
import com.example.footballquizproject.domain.*;
import com.example.footballquizproject.dto.QuizDto;
import com.example.footballquizproject.repository.PlayerInQuizSetRepository;
import com.example.footballquizproject.repository.PlayersRepository;
import com.example.footballquizproject.repository.QuizSetRepository;
import com.example.footballquizproject.repository.TeamCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class QuizServiceTests {

    @Mock
    private PlayersRepository playersRepository;
    @Mock
    private QuizSetRepository quizSetRepository;
    @Mock
    private PlayerInQuizSetRepository playerInQuizSetRepository;
    @Mock
    private TeamCategoryRepository teamCategoryRepository;
    @Mock
    private PlayerSetCache cache;
    @InjectMocks
    private QuizService quizService;

    private Long teamId;

    private int numberOfQuestions;
    private Set<Players> playersSet;
    private List<Players> playersList;
    private TeamCategory team;

    @BeforeEach
    void setUp() {
        LeagueCategory leagueCategory = new LeagueCategory("leagueName", "leagueEmblem");
        teamId = 1L;
        team = new TeamCategory("teamName", "teamDescription", leagueCategory);
        numberOfQuestions = 10;

        Players player1 = new Players("url1", "FullName1", "FirstName1", "MiddleName1", "LastName1", "23/24", team, "1");
        Players player2 = new Players("url2", "FullName2", "FirstName2", "MiddleName2", "LastName2", "23/24", team, "2");
        Players player3 = new Players("url3", "FullName3", "FirstName3", "MiddleName3", "LastName3", "23/24", team, "3");
        Players player4 = new Players("url4", "FullName4", "FirstName4", "MiddleName4", "LastName4", "23/24", team, "4");
        Players player5 = new Players("url5", "FullName5", "FirstName5", "MiddleName5", "LastName5", "23/24", team, "5");
        Players player6 = new Players("url6", "FullName6", "FirstName6", "MiddleName6", "LastName6", "23/24", team, "6");
        Players player7 = new Players("url7", "FullName7", "FirstName7", "MiddleName7", "LastName7", "23/24", team, "7");
        Players player8 = new Players("url8", "FullName8", "FirstName8", "MiddleName8", "LastName8", "23/24", team, "8");
        Players player9 = new Players("url9", "FullName9", "FirstName9", "MiddleName9", "LastName9", "23/24", team, "9");
        Players player10 = new Players("url10", "FullName10", "FirstName10", "MiddleName10", "LastName10", "23/24", team, "10");

        playersSet = new HashSet<>(Arrays.asList(player1, player2, player3, player4, player5, player6, player7, player8, player9, player10));
        playersList = new ArrayList<>(playersSet);

    }

    @Test
    void createQuizSet_withPlayersInCache() {
        //given
        when(cache.containsKey("playersList_" + teamId)).thenReturn(true);
        when(cache.get("playersList_" + teamId)).thenReturn(playersSet);

        //when
        List<QuizDto> quizDto = quizService.createQuizSet(teamId, numberOfQuestions);

        //then
        assertNotNull(quizDto);
        assertEquals(numberOfQuestions, quizDto.size());
        verify(cache, times(1)).containsKey("playersList_"+teamId);
        verify(cache, times(1)).get("playersList_" + teamId);
    }

    @Test
    void createQuizSet_withPlayersNotInCache() {
        //given
        when(cache.containsKey("playersList_" + teamId)).thenReturn(false);
        when(playersRepository.findByTeamId(teamId)).thenReturn(playersSet);
        when(teamCategoryRepository.findByTeamId(teamId)).thenReturn(team);

        //when
        List<QuizDto> quizDto = quizService.createQuizSet(teamId, numberOfQuestions);

        //then
        assertNotNull(quizDto);
        assertEquals(numberOfQuestions, quizDto.size());
        verify(playersRepository, times(1)).findByTeamId(teamId);
        verify(teamCategoryRepository, times(1)).findByTeamId(teamId);
        verify(cache, times(1)).containsKey("playersList_" + teamId);
        verify(cache, times(1)).put("playersList_" + teamId, playersSet);

    }

    @Test
    void saveQuizSet() {

        //given
        when(teamCategoryRepository.findByTeamId(teamId)).thenReturn(team);

        doAnswer(invocation -> {
            QuizSet quizSet = invocation.getArgument(0);
            quizSet.setQuizSetId(1L); // Simulate ID generation
            return null;
        }).when(quizSetRepository).save(any(QuizSet.class));

        //when
        Long quizSetId = quizService.saveQuizSet(teamId, playersList);

        //then
        assertNotNull(quizSetId);
        verify(teamCategoryRepository, times(1)).findByTeamId(teamId);
        verify(quizSetRepository, times(1)).save(any(QuizSet.class));
        verify(playerInQuizSetRepository, times(1)).saveAll(anyList());
    }


}