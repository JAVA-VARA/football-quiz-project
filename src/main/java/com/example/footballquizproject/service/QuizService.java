package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.QuizSet;
import com.example.footballquizproject.domain.QuizSetPlayer;
import com.example.footballquizproject.dto.QuizDto;
import com.example.footballquizproject.repository.PlayersRepository;
import com.example.footballquizproject.repository.QuizSetPlayersRepository;
import com.example.footballquizproject.repository.QuizSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final PlayersRepository playersRepository;
    private final QuizSetRepository quizSetRepository;
    private final QuizSetPlayersRepository quizSetPlayersRepository;

    //TODO:  teamId 기준 선수 목록 캐시에 저장 가능
    public List<QuizDto> createQuizSet(Long teamId, int numOfQuestions) {

        //유저가 선택한 팀에 속한 선수 조회
        List<Players> players = playersRepository.findByTeamId(teamId);

        //문제 수에 따라 선수 랜덤하게 선택
        Collections.shuffle(players);
        List<Players> selectedPlayers = players.stream()
                .limit(numOfQuestions)
                .toList();

        //선택한 선수의 정보를 DTO로 변환
        List<QuizDto> quizDtos = selectedPlayers.stream().map(
                player -> new QuizDto(player.getImageUrl(), player.getFullName(), player.getFirstName(), player.getMiddleName(), player.getLastName()))
                .collect(Collectors.toList());

        saveQuizSet(teamId, selectedPlayers);

        return quizDtos;
    }
    //선택한 선수를 퀴즈 세트에 삽입
    public void saveQuizSet(Long teamId, List<Players> selectedPlayers){

        QuizSet quizSet = new QuizSet();
        quizSet.setTeamId(teamId);
        quizSetRepository.save(quizSet);

        List<QuizSetPlayer> quizSetPlayers = selectedPlayers.stream()
                .map(player -> {
                    QuizSetPlayer quizSetPlayer = new QuizSetPlayer();
                    quizSetPlayer.setQuizSet(quizSet);
                    quizSetPlayer.setPlayer(player);
                    quizSetPlayer.setOrderIndex(selectedPlayers.indexOf(player) + 1);
                    return quizSetPlayer;
                })
                .toList();

        quizSetPlayersRepository.saveAll(quizSetPlayers);
    }

    public List<QuizDto> pick10PlayersByTeamId(Long teamId){
        List<Players> players = playersRepository.findRandomPlayersByTeamIdPick10(teamId);

        //dto에 필요한 정보만 저장 후 controller로 전달
        List<QuizDto> quizSetOfPlayers = new ArrayList<>();

        for(Players player : players){
            QuizDto playersDto = new QuizDto(player.getImageUrl(), player.getFullName(), player.getFirstName(), player.getMiddleName(), player.getLastName());
            quizSetOfPlayers.add(playersDto);
        }
        return quizSetOfPlayers;
    }
}