package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.dto.QuizDto;
import com.example.footballquizproject.repository.PlayersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final PlayersRepository playersRepository;

    public List<QuizDto> pick20PlayersByTeamName(String teamName){

        List<Players> players = playersRepository.findRandomPlayersByTeamName(teamName);

        //dto에 필요한 정보만 저장 후 controller로 전달
        List<QuizDto> quizSetOfPlayers = new ArrayList<>();

        for(Players player : players){
            QuizDto playersDto = new QuizDto(player.getImageUrl(), player.getFullName(), player.getFirstname(), player.getLastname());
            quizSetOfPlayers.add(playersDto);
        }
        return quizSetOfPlayers;
    }
}