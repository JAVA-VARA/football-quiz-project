package com.example.footballquizproject.service;

import com.example.footballquizproject.config.PlayerSetCache;
import com.example.footballquizproject.domain.PlayerInQuizSet;
import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.QuizSet;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.dto.QuizDto;
import com.example.footballquizproject.repository.PlayerInQuizSetRepository;
import com.example.footballquizproject.repository.PlayersRepository;
import com.example.footballquizproject.repository.QuizSetRepository;
import com.example.footballquizproject.repository.TeamCategoryRepository;
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
    private final QuizSetRepository quizSetRepository;
    private final PlayerInQuizSetRepository playerInQuizSetRepository;
    private final TeamCategoryRepository teamCategoryRepository;
    private final PlayerSetCache cache;

    public List<QuizDto> createQuizSet(Long teamId, int numOfQuestions) {

        //유저가 선택한 팀에 속한 선수 조회
        Set<Players> playersSetByTeamId = getPlayersListFromCache(teamId);
        if(playersSetByTeamId == null){
            playersSetByTeamId = savePlayersListByTeamIdToCache(teamId);
        }
        // 문제 수에 따라 선수 랜덤 선택
        List<Players> selectedPlayers = selectRandomPlayers(playersSetByTeamId, numOfQuestions);

        Long quizSetId = saveQuizSet(teamId, selectedPlayers);

        // 선택한 선수의 정보를 DTO로 변환
        return convertToQuizDtos(quizSetId, selectedPlayers);

    }

    // 선택한 선수를 퀴즈 세트에 삽입
    public Long saveQuizSet(Long teamId, List<Players> selectedPlayers) {
        TeamCategory team = teamCategoryRepository.findByTeamId(teamId);
        QuizSet quizSet = new QuizSet();
        quizSet.setTeamCategory(team);
        quizSetRepository.save(quizSet);

        List<PlayerInQuizSet> quizSetPlayers = new ArrayList<>();
        for (int i = 0; i < selectedPlayers.size(); i++) {
            PlayerInQuizSet quizSetPlayer = createPlayerInQuizSet(quizSet, selectedPlayers.get(i), i + 1);
            quizSetPlayers.add(quizSetPlayer);
            quizSet.addPlayerInQuizSet(quizSetPlayer);
        }

        playerInQuizSetRepository.saveAll(quizSetPlayers);

        return quizSet.getQuizSetId();
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

    private List<QuizDto> convertToQuizDtos(Long quizSetId, List<Players> selectedPlayers) {
        return selectedPlayers.stream()
                .map(players ->
                        new QuizDto(quizSetId, players.getImageUrl(), players.getFullName(), players.getFirstName(), players.getMiddleName(), players.getLastName()))
                .collect(Collectors.toList());
    }

    private List<Players> selectRandomPlayers(Set<Players> playersSetByTeamId, int numOfQuestions) {
        List<Players> playersListByTeamId = new ArrayList<>(playersSetByTeamId);
        Collections.shuffle(playersListByTeamId);
        return playersListByTeamId.stream()
                .limit(numOfQuestions)
                .toList();
    }

    private PlayerInQuizSet createPlayerInQuizSet(QuizSet quizSet, Players player, int orderIndex) {
        PlayerInQuizSet quizSetPlayer = new PlayerInQuizSet();
        quizSetPlayer.setQuizSet(quizSet);
        quizSetPlayer.setPlayer(player);
        quizSetPlayer.setOrderIndex(orderIndex);
        return quizSetPlayer;
    }
}