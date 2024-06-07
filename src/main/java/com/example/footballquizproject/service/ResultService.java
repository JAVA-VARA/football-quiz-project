package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.LevelCategory;
import com.example.footballquizproject.domain.QuizHistory;
import com.example.footballquizproject.dto.RankingDto;
import com.example.footballquizproject.repository.LevelCategoryRepository;
import com.example.footballquizproject.repository.QuizHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final LevelCategoryRepository levelCategoryRepository;
    private final QuizHistoryRepository quizHistoryRepository;

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
    @Cacheable(value = "ranking", key = "#teamId", cacheManager = "testCacheManager")
    public RankingDto quizRankingByTeam(int correctAnswer, Long teamId) {
        //맞춘갯수를 내림차순으로 가져온 list
        List<QuizHistory> quizTotalParticipantsByTeam = quizHistoryRepository.getRanking(teamId);
        int total = quizTotalParticipantsByTeam.size();

        //이진검색
        int rank = 0;
        int pl = 0;
        int pr = total - 1;

        while (pl <= pr) {
            int pc = (pl + pr) / 2;
            int currentCorrectAnswer = quizTotalParticipantsByTeam.get(pc).getCorrectAnswer();

            if (correctAnswer == currentCorrectAnswer) {
                rank = pc + 1; // 순위는 1부터 시작하므로 pc + 1로 설정
                break;
            } else if (correctAnswer > currentCorrectAnswer) {
                pr = pc - 1;
            } else {
                pl = pc + 1;
            }
        }

        if (pl > pr) {
            rank = pl + 1; // 정확히 일치하는 답이 없는 경우 순위를 계산
        }


        RankingDto rankingDto = new RankingDto();
        rankingDto.setTotalParticipantsByTeam(total);
        rankingDto.setRank(rank);

        return rankingDto;
    }
}

//        랭킹 선형 검색 => 업그레이드 해보자
//    int rank = (int) quizTotalParticipantsByTeam.stream()
//            .map(QuizHistory::getCorrectAnswer)
//            .filter(answer -> answer >= correctAnswer)
//            .count();
