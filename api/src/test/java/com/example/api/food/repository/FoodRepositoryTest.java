package com.example.api.food.repository;

import static org.assertj.core.api.FactoryBasedNavigableListAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.api.IntegrationTestSupport;
import com.example.api.food.entity.Food;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

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
}
