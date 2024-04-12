package com.example.footballquizproject.controller;

import com.example.footballquizproject.dto.QuizDto;
import com.example.footballquizproject.dto.QuizResultRequestDto;
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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
        resultActions
                .andExpect(status().isOk())
                .andExpect(model().size(1))
                .andExpect(model().attributeExists("quizListSet"));


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
    @Test
    @DisplayName("유저가 맞춘 정답 갯수를 기준으로 별칭을 반환한다_뉴비_0to5")
    void showResult_0to5 () throws  Exception{

        //given 유저가 맞춘 갯수 지정 / 갯수에 따른 별칭 지정
        int correctAnswers = 0;
        final String level = "뉴비";
        final String url = "/result";
        QuizResultRequestDto request = new QuizResultRequestDto(correctAnswers);
        final String requestBody = objectMapper.writeValueAsString(request);

        //when 맞춘 갯수를 controller에 전달
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody));


        //then 반환한 별칭 == given에 지정한 별칭 일치하는지 확인
        resultActions
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attributeExists("correctAnswers"))
                .andExpect(model().attribute("correctAnswers", correctAnswers))
                .andExpect(model().attributeExists("level"))
                .andExpect(model().attribute("level", level));

    }

    @Test
    @DisplayName("유저가 맞춘 정답 갯수를 기준으로 별칭을 반환한다_뉴비_6to10")
    void showResult_6to10 () throws  Exception{

        //given 유저가 맞춘 갯수 지정 / 갯수에 따른 별칭 지정
        int correctAnswers = 10;
        final String level = "패션";
        final String url = "/result";
        QuizResultRequestDto request = new QuizResultRequestDto(correctAnswers);
        final String requestBody = objectMapper.writeValueAsString(request);

        //when 맞춘 갯수를 controller에 전달
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody));

        //then 반환한 별칭 == given에 지정한 별칭 일치하는지 확인
        resultActions
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attributeExists("correctAnswers"))
                .andExpect(model().attribute("correctAnswers", correctAnswers))
                .andExpect(model().attributeExists("level"))
                .andExpect(model().attribute("level", level));
    }

    @Test
    @DisplayName("유저가 맞춘 정답 갯수를 기준으로 별칭을 반환한다_라이트팬_11to15")
    void showResult_11to15 () throws  Exception{

        //given 유저가 맞춘 갯수 지정 / 갯수에 따른 별칭 지정
        int correctAnswers = 15;
        final String level = "라이트팬";
        final String url = "/result";
        QuizResultRequestDto request = new QuizResultRequestDto(correctAnswers);
        final String requestBody = objectMapper.writeValueAsString(request);

        //when 맞춘 갯수를 controller에 전달
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody));

        //then 반환한 별칭 == given에 지정한 별칭 일치하는지 확인
        resultActions
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attributeExists("correctAnswers"))
                .andExpect(model().attribute("correctAnswers", correctAnswers))
                .andExpect(model().attributeExists("level"))
                .andExpect(model().attribute("level", level));

    }
    @Test
    @DisplayName("유저가 맞춘 정답 갯수를 기준으로 별칭을 반환한다_고인물_16to19")
    void showResult_16to19 () throws  Exception{

        //given 유저가 맞춘 갯수 지정 / 갯수에 따른 별칭 지정
        int correctAnswers = 16;
        final String level = "고인물";
        final String url = "/result";
        QuizResultRequestDto request = new QuizResultRequestDto(correctAnswers);
        final String requestBody = objectMapper.writeValueAsString(request);

        //when 맞춘 갯수를 controller에 전달
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody));

        //then 반환한 별칭 == given에 지정한 별칭 일치하는지 확인
        resultActions
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attributeExists("correctAnswers"))
                .andExpect(model().attribute("correctAnswers", correctAnswers))
                .andExpect(model().attributeExists("level"))
                .andExpect(model().attribute("level", level));
    }

    @Test
    @DisplayName("유저가 맞춘 정답 갯수를 기준으로 별칭을 반환한다_썩은물_20")
    void showResult_20 () throws  Exception{

        //given 유저가 맞춘 갯수 지정 / 갯수에 따른 별칭 지정
        int correctAnswers = 20;
        final String level = "썩은물";
        final String url = "/result";
        QuizResultRequestDto request = new QuizResultRequestDto(correctAnswers);
        final String requestBody = objectMapper.writeValueAsString(request);

        //when 맞춘 갯수를 controller에 전달
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody));

        //then 반환한 별칭 == given에 지정한 별칭 일치하는지 확인
        resultActions
                .andExpect(status().isOk())
                .andExpect(view().name("result"))
                .andExpect(model().attributeExists("correctAnswers"))
                .andExpect(model().attribute("correctAnswers", correctAnswers))
                .andExpect(model().attributeExists("level"))
                .andExpect(model().attribute("level", level));

    }

}