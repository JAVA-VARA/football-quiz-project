package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.LevelCategory;
import com.example.footballquizproject.domain.QuizHistory;
import com.example.footballquizproject.dto.RankingDto;
import com.example.footballquizproject.repository.LevelCategoryRepository;
import com.example.footballquizproject.repository.QuizHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {

    private final LevelCategoryRepository levelCategoryRepository;
    private final QuizHistoryRepository quizHistoryRepository;

    public LevelCategory determineResult(int correctAnswers) {
        // 정답 개수에 따라 결과를 반환
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

    //TODO: 랭킹 반환 로직 => 현재는 괜찮지만 사용자가 많아질수록 BIG(O)가 너무 커진다. => Redis로 구현해보기
    public RankingDto quizRankingByTeam(int correctAnswer, Long teamId) {
        List<QuizHistory> quizTotalParticipantsByTeam = quizHistoryRepository.getRanking(teamId);
        int total = quizTotalParticipantsByTeam.size();

        int i =0;
        int[] rankArray = new int[quizTotalParticipantsByTeam.size()];
        for(QuizHistory quizHistory : quizTotalParticipantsByTeam){
            rankArray[i] =  quizHistory.getCorrectAnswer();
            i++;
        }

        int rank = -1;
        for(int j =0; j<rankArray.length; j++){
            if(rankArray[j] == correctAnswer){
                rank = j+1;
                break;
            }
        }
        RankingDto rankingDto = new RankingDto();
        rankingDto.setTotalParticipantsByTeam(total);
        rankingDto.setRank(rank);

        return rankingDto;
    }
}



//        List<QuizHistory> quizTotalParticipantsByTeam = quizHistoryRepository.findByTeamId(teamId);
//
//        //total
//        int totalParticipants = quizTotalParticipantsByTeam.size();
//        rankingDto.setTotalParticipantsByTeam(totalParticipants);

//랭킹
// 1. 정렬: 내림차순으로 정렬
//        quizTotalParticipantsByTeam.sort((a, b) -> Integer.compare(b.getCorrectAnswer(), a.getCorrectAnswer()));
//
//        int[] ranks = new int[quizTotalParticipantsByTeam.size()];
//
//        for(int i : quizTotalParticipantsByTeam.)






//2 랭킹 반환
// *T0-DO: 이진 탐색으로 변경해서 성능을 좋게 만들자.
//        int rank = 1;
//        for (QuizHistory participant : quizTotalParticipantsByTeam) {
//
//            if(quizTotalParticipantsByTeam.get(0).getCorrectAnswer() <= userCorrectAnswers){
//                rankingDto.setRank(rank);
//                return rankingDto;
//            }
//            if (participant.getCorrectAnswer() != userCorrectAnswers) {
//                rank += 1;
//
//            }else {
//                break;
//            }
//        }
//        return rankingDto;
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
