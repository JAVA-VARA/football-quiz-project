package com.example.footballquizproject.service;

import com.example.footballquizproject.config.RankingCache;
import com.example.footballquizproject.domain.LevelCategory;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.dto.QuizResultRequestDto;
import com.example.footballquizproject.dto.RankingDto;
import com.example.footballquizproject.repository.NewQuizHistoryRepository;
import com.example.footballquizproject.repository.TeamCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor

public class RankingService {
    private final RankingCache cache;
    private final LevelCategoryService levelCategoryService;
    private final TeamCategoryRepository teamCategoryRepository;
    private final NewQuizHistoryRepository newQuizHistoryRepository;

    public RankingDto getRanking(QuizResultRequestDto quizResult) {
        Long teamId = quizResult.getTeamId();
        Map<Integer, Integer> userCountByCorrectAnswer = getUserCountByCorrectAnswerFromCache(teamId);

        if(userCountByCorrectAnswer == null){
            userCountByCorrectAnswer = saveUserCountByCorrectAnswerToCache(teamId);
        }

        //등수
        int currentUserCorrectAnswer = quizResult.getCountCorrectAnswers();
        int[] result = rankingCalculator(userCountByCorrectAnswer, currentUserCorrectAnswer, teamId);
        int ranking = result[0];
        int totalParticipantsByTeam = result[1];

        //레벨
        LevelCategory level = levelCategoryService.getLevelByUserCorrectAnswers(currentUserCorrectAnswer);

        // 부가정보
        int correctAnswers = quizResult.getCountCorrectAnswers();
        TeamCategory teamCategory = teamCategoryRepository.findByTeamId(teamId);
        String teamName = teamCategory.getTeamName();

        return new RankingDto(ranking, totalParticipantsByTeam, level, teamName, correctAnswers);
    }

    private int[] rankingCalculator(Map<Integer, Integer> userCountByCorrectAnswer, int currentUserCorrectAnswer, Long teamId) {
        final int[] rank = {1};
        final int[] total = {0};

        userCountByCorrectAnswer.forEach((key, value) -> {
            if(key > currentUserCorrectAnswer){
                rank[0] += value;
            }
            total[0] += value;
        });

        userCountByCorrectAnswer.merge(currentUserCorrectAnswer, 1, Integer::sum);

        String cacheKey = "quizStat_" + teamId;
        cache.put(cacheKey, userCountByCorrectAnswer);

        int[] result = new int[2];
        result[0] = rank[0];
        result[1] = total[0];

        return result;
    }

    //캐시 조회
    private Map<Integer, Integer> getUserCountByCorrectAnswerFromCache(Long teamId){
        String cacheKey = "quizStat_" + teamId;
        if(cache.containsKey(cacheKey)){
            return cache.get(cacheKey);
        }
        return null;
    }

    //DB 조회
    private Map<Integer, Integer> saveUserCountByCorrectAnswerToCache(Long teamId){

        List<Object[]> results = newQuizHistoryRepository.findQuizHistoryWithCorrectAnswerCounts(teamId);
        Map<Integer, Integer> userCountByCorrectAnswer = new HashMap<>();

        for (Object[] result : results) {
            Long historyId = (Long) result[0];
            Long correctAnswerCount = (Long) result[1];
            System.out.println("History ID: " + historyId + ", Correct Answer Count: " + correctAnswerCount);

            int correctAnswerCountInt = correctAnswerCount.intValue();
            userCountByCorrectAnswer.put(correctAnswerCountInt, userCountByCorrectAnswer.getOrDefault(correctAnswerCountInt, 0) + 1);
        }

        return userCountByCorrectAnswer;
    }
}
