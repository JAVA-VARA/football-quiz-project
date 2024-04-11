package com.example.footballquizproject.controller;

import com.example.footballquizproject.dto.QuizDto;
import com.example.footballquizproject.service.QuizService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("QuizApiControllerTest")
class QuizApiControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Mock
    Model model;

    @Mock
    QuizService quizService;

    @InjectMocks
    QuizApiController quizApiController;

    @Test
    @DisplayName("TEAM 기준으로 랜덤 문제 20개를 생성한다")
    void showQuizTest() throws Exception{

        //given
        final String url = "/quiz";
        final String teamName = "아틀레티코 마드리드";

        //when
        ResultActions resultActions =
                mockMvc.perform(MockMvcRequestBuilders.get(url)
                        .param("teamName", teamName)
                        .contentType(MediaType.APPLICATION_JSON)
                );

        //then
        resultActions.andExpect(status().isOk());
    }

    @Test
    @DisplayName("TEAM 기준으로 랜덤 문제 20개를 생성한다")
    void showQuiz_ReturnsQuizPageWithQuizList() throws Exception{

        //given
        List<QuizDto> mockQuizList = new ArrayList<>();
        mockQuizList.add(new QuizDto("image1.jpg", "Player1"));
        mockQuizList.add(new QuizDto("image2.jpg", "Player2"));

        when(quizService.pick20PlayersByTeamName("TeamName")).thenReturn(mockQuizList);

        // when
        String viewName = quizApiController.showQuiz("TeamName", model);

        // then
        assertEquals("quiz", viewName);
        verify(model).addAttribute("quizListSet", mockQuizList);

    }

}