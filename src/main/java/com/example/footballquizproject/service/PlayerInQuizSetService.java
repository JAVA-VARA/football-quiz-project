package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.PlayerInQuizSet;
import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.domain.QuizSet;
import org.springframework.stereotype.Service;

@Service
public class PlayerInQuizSetService {
    public PlayerInQuizSet createPlayerInQuizSet(QuizSet quizSet, Players player, int orderIndex) {
        PlayerInQuizSet quizSetPlayer = new PlayerInQuizSet();
        quizSetPlayer.setQuizSet(quizSet);
        quizSetPlayer.setPlayer(player);
        quizSetPlayer.setOrderIndex(orderIndex);
        return quizSetPlayer;
    }
}
