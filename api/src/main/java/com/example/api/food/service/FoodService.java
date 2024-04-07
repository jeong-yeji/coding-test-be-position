package com.example.api.food.service;

import com.example.api.food.dto.response.FoodDetailResponse;
import com.example.api.food.entity.Food;
import com.example.api.food.repository.FoodRepository;
import com.example.api.global.exception.ErrorCode;
import com.example.api.global.exception.RestApiException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
public class FoodService {

    private final FoodRepository foodRepository;

    public FoodDetailResponse findFood(
        String foodName, String researchYear, String makerName, String foodCode) {
        Optional<Food> food = foodRepository.findByFoodNameAndResearchYearAndMakerNameAndFoodCode(
            foodName, researchYear, makerName, foodCode);
        food.orElseThrow(() -> new RestApiException(ErrorCode.FOOD_NOT_FOUND));
        return FoodDetailResponse.of(food.get());
    }

    public FoodDetailResponse getFood(String foodCode) {
        Optional<Food> food = foodRepository.findByFoodCode(foodCode);
        food.orElseThrow(() -> new RestApiException(ErrorCode.FOOD_NOT_FOUND));
        return FoodDetailResponse.of(food.get());
    }

    @Transactional
    public String deleteFood(String foodCode) {
        foodRepository.findByFoodCode(foodCode)
            .orElseThrow(() -> new RestApiException(ErrorCode.FOOD_NOT_FOUND));
        foodRepository.deleteByFoodCode(foodCode);
        return foodCode;
    }
}
