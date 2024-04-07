package com.example.api.food.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.api.IntegrationTestSupport;
import com.example.api.food.dto.request.FoodCreateRequest;
import com.example.api.food.dto.request.FoodUpdateRequest;
import com.example.api.food.dto.response.FoodDetailResponse;
import com.example.api.food.entity.Food;
import com.example.api.food.repository.FoodRepository;
import com.example.api.global.exception.ErrorCode;
import com.example.api.global.exception.RestApiException;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

class FoodServiceTest extends IntegrationTestSupport {

    @Autowired
    private FoodService foodService;

    @Autowired
    private FoodRepository foodRepository;

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

    @Transactional
    @Test
    void insertFood() {
        FoodCreateRequest request = FoodCreateRequest.builder()
            .sampleId("SAMPLEAB12")
            .foodCode("AB12")
            .dbGroup("음식")
            .product("품목대표")
            .foodName("떡볶이")
            .researchYear("2024")
            .makerName("동대문엽기떡볶이")
            .collectionTime("평균")
            .foodGroup("볶음류")
            .groupName("떡볶이류")
            .servingSize("500")
            .servingSizeUnit("g")
            .refName("식약처('24)")
            .organization("식품의약품안전처")
            .build();

        String savedFoodCode = foodService.insertFood(request);

        assertEquals(request.foodCode(), savedFoodCode);
    }

    @Transactional
    @Test
    void insertExistFoodCode() {
        FoodCreateRequest request = FoodCreateRequest.builder()
            .sampleId("SAMPLEAB12")
            .foodCode("D000006")
            .dbGroup("음식")
            .product("품목대표")
            .foodName("떡볶이")
            .researchYear("2024")
            .makerName("동대문엽기떡볶이")
            .collectionTime("평균")
            .foodGroup("볶음류")
            .groupName("떡볶이류")
            .servingSize("500")
            .servingSizeUnit("g")
            .refName("식약처('24)")
            .organization("식품의약품안전처")
            .build();

        assertThatThrownBy(() -> foodService.insertFood(request))
            .isInstanceOf(RestApiException.class)
            .hasMessage(ErrorCode.FOOD_ALREADY_EXIST.getMessage());
    }

    @Transactional
    @Test
    void updateFood() {
        String foodCode = "D000006";
        FoodUpdateRequest request = FoodUpdateRequest.builder()
            .foodCode(foodCode)
            .foodName("불고기꿩")
            .researchYear("2024")
            .makerName("서울")
            .build();

        String updateFoodCode = foodService.updateFood(foodCode, request);

        Optional<Food> updatedFood = foodRepository.findByFoodCode(updateFoodCode);
        assertTrue(updatedFood.isPresent());
        assertThat(updatedFood.get())
            .extracting("foodName", "researchYear", "makerName")
            .containsExactly("불고기꿩", "2024", "서울");
    }

    @Transactional
    @Test
    void updateFoodWithWrongFoodCode() {
        String foodCode = "D000006";
        FoodUpdateRequest request = FoodUpdateRequest.builder()
            .foodCode("ABCD")
            .foodName("불고기꿩")
            .researchYear("2024")
            .makerName("서울")
            .build();

        assertThatThrownBy(() -> foodService.updateFood(foodCode, request))
            .isInstanceOf(RestApiException.class)
            .hasMessage(ErrorCode.BAD_REQUEST.getMessage());
    }

    @Transactional
    @Test
    void updateNotExistingFood() {
        String foodCode = "ABCDE";
        FoodUpdateRequest request = FoodUpdateRequest.builder()
            .foodCode(foodCode)
            .foodName("불고기꿩")
            .researchYear("2024")
            .makerName("서울")
            .build();

        assertThatThrownBy(() -> foodService.updateFood(foodCode, request))
            .isInstanceOf(RestApiException.class)
            .hasMessage(ErrorCode.FOOD_NOT_FOUND.getMessage());
    }

    @Transactional
    @Test
    void updateFoodWithNoFoodCode() {
        String foodCode = "D000006";
        FoodUpdateRequest request = FoodUpdateRequest.builder()
            .researchYear("2024")
            .makerName("서울")
            .collectionTime("평균")
            .build();

        assertThatThrownBy(() -> foodService.updateFood(foodCode, request))
            .isInstanceOf(RestApiException.class)
            .hasMessage(ErrorCode.BAD_REQUEST.getMessage());
    }
}
