package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.AliasCategory;
import com.example.footballquizproject.domain.QuizHistory;
import com.example.footballquizproject.dto.RankingDto;
import com.example.footballquizproject.repository.AliasCategoryRepository;
import com.example.footballquizproject.repository.QuizHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final AliasCategoryRepository aliasCategoryRepository;
    private final QuizHistoryRepository quizHistoryRepository;

    public String determineResult(int correctAnswers) {
        // 정답 개수에 따라 결과를 반환
        AliasCategory alias =
                aliasCategoryRepository
                        .findByMinCorrectAnswersLessThanEqualAndMaxCorrectAnswersGreaterThanEqual
                                (correctAnswers, correctAnswers);
        return alias.getAlias();
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

    public RankingDto quizRankingByTeam(int userCorrectAnswers, Long teamId) {

        List<QuizHistory> quizTotalParticipantsByTeam = quizHistoryRepository.findByTeamId(teamId);
        RankingDto rankingDto = new RankingDto();
        int totalParticipants = quizTotalParticipantsByTeam.size();
        rankingDto.setTotalParticipantsByTeam(totalParticipants);

        // 1. 정렬: 내림차순으로 정렬
        quizTotalParticipantsByTeam.sort((a, b) -> Integer.compare(b.getCorrectAnswer(), a.getCorrectAnswer()));

        //2 랭킹 반환
        // *T0-DO: 이진 탐색으로 변경해서 성능을 좋게 만들자.
        int rank = 1;
        for (QuizHistory participant : quizTotalParticipantsByTeam) {

            if(quizTotalParticipantsByTeam.get(0).getCorrectAnswer() <= userCorrectAnswers){
                rankingDto.setRank(rank);
                return rankingDto;
            }
            if (participant.getCorrectAnswer() != userCorrectAnswers) {
                rank += 1;

            }else {
                break;
            }
        }
        return rankingDto;
    }
}

//        //2 랭킹 찾기
//        // 2. 이진 탐색을 사용하여 사용자의 점수가 몇 등인지 확인
//        int left = 0;
//        int right = quizTotalParticipantsByTeam.size() - 1;
//        while (left <= right) {
//            int mid = left + (right - left) / 2;
//            if (quizTotalParticipantsByTeam.get(mid).getCorrectAnswer() >= userCorrectAnswers) {
//                right = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }
//
//        // left는 사용자의 등수이며, 동점자가 있을 경우 동점자의 마지막 인덱스를 반환
//        return left + 1;
//    }}
