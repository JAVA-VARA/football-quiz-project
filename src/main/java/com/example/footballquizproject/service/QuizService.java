package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.dto.QuizDto;
import com.example.footballquizproject.repository.PlayersRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizService {

    private final PlayersRepository playersRepository;

    public List<QuizDto> pick20PlayersByTeamName(String teamName){

        //팀별로 선수 선택 후 섞음.
        List<Players> playersList = playersRepository.findByTeamTeamName(teamName);
        Collections.shuffle(playersList);

        //섞은 list에서 20개 선택 후 반환
        int numOfSelectedList = 20;
        List<Players> selectedPlayers = new ArrayList<>();
        for(int i=0; i< numOfSelectedList; i++){
            selectedPlayers.add(playersList.get(i));
        }

        //dto에 필요한 정보만 저장 후 controller로 전달
        List<QuizDto> quizSetOfPlayers = new ArrayList<>();

        for(Players player : selectedPlayers){
            QuizDto playersDto = new QuizDto(player.getImageUrl(), player.getName());
            quizSetOfPlayers.add(playersDto);
        }
        return quizSetOfPlayers;
    }
}