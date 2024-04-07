package com.example.api.food.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import com.example.api.IntegrationTestSupport;
import com.example.api.food.dto.response.FoodDetailResponse;
import com.example.api.global.exception.ErrorCode;
import com.example.api.global.exception.RestApiException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

class FoodServiceTest extends IntegrationTestSupport {

    @Autowired
    private FoodService foodService;

    @Test
    void findFood() {
        String foodName = "꿩불고기";
        String researchYear = "2019";
        String makerName = "충주";
        String foodCode = "D000006";

        FoodDetailResponse response = foodService.findFood(foodName, researchYear, makerName,
            foodCode);

        assertThat(response)
            .extracting("id",
                "food_cd",
                "group_name",
                "food_name",
                "research_year",
                "maker_name",
                "ref_name",
                "serving_size",
                "calorie",
                "carbohydrate",
                "protein",
                "province",
                "sugars",
                "salt",
                "cholesterol",
                "saturated_fatty_acids",
                "trans_fat")
            .containsExactly(1L,
                "D000006",
                "육류구이",
                "꿩불고기",
                "2019",
                "충주",
                "외식영양성분자료집 통합본(20122017년)",
                "500",
                "368.8",
                "39.7",
                "33.5",
                "8.5",
                "16.9",
                "1264.31",
                "106.18",
                "1.9",
                "0.1");
    }

    @Test
    void findNotExistingFood() {
        String foodName = "음식";
        String researchYear = "1234";
        String makerName = "서울";
        String foodCode = "ABCDEFG";

        assertThatThrownBy(() -> foodService.findFood(foodName, researchYear, makerName, foodCode))
            .isInstanceOf(RestApiException.class)
            .hasMessage(ErrorCode.FOOD_NOT_FOUND.getMessage());
    }

    @Test
    void getFood() {
        String foodCode = "D000006";

        FoodDetailResponse response = foodService.getFood(foodCode);

        assertThat(response)
            .extracting("id",
                "food_cd",
                "group_name",
                "food_name",
                "research_year",
                "maker_name",
                "ref_name",
                "serving_size",
                "calorie",
                "carbohydrate",
                "protein",
                "province",
                "sugars",
                "salt",
                "cholesterol",
                "saturated_fatty_acids",
                "trans_fat")
            .containsExactly(1L,
                "D000006",
                "육류구이",
                "꿩불고기",
                "2019",
                "충주",
                "외식영양성분자료집 통합본(20122017년)",
                "500",
                "368.8",
                "39.7",
                "33.5",
                "8.5",
                "16.9",
                "1264.31",
                "106.18",
                "1.9",
                "0.1");
    }

    @Test
    void getNotExistingFood() {
        String foodCode = "ABCDEFG";
        assertThatThrownBy(() -> foodService.getFood(foodCode))
            .isInstanceOf(RestApiException.class)
            .hasMessage(ErrorCode.FOOD_NOT_FOUND.getMessage());
    }

    @Transactional
    @Test
    void deleteFood() {
        String foodCode = "D000006";
        String deletedFood = foodService.deleteFood(foodCode);
        assertEquals(foodCode, deletedFood);
    }

    @Transactional
    @Test
    void deleteNotExistingFood() {
        String foodCode = "ABCDEFG";
        assertThatThrownBy(() -> foodService.deleteFood(foodCode))
            .isInstanceOf(RestApiException.class)
            .hasMessage(ErrorCode.FOOD_NOT_FOUND.getMessage());
    }


}
