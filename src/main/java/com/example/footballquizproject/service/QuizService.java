package com.example.footballquizproject.service;

import com.example.footballquizproject.config.PlayerSetCache;
import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.dto.QuizDto;
import com.example.footballquizproject.repository.PlayersRepository;
import lombok.RequiredArgsConstructor;
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
    private final QuizSetService quizSetService;
    private final PlayerSetCache cache;

    public List<QuizDto> createQuizSet(Long teamId, int numOfQuestions) {

        //유저가 선택한 팀에 속한 선수 조회
        Set<Players> playersSetByTeamId = getPlayersListFromCache(teamId);
        if(playersSetByTeamId == null){
            playersSetByTeamId = savePlayersListByTeamIdToCache(teamId);
        }

        // 문제 수에 따라 선수 랜덤 선택
        List<Players> selectedPlayers = selectRandomPlayers(playersSetByTeamId, numOfQuestions);
        Long quizId = quizSetService.saveQuizSet(teamId, selectedPlayers);

        // 선택한 선수의 정보를 DTO로 변환
        return convertToQuizDtos(quizId, selectedPlayers);
    }


    private Set<Players> getPlayersListFromCache(Long teamId) {
        String cacheKey = "playersList_" + teamId;
        if(cache.containsKey(cacheKey)){
            return cache.get(cacheKey);
        }
        return null;
    }

    private Set<Players> savePlayersListByTeamIdToCache(Long teamId) {
        Set<Players> players =  playersRepository.findByTeamId(teamId);
        String cacheKey = "playersList_" + teamId;
        cache.put(cacheKey, players);

        return players;
    }

    private List<Players> selectRandomPlayers(Set<Players> playersSetByTeamId, int numOfQuestions) {
        List<Players> playersListByTeamId = new ArrayList<>(playersSetByTeamId);
        Collections.shuffle(playersListByTeamId);
        return playersListByTeamId.stream()
                .limit(numOfQuestions)
                .toList();
    }

    private List<QuizDto> convertToQuizDtos(Long quizId, List<Players> selectedPlayers) {
        return selectedPlayers.stream()
                .map(players ->
                        new QuizDto(quizId, players.getImageUrl(), players.getFullName(), players.getFirstName(), players.getMiddleName(), players.getLastName()))
                .collect(Collectors.toList());
    }
}