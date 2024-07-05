package com.example.footballquizproject.controller;

import com.example.footballquizproject.domain.LeagueCategory;
import com.example.footballquizproject.domain.TeamCategory;
import com.example.footballquizproject.dto.QuizDto;
import com.example.footballquizproject.dto.QuizResultRequestDto;
import com.example.footballquizproject.repository.LeagueCategoryRepository;
import com.example.footballquizproject.repository.TeamCategoryRepository;
import com.example.footballquizproject.service.QuizService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("QuizApiControllerTest")
class QuizApiControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private LeagueCategoryRepository leagueCategoryRepository;

    @Autowired
    private TeamCategoryRepository teamCategoryRepository;

    @Autowired
    private QuizService quizService;


    @Test
    @DisplayName("게임을 선택하면 리그를 불러온다.")
    void getLeagueListTest() throws Exception {
        //given
        final String url = "/quizzes/game-category/1";
        final int numberOfLeagues = leagueCategoryRepository.findAll().size();
        //when
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(url));
        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(model().attribute("leagueList", Matchers.hasSize(numberOfLeagues)));
    }

    @Test
    @DisplayName("선택한 리그에 맞는 팀들을 불러올 수 있다.")
    void getTeamByLeague() throws Exception {
        //given
        final long leagueId = 1L;
        LeagueCategory leagueCategory = leagueCategoryRepository.findLeagueCategoryByLeagueId(leagueId);
        final String url = "/quizzes/league-category/" + leagueId;
        final int numberOfTeamsByLeague = teamCategoryRepository.findTeamCategoriesByLeague(leagueCategory).size();
        //WHEN
        ResultActions resultActions = mockMvc.perform(MockMvcRequestBuilders.get(url));

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(model().attribute("teamList", Matchers.hasSize(numberOfTeamsByLeague)));

    }

    @Test
    @DisplayName("TEAM 기준 랜덤으로 문제를 생성한다.")
    void givenTeamId_whenCreateQuizSet_thenReturnQuizPage() throws Exception {
        //given
        Long teamId = 1L;

        //when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.get("/quizzes/team-category/{teamId}", teamId));

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(view().name("new-quiz"))

                .andExpect(model().attributeExists("quizListSet"))
                .andExpect(model().attribute("quizListSet", Matchers.hasSize(10)))

                .andExpect(model().attributeExists("teamId"));
    }

    @Test
    void save_and_show_ResultTest() throws Exception {

        //given
        final String url = "/quizzes/result";
        //quizSet 만들고 quizId 리턴해서 requestdto에 넣어주기
        Long teamId = 1L;
        TeamCategory teamCategory = teamCategoryRepository.findByTeamId(teamId);
        String teamName = teamCategory.getTeamName();

        List<QuizDto> quizSet = quizService.createQuizSet(teamId, 10);
        Long quizId = quizSet.get(0).getQuizId();

        QuizResultRequestDto requestDto = QuizResultRequestDto.builder()
                .quizId(quizId)
                .categoryId(1L)
                .teamId(teamId)
                .countCorrectAnswers(5)
                .userAnswers(List.of("Answer1", "Answer2", "Answer3", "Answer4", "Answer5"))
                .correctAnswers(List.of("Correct1", "Correct2", "Correct3", "Correct4", "Correct5"))
                .isCorrectAnswers(List.of(true, true, true, true, true))
                .build();

        final String requestBody = objectMapper.writeValueAsString(requestDto);

        //when
        ResultActions resultActions = mockMvc.perform(
                MockMvcRequestBuilders.post(url)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(requestBody));

        //then
        resultActions
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("result"))
                .andExpect(model().attribute("result", Matchers.hasProperty("ranking", Matchers.is(1))))
                .andExpect(model().attribute("result", Matchers.hasProperty("teamName", Matchers.is(teamName))))
                .andExpect(model().attribute("result", Matchers.hasProperty("correctAnswers", Matchers.is(5))));
    }


}