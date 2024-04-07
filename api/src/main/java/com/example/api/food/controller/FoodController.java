package com.example.api.food.controller;

import com.example.api.food.dto.request.FoodCreateRequest;
import com.example.api.food.dto.response.FoodDetailResponse;
import com.example.api.food.service.FoodService;
import com.example.api.global.dto.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @GetMapping("/{foodCode}")
    public ApiResponse<FoodDetailResponse> readFood(@PathVariable String foodCode){
        FoodDetailResponse food = foodService.getFood(foodCode);
        return ApiResponse.ok(food);
    }

    @DeleteMapping("/{foodCode}")
    public ApiResponse<String> removeFood(@PathVariable String foodCode){
        String deletedFoodCode = foodService.deleteFood(foodCode);
        return ApiResponse.of(HttpStatus.OK, "식품 정보를 삭제했습니다.", deletedFoodCode);
    }

    @PostMapping
    public ApiResponse<String> createFood(@Valid @RequestBody FoodCreateRequest request) {
        String createdFoodCode = foodService.insertFood(request);
        return ApiResponse.of(HttpStatus.CREATED, "식품 정보를 생성했습니다.", createdFoodCode);
    }

}
