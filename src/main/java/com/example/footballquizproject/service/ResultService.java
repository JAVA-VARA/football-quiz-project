package com.example.footballquizproject.service;

import com.example.footballquizproject.config.RankingCache;
import com.example.footballquizproject.domain.*;
import com.example.footballquizproject.dto.QuizResultRequestDto;
import com.example.footballquizproject.dto.RankingDto;
import com.example.footballquizproject.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final LevelCategoryRepository levelCategoryRepository;
    private final NewQuizHistoryRepository newQuizHistoryRepository;
    private final QuizSetRepository quizSetRepository;
    private final RankingCache cache;
    private final GameCategoryRepository gameCategoryRepository;
    private final TeamCategoryRepository teamCategoryRepository;

    //게임 종료 후 결과 저장
    public void saveResult(QuizResultRequestDto quizResult) {

        List<QuizAnswer> quizAnswers  = saveQuizAnswers(quizResult);
        QuizSet quizSet = quizSetRepository.findByQuizId(quizResult.getQuizId());
        TeamCategory team = quizSet.getTeamCategory();
        GameCategory quizCategory = gameCategoryRepository.findByCategoryId(quizResult.getCategoryId());

        boolean isCompleted = true;

        NewQuizHistory newQuizHistory = NewQuizHistory.builder()
                .isCompleted(isCompleted)
                .quizSet(quizSet)
                .quizAnswers(quizAnswers)
                .team(team)
                .game(quizCategory)
                .build();

        // 연관관계를 설정
        quizAnswers.forEach(quizAnswer -> quizAnswer.setQuizHistory(newQuizHistory));

        newQuizHistoryRepository.save(newQuizHistory);
    }

    private List<QuizAnswer> saveQuizAnswers(QuizResultRequestDto answerDto) {

        List<String> correctAnswers = answerDto.getCorrectAnswers();
        List<String> userAnswers = answerDto.getUserAnswers();
        List<Boolean> isCorrect = answerDto.getIsCorrectAnswers();

        List<QuizAnswer> quizAnswers = new ArrayList<>();
        for(int i = 0; i < correctAnswers.size(); i++){
            QuizAnswer quizAnswer = QuizAnswer.builder()
                    .correctAnswer(correctAnswers.get(i))
                    .userAnswer(userAnswers.get(i))
                    .isCorrect(isCorrect.get(i))
                    .build();
            quizAnswers.add(quizAnswer);
        }

        return quizAnswers;
    }

    //랭킹, 레벨 반환
    public RankingDto showResult(QuizResultRequestDto quizResult) {
        Long teamId = quizResult.getTeamId();
        Map<Integer, Integer> userCountByCorrectAnswer = getUserCountByCorrectAnswerFromCache(teamId);

        if(userCountByCorrectAnswer == null){
            userCountByCorrectAnswer = saveUserCountByCorrectAnswerToCache(teamId);
        }

        //등수
        int currentUserCorrectAnswer = quizResult.getCountCorrectAnswers();
        int[] result = rankingCalculation(userCountByCorrectAnswer, currentUserCorrectAnswer, teamId);
        int ranking = result[0];
        int totalParticipantsByTeam = result[1];

        //레벨
        LevelCategory level = determineResult(currentUserCorrectAnswer);

        // 부가정보
        int correctAnswers = quizResult.getCountCorrectAnswers();
        TeamCategory teamCategory = teamCategoryRepository.findByTeamId(teamId);
        String teamName = teamCategory.getTeamName();

        return new RankingDto(ranking, totalParticipantsByTeam, level, teamName, correctAnswers);
    }

    private int[] rankingCalculation(Map<Integer, Integer> userCountByCorrectAnswer, int currentUserCorrectAnswer, Long teamId) {
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

    private LevelCategory determineResult(int correctAnswers) {
        return levelCategoryRepository
                .findByMinCorrectAnswersLessThanEqualAndMaxCorrectAnswersGreaterThanEqual
                        (correctAnswers, correctAnswers);
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

        for (Object[] result : results) {
            Long historyId = (Long) result[0];
            Long correctAnswerCount = (Long) result[1];
            System.out.println("History ID: " + historyId + ", Correct Answer Count: " + correctAnswerCount);
        }
        Map<Integer, Integer> userCountByCorrectAnswer = new HashMap<>();
        for (Object[] result : results) {
            Long correctAnswerCount = (Long) result[1];
            int correctAnswerCountInt = correctAnswerCount.intValue();
            userCountByCorrectAnswer.put(correctAnswerCountInt, userCountByCorrectAnswer.getOrDefault(correctAnswerCountInt, 0) + 1);
        }

        return userCountByCorrectAnswer;
    }
}