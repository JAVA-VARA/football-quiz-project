package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.PlayerInQuizSet;
import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.QuizSet;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.repository.PlayerInQuizSetRepository;
import com.example.footballquizproject.repository.QuizSetRepository;
import com.example.footballquizproject.repository.TeamCategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuizSetService {

    private final TeamCategoryRepository teamCategoryRepository;
    private final QuizSetRepository quizSetRepository;
    private final PlayerInQuizSetRepository playerInQuizSetRepository;

    private final PlayerInQuizSetService playerInQuizSetService;

    public Long saveQuizSet(Long teamId, List<Players> selectedPlayers) {
        TeamCategory team = teamCategoryRepository.findByTeamId(teamId);

        QuizSet quizSet = new QuizSet();
        quizSet.setTeamCategory(team);

        quizSetRepository.save(quizSet);

        List<PlayerInQuizSet> quizSetPlayers = createPlayerInQuizSet(quizSet, selectedPlayers);

        playerInQuizSetRepository.saveAll(quizSetPlayers);

        return quizSet.getQuizId();
    }

    private List<PlayerInQuizSet> createPlayerInQuizSet(QuizSet quizSet, List<Players> selectedPlayers){
        List<PlayerInQuizSet> quizSetPlayers = new ArrayList<>();
        for (int i = 0; i < selectedPlayers.size(); i++) {
            PlayerInQuizSet quizSetPlayer = playerInQuizSetService.createPlayerInQuizSet(quizSet, selectedPlayers.get(i), i + 1);
            quizSetPlayers.add(quizSetPlayer);
            quizSet.addPlayerInQuizSet(quizSetPlayer);
        }
        return quizSetPlayers;
    }
}
