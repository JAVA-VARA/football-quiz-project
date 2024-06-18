package com.example.footballquizproject.service;

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

    // 인메모리 캐시를 인스턴스 변수로 선언
    private final Map<Long, Map<Integer, Integer>> quizStatCache = new HashMap<>();

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

    public RankingDto quizRankingByTeam(int currentUserCorrectAnswer, Long teamId) {

        Map<Integer, Integer> userCountByCorrectAnswer = quizStatCache.getOrDefault(teamId, new HashMap<>());

        //if: hash map에 teamId가 있으면 가져오기
        if (userCountByCorrectAnswer.isEmpty()) {
            List<QuizHistory> quizTotalParticipantsByTeam = quizHistoryRepository.getRanking(teamId);
            for (QuizHistory quizHistory : quizTotalParticipantsByTeam) {
                int correctAnswer = quizHistory.getCorrectAnswer();
                userCountByCorrectAnswer.put(correctAnswer, userCountByCorrectAnswer.getOrDefault(correctAnswer, 0) + 1);
            }

            quizStatCache.put(teamId, userCountByCorrectAnswer);
        }

        //등수 계산
        int rankInteger=0;
        int totalInteger=0;
        for (Map.Entry<Integer, Integer> entry : userCountByCorrectAnswer.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();

            if (key > currentUserCorrectAnswer) {
                rankInteger += value;
            }

            if (key == currentUserCorrectAnswer) {
                userCountByCorrectAnswer.put(key, value + 1);
            }

            totalInteger += value;
        }

        quizStatCache.put(teamId, userCountByCorrectAnswer);

        RankingDto rankingDto = new RankingDto();

        int rank = rankInteger;
        int total = totalInteger;

        rankingDto.setTotalParticipantsByTeam(total);
        rankingDto.setRank(rank);

        return rankingDto;
    }
}