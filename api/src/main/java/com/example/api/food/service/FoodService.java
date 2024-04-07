package com.example.api.food.service;

import com.example.api.food.dto.request.FoodCreateRequest;
import com.example.api.food.dto.response.FoodDetailResponse;
import com.example.api.food.entity.Food;
import com.example.api.food.repository.FoodRepository;
import com.example.api.global.exception.ErrorCode;
import com.example.api.global.exception.RestApiException;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
@Transactional(readOnly = true)
@Slf4j
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

    @Transactional
    public String insertFood(FoodCreateRequest request) {
        if (foodRepository.findByFoodCode(request.foodCode()).isPresent()) {
            throw new RestApiException(ErrorCode.FOOD_ALREADY_EXIST);
        }

        Food food = request.toEntity();
        Food savedFood = foodRepository.save(food);
        return savedFood.getFoodCode();
    }
}
