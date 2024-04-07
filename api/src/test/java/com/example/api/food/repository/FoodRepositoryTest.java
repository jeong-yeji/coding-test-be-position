package com.example.api.food.repository;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.api.IntegrationTestSupport;
import com.example.api.food.entity.Food;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

class FoodRepositoryTest extends IntegrationTestSupport {

    @Autowired
    private FoodRepository foodRepository;

    @Test
    void findFood() {
        String foodName = "꿩불고기";
        String researchYear = "2019";
        String makerName = "충주";
        String foodCode = "D000006";

        Optional<Food> food = foodRepository.findByFoodNameAndResearchYearAndMakerNameAndFoodCode(
            foodName, researchYear, makerName, foodCode);

        assertTrue(food.isPresent());
        assertEquals(1L, food.get().getId());
    }

    @Test
    void findNotExistingFood() {
        String foodName = "음식";
        String researchYear = "1234";
        String makerName = "서울";
        String foodCode = "ABCDEFG";

        Optional<Food> food = foodRepository.findByFoodNameAndResearchYearAndMakerNameAndFoodCode(
            foodName, researchYear, makerName, foodCode);

        assertTrue(food.isEmpty());
    }

    @Test
    void getFood() {
        String foodCode = "D000006";

        Optional<Food> food = foodRepository.findByFoodCode(foodCode);

        assertTrue(food.isPresent());
        assertEquals(1L, food.get().getId());
    }

    @Test
    void getNotExistingFood() {
        String foodCode = "ABCDEFG";

        Optional<Food> food = foodRepository.findByFoodCode(foodCode);

        assertTrue(food.isEmpty());
    }

    @Transactional
    @Test
    void deleteFood() {
        String foodCode = "D000006";

        foodRepository.deleteByFoodCode(foodCode);

        Optional<Food> food = foodRepository.findByFoodCode(foodCode);
        assertTrue(food.isEmpty());
    }

    @Transactional
    @Test
    void insertFood() {
        Food food = Food.builder()
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

        Food savedFood = foodRepository.save(food);

        Optional<Food> foundFood = foodRepository.findByFoodCode(food.getFoodCode());
        assertEquals(food.getFoodCode(), savedFood.getFoodCode());
        assertEquals(food.getFoodCode(), foundFood.get().getFoodCode());

    }

}
