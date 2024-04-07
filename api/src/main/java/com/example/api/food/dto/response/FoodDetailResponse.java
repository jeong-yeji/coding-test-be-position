package com.example.api.food.dto.response;

import com.example.api.food.entity.Food;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

@Builder
@Schema(description = "식품영양정보 확인에 대한 응답")
public record FoodDetailResponse(
    @Schema(description = "번호", example = "1") Long id,
    @Schema(description = "식품코드", example = "D000006") String food_cd,
    @Schema(description = "식품상세분류", example = "육류구이") String group_name,
    @Schema(description = "식품명", example = "꿩불고기") String food_name,
    @Schema(description = "연도", example = "2019") String research_year,
    @Schema(description = "지역/제조사", example = "충주") String maker_name,
    @Schema(description = "자료출처", example = "외식영양성분자료집 통합본(2012-2017년)") String ref_name,
    @Schema(description = "1회 제공량", example = "500") String serving_size,
    @Schema(description = "열량(kcal)(1회제공량당)", example = "368.8") String calorie,
    @Schema(description = "탄수화물(g)(1회제공량당)", example = "39.7") String carbohydrate,
    @Schema(description = "단백질(g)(1회제공량당)", example = "33.5") String protein,
    @Schema(description = "지방(g)(1회제공량당)", example = "8.5") String province,
    @Schema(description = "총당류(g)(1회제공량당)", example = "16.9") String sugars,
    @Schema(description = "나트륨(g)(1회제공량당)", example = "1264.31") String salt,
    @Schema(description = "콜레스테롤(mg)(1회제공량당)", example = "106.18") String cholesterol,
    @Schema(description = "포화지방산(g)(1회제공량당)", example = "1.9") String saturated_fatty_acids,
    @Schema(description = "트랜스지방(g)(1회제공량당)", example = "0.1") String trans_fat) {

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
