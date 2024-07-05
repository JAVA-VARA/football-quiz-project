package com.example.footballquizproject.service;

import com.example.footballquizproject.config.RankingCache;
import com.example.footballquizproject.domain.LevelCategory;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.dto.QuizResultRequestDto;
import com.example.footballquizproject.dto.RankingDto;
import com.example.footballquizproject.repository.NewQuizHistoryRepository;
import com.example.footballquizproject.repository.TeamCategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RankingServiceTest {

    @InjectMocks
    private RankingService rankingService;

    @Mock
    private RankingCache rankingCache;

    @Mock
    private TeamCategoryRepository teamCategoryRepository;

    @Mock
    private NewQuizHistoryRepository newQuizHistoryRepository;

    @Mock
    private LevelCategoryService levelCategoryService;


    private QuizResultRequestDto requestDto;

    @BeforeEach
    void setup(){
        rankingCache.clear();
        requestDto = QuizResultRequestDto.builder()
                .quizId(1L)
                .categoryId(1L)
                .teamId(1L)
                .countCorrectAnswers(5)
                .userAnswers(List.of("Answer1", "Answer2", "Answer3", "Answer4", "Answer5"))
                .correctAnswers(List.of("Correct1", "Correct2", "Correct3", "Correct4", "Correct5"))
                .isCorrectAnswers(List.of(true, false, true, false, true))
                .build();
    }

    @Test
    void getRanking_whenCacheIsNotEmpty() {
        //given
        Long teamId = requestDto.getTeamId();
        String cacheKey = "quizStat_" + teamId;
        Map<Integer, Integer> userCountByCorrectAnswer = new HashMap<>();
        userCountByCorrectAnswer.put(3, 10);
        userCountByCorrectAnswer.put(5, 5);
        rankingCache.put(cacheKey,userCountByCorrectAnswer);

        when(rankingCache.containsKey(cacheKey)).thenReturn(true);
        when(rankingCache.get(cacheKey)).thenReturn(userCountByCorrectAnswer);



        TeamCategory team  = new TeamCategory();
        team.setTeamName("Test_Team");
        when(teamCategoryRepository.findByTeamId(teamId)).thenReturn(team);

        LevelCategory level = new LevelCategory();
        int correctAnswers = requestDto.getCountCorrectAnswers();
        when(levelCategoryService.getLevelByUserCorrectAnswers(correctAnswers)).thenReturn(level);

        //when
        RankingDto rankingDto = rankingService.getRanking(requestDto);

        //then
        assertNotNull(rankingDto);
        assertEquals(1, rankingDto.getRanking());
        assertEquals(15, rankingDto.getTotalParticipantsByTeam());
        assertEquals(level, rankingDto.getLevel());
        assertEquals("Test_Team", rankingDto.getTeamName());
        assertEquals(5, correctAnswers);
    }
    @Test
    void getRanking_whenCacheIsEmpty(){
        //given
        Long teamId = requestDto.getTeamId();
        List<Object[]> results = List.of(new Object[]{1L, 5L}, new Object[]{2L, 3L});
        when(newQuizHistoryRepository.findQuizHistoryWithCorrectAnswerCounts(teamId)).thenReturn(results);

        TeamCategory teamCategory = new TeamCategory();
        teamCategory.setTeamName("Test_Team");
        when(teamCategoryRepository.findByTeamId(1L)).thenReturn(teamCategory);

        LevelCategory level = new LevelCategory();
        int correctAnswers = requestDto.getCountCorrectAnswers();
        when(levelCategoryService.getLevelByUserCorrectAnswers(correctAnswers)).thenReturn(level);

        //when
        RankingDto rankingDto = rankingService.getRanking(requestDto);

        //then
        assertNotNull(rankingDto);
        assertEquals(1, rankingDto.getRanking());
        assertEquals(2, rankingDto.getTotalParticipantsByTeam());
        assertEquals(level, rankingDto.getLevel());
        assertEquals("Test_Team", rankingDto.getTeamName());
        assertEquals(5, correctAnswers);
    }
}