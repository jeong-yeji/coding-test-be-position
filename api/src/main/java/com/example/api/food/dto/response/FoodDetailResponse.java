package com.example.api.food.dto.response;

import com.example.api.food.entity.Food;
import lombok.Builder;

@Builder
public record FoodDetailResponse(
    Long id,
    String food_cd,
    String group_name,
    String food_name,
    String research_year,
    String maker_name,
    String ref_name,
    String serving_size,
    String calorie,
    String carbohydrate,
    String protein,
    String province,
    String sugars,
    String salt,
    String cholesterol,
    String saturated_fatty_acids,
    String trans_fat) {

    public static FoodDetailResponse of(Food food
    ) {
        return FoodDetailResponse.builder()
            .id(food.getId())
            .food_cd(food.getFoodCode())
            .group_name(food.getGroupName())
            .food_name(food.getFoodName())
            .research_year(food.getResearchYear())
            .maker_name(food.getMakerName())
            .ref_name(food.getRefName())
            .serving_size(food.getServingSize())
            .calorie(food.getEnergy())
            .carbohydrate(food.getCarbohydrate())
            .protein(food.getProtein())
            .province(food.getFat())
            .sugars(food.getTotalSugars())
            .salt(food.getSodium())
            .cholesterol(food.getCholesterol())
            .saturated_fatty_acids(food.getTotalSaturatedFattyAcid())
            .trans_fat(food.getTransFattyAcids())
            .build();
    }
}
