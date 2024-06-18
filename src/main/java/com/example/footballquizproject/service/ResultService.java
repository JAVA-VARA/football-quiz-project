package com.example.footballquizproject.service;

import com.example.footballquizproject.config.Cache;
import com.example.footballquizproject.domain.LevelCategory;
import com.example.footballquizproject.domain.QuizHistory;
import com.example.footballquizproject.dto.RankingDto;
import com.example.footballquizproject.repository.LevelCategoryRepository;
import com.example.footballquizproject.repository.QuizHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final LevelCategoryRepository levelCategoryRepository;
    private final QuizHistoryRepository quizHistoryRepository;
    private final Cache cache;

    public RankingDto quizRankingByTeam(int currentUserCorrectAnswer, Long teamId) {

        String cacheKey = "quizStat_" + teamId;
        Map<Integer, Integer> userCountByCorrectAnswer;

        if (cache.containsKey(cacheKey)) {
            userCountByCorrectAnswer = (Map<Integer, Integer>) cache.get(cacheKey);

        } else {
            userCountByCorrectAnswer = new HashMap<>();
            List<QuizHistory> quizTotalParticipantsByTeam = quizHistoryRepository.getRanking(teamId);
            for (QuizHistory quizHistory : quizTotalParticipantsByTeam) {
                int correctAnswer = quizHistory.getCorrectAnswer();
                userCountByCorrectAnswer.put(correctAnswer, userCountByCorrectAnswer.getOrDefault(correctAnswer, 0) + 1);
            }
            cache.put(teamId, userCountByCorrectAnswer);
        }

        //등수 계산
        int rank=0;
        int total=0;
        for (Integer key : userCountByCorrectAnswer.keySet()) {

            if(key > currentUserCorrectAnswer){
                rank += userCountByCorrectAnswer.get(key);
            }

            if(key.equals(currentUserCorrectAnswer)){
                userCountByCorrectAnswer.put(key, userCountByCorrectAnswer.get(key)+1);
            }

            total += userCountByCorrectAnswer.get(key);
        }

        cache.put(cacheKey, userCountByCorrectAnswer);

        RankingDto rankingDto = new RankingDto();
        rankingDto.setTotalParticipantsByTeam(total);
        rankingDto.setRank(rank);

        return rankingDto;
    }

    public LevelCategory determineResult(int correctAnswers) {
        return levelCategoryRepository
                .findByMinCorrectAnswersLessThanEqualAndMaxCorrectAnswersGreaterThanEqual
                        (correctAnswers, correctAnswers);
    }

    @Transactional
    public void saveQuizHistory(int correctAnswers, Long teamId) {
        //정답 갯수 및 플레이한 시간 등등 저장
        QuizHistory quizHistory = QuizHistory.builder()
                .correctAnswer(correctAnswers)
                .teamId(teamId)
                .build();
        quizHistoryRepository.save(quizHistory);
    }
}