package com.example.footballquizproject.service;

import com.example.footballquizproject.config.Cache;
import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.QuizSet;
import com.example.footballquizproject.domain.QuizSetPlayer;
import com.example.footballquizproject.dto.QuizDto;
import com.example.footballquizproject.repository.PlayersRepository;
import com.example.footballquizproject.repository.QuizSetPlayersRepository;
import com.example.footballquizproject.repository.QuizSetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuizService {
    private final PlayersRepository playersRepository;
    private final QuizSetRepository quizSetRepository;
    private final QuizSetPlayersRepository quizSetPlayersRepository;
    private final Cache cache;

    public List<QuizDto> createQuizSet(Long teamId, int numOfQuestions) {

        //유저가 선택한 팀에 속한 선수 조회
        Set<Players> playersSetByTeamId = getPlayersListFromCache(teamId);

        if(playersSetByTeamId == null){
            playersSetByTeamId = savePlayersListByTeamIdToCache(teamId);
        }

        List<Players> playersListByTeamId = playersSetByTeamId.stream().collect(Collectors.toList());
        //문제 수에 따라 선수 랜덤 선택
        Collections.shuffle(playersListByTeamId);
        List<Players> selectedPlayers = playersListByTeamId.stream()
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
    @Async
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

    private Set<Players> getPlayersListFromCache(Long teamId) {
        String cacheKey = "playersList_" + teamId;
        if(cache.containsKey(cacheKey)){
            return (Set<Players>) cache.get(cacheKey);
        }
        return null;
    }
    private Set<Players> savePlayersListByTeamIdToCache(Long teamId) {
        Set<Players> players =  playersRepository.findByTeamId(teamId);
        String cacheKey = "playersList_" + teamId;
        cache.put(cacheKey, players);

        return players;
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