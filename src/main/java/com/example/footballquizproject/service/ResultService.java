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

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final LevelCategoryRepository levelCategoryRepository;
    private final QuizHistoryRepository quizHistoryRepository;
    private final Cache cache;

    public RankingDto calculateRanking(int currentUserCorrectAnswer, Long teamId) {
        Map<Integer, Integer> userCountByCorrectAnswer = getUserCountByCorrectAnswerFromCache(teamId);

        if(userCountByCorrectAnswer == null){
            userCountByCorrectAnswer = saveUserCountByCorrectAnswerToCache(teamId);
        }

        //등수 계산
        final int[] rank = {0};
        final int[] total = {0};

        userCountByCorrectAnswer.forEach((key, value) -> {
            if(key > currentUserCorrectAnswer){
                rank[0] += value;
            }
            total[0] += value;
        });

        //총점 계산
        userCountByCorrectAnswer.merge(currentUserCorrectAnswer, 1, Integer::sum);

        String cacheKey = "quizStat_" + teamId;
        cache.put(cacheKey, userCountByCorrectAnswer);

        return new RankingDto(rank[0], total[0]);
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

    private Map<Integer, Integer> getUserCountByCorrectAnswerFromCache(Long teamId){
        String cacheKey = "quizStat_" + teamId;
        if(cache.containsKey(cacheKey)){
            return (Map<Integer, Integer>) cache.get(cacheKey);
        }
        return null;
    }

    private Map<Integer, Integer> saveUserCountByCorrectAnswerToCache(Long teamId){
        //DB에서 DATA 가져오기
        List<QuizHistory> quizTotalParticipantsByTeam = quizHistoryRepository.getRanking(teamId);
        //CACHE에 저장
        String cacheKey = "quizStat_" + teamId;
        Map<Integer, Integer> userCountByCorrectAnswer = quizTotalParticipantsByTeam.stream()
                        .collect(Collectors.toMap(
                                QuizHistory::getCorrectAnswer,
                                qh -> 1,
                                Integer::sum
                        ));

        cache.put(cacheKey, userCountByCorrectAnswer);
        return userCountByCorrectAnswer;
    }
}