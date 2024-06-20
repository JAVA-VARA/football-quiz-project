package com.example.footballquizproject.controller;

import com.example.footballquizproject.domain.LeagueCategory;
import com.example.footballquizproject.dto.QuizResultRequestDto;
import com.example.footballquizproject.repository.LeagueCategoryRepository;
import com.example.footballquizproject.repository.TeamCategoryRepository;
import com.example.footballquizproject.service.QuizService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @Autowired
    LeagueCategoryRepository leagueCategoryRepository;

    @Autowired
    TeamCategoryRepository teamCategoryRepository;

    @InjectMocks
    QuizApiController quizApiController;

    private final Long teamId = 1L;


    @Test
    @DisplayName("게임을 선택하면 리그를 불러온다.")
    void getLeague() throws Exception{
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
    void getTeamByLeague() throws Exception{
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

//    @Test
//    @DisplayName("TEAM 기준으로 랜덤 문제 10개를 생성한다")
//    void showQuizTest() throws Exception{
//
//        //given
//        final String url = "/quizzes/team-category/" + teamId;
//
//        //when
//        ResultActions resultActions =
//                mockMvc.perform(MockMvcRequestBuilders.get(url)
//                );
//
//        //then
//        resultActions
//                .andExpect(status().isOk())
//                .andExpect(model().attribute("teamId", 1L))
//                .andExpect(model().attribute("quizListSet", Matchers.hasSize(10)))
//        ;
//    }
//
//
//    @Test
//    @DisplayName("TEAM 기준으로 랜덤 문제 10개를 생성한다")
//    void showQuiz_ReturnsQuizPageWithQuizList() {
//
//        //given
//        List<QuizDto> mockQuizList = new ArrayList<>();
//        mockQuizList.add(new QuizDto("image1.jpg", "fullname1", "fistname1", "middlename1", "lastname1"));
//        mockQuizList.add(new QuizDto("image2.jpg", "fullname2", "fistname2", "middlename2", "lastname2"));
//
//        when(quizService.pick10PlayersByTeamId(teamId)).thenReturn(mockQuizList);
//
//        // when
//        String viewName = quizApiController.createQuizSet(teamId, model);
//
//        // then
//        assertEquals("quiz", viewName);
//        verify(model).addAttribute("quizListSet", mockQuizList);
//
//    }

    @Test
    @DisplayName("랜덤으로 문제를 생성한다.")
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
                .andExpect(model()
                        .attribute("quizListSet", Matchers.hasSize(10)))
                .andExpect(model().attributeExists("teamId"))
                .andReturn();
    }


    @ParameterizedTest
    @DisplayName("유저가 맞춘 정답 갯수를 기준으로 레벨을 반환한다")
    @CsvSource({
            "3, 뉴비",
            "6, 패션",
            "8, 라이트 팬",
            "10, 그 자체"
    })
    void showResult(int correctAnswers, String level) throws Exception {

        final String url = "/quizzes/result";
        QuizResultRequestDto request = new QuizResultRequestDto(correctAnswers,teamId);
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
                .andExpect(model().attribute("level", Matchers.hasProperty("levels", Matchers.is(level))));
    }

}