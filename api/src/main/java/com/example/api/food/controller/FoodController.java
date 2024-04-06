package com.example.api.food.controller;

import com.example.api.food.dto.response.FoodDetailResponse;
import com.example.api.food.service.FoodService;
import com.example.api.global.dto.ApiResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/foods")
@RequiredArgsConstructor
@Slf4j
public class FoodController {

    private final FoodService foodService;

    @GetMapping
    public ApiResponse<FoodDetailResponse> searchFood(
        @RequestParam(value = "food_name", required = true) String foodName,
        @RequestParam(value = "research_year", required = true) String researchYear,
        @RequestParam(value = "maker_name", required = true) String makerName,
        @RequestParam(value = "food_code", required = true) String foodCode) {
        FoodDetailResponse food = foodService.findFood(foodName, researchYear, makerName, foodCode);
        return ApiResponse.ok(food);
    }

}
