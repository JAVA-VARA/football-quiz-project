package com.example.footballquizproject.service;

import com.example.footballquizproject.domain.LevelCategory;
import com.example.footballquizproject.repository.LevelCategoryRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class LevelCategoryServiceTest {

    @InjectMocks
    private LevelCategoryService levelCategoryService;

    @Mock
    private LevelCategoryRepository levelCategoryRepository;

    @ParameterizedTest
    @CsvSource({
            "3, 뉴비",
            "6, 패션",
            "8, 라이트 팬",
            "10, 그 자체"
    })
    void getLevelByUserCorrectAnswers(int correctAnswers, String level) {

        LevelCategory testLevel = new LevelCategory();
        testLevel.setLevels(level);

        //given
        when(levelCategoryRepository.findByMinCorrectAnswersLessThanEqualAndMaxCorrectAnswersGreaterThanEqual(correctAnswers,correctAnswers)).thenReturn(testLevel);

        //when
        LevelCategory levelCategory =  levelCategoryService.getLevelByUserCorrectAnswers(correctAnswers);

        //then
        assertNotNull(levelCategory);
        assertEquals(level, levelCategory.getLevels());
    }
}