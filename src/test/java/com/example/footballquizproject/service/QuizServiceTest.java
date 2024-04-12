package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.repository.PlayersRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("QuizServiceTest")
class QuizServiceTest {
    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    PlayersRepository playersRepository;

    @Test
    @DisplayName("팀을 기준 랜덤으로 n명의 선수 사진 URL 과 이름을 가져온다.")
    void testPick20PlayersByTeamName(){
        //GIVEN
        String teamName = "아틀레티코 마드리드";

        //WHEN
        List<Players> players = playersRepository.findRandomPlayersByTeamName(teamName);

        //THEN
        assertEquals(players.size(), 2);
        assertThat(players.get(0).getTeam().getTeamName()).isEqualTo(teamName);
    }
}