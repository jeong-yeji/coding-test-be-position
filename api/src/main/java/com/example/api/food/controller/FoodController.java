package com.example.api.food.controller;

import com.example.api.food.dto.request.FoodCreateRequest;
import com.example.api.food.dto.request.FoodUpdateRequest;
import com.example.api.food.dto.response.FoodDetailResponse;
import com.example.api.food.service.FoodService;
import com.example.api.global.dto.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/foods")
@RequiredArgsConstructor
@Slf4j
@Tag(name = "식품영양성분 API", description = "조리식품과 가공식품, 원재료성 식품에 대한 영양성분 정보를 제공")
public class FoodController {

    private final FoodService foodService;

    @GetMapping
    @Operation(summary = "Search API", description = "식품이름, 연도, 지역/제조사, 식품코드가 일치하는 영양성분 정보 검색")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "요청을 성공적으로 처리했습니다.", content = @Content(schema = @Schema(implementation = FoodDetailResponse.class),mediaType = "application/json")),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json")),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "해당 식품영양성분 정보가 존재하지 않습니다.", content = @Content(mediaType = "application/json")),
    })
    @Parameters({
        @Parameter(name = "food_name", description = "식품이름", example = "꿩불고기", required = true, in = ParameterIn.QUERY),
        @Parameter(name = "research_year", description = "연도", example = "2019", required = true, in = ParameterIn.QUERY),
        @Parameter(name = "maker_name", description = "지역/제조사", example = "충주", required = true, in = ParameterIn.QUERY),
        @Parameter(name = "food_code", description = "식품코드", example = "D000006", required = true, in = ParameterIn.QUERY)
    })
    public ApiResponse<FoodDetailResponse> searchFood(
        @RequestParam(value = "food_name", required = true) String foodName,
        @RequestParam(value = "research_year", required = true) String researchYear,
        @RequestParam(value = "maker_name", required = true) String makerName,
        @RequestParam(value = "food_code", required = true) String foodCode) {
        FoodDetailResponse food = foodService.findFood(foodName, researchYear, makerName, foodCode);
        return ApiResponse.ok(food);
    }

    @GetMapping("/{foodCode}")
    @Operation(summary = "식품영양정보 확인", description = "식품코드가 일치하는 영양성분 정보 제공")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "요청을 성공적으로 처리했습니다.", content = @Content(schema = @Schema(implementation = FoodDetailResponse.class), mediaType = "application/json")),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json")),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "해당 식품영양성분 정보가 존재하지 않습니다.", content = @Content(mediaType = "application/json")),
    })
    @Parameter(name = "foodCode", description = "식품코드", example = "D000006", required = true, in = ParameterIn.PATH)
    public ApiResponse<FoodDetailResponse> readFood(@PathVariable String foodCode){
        FoodDetailResponse food = foodService.getFood(foodCode);
        return ApiResponse.ok(food);
    }

    @DeleteMapping("/{foodCode}")
    @Operation(summary = "식품영양정보 삭제", description = "식품코드가 일치하는 영양성분 정보 삭제")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "식품 정보를 삭제했습니다.", content = @Content(mediaType = "application/json")),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json")),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "해당 식품영양성분 정보가 존재하지 않습니다.", content = @Content(mediaType = "application/json")),
    })
    @Parameter(name = "foodCode", description = "식품코드", example = "D000006", required = true, in = ParameterIn.PATH)
    public ApiResponse<String> removeFood(@PathVariable String foodCode){
        String deletedFoodCode = foodService.deleteFood(foodCode);
        return ApiResponse.of(HttpStatus.OK, "식품 정보를 삭제했습니다.", deletedFoodCode);
    }

    @PostMapping
    @Operation(summary = "식품영양정보 생성", description = "새로운 식품 영양성분 정보 생성")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "식품 정보를 생성했습니다.", content = @Content(mediaType = "application/json")),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json")),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "동일한 식품코드가 존재합니다.", content = @Content(mediaType = "application/json")),
    })
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(
        examples = {
            @ExampleObject(name = "예시", description = "식품영양정보 생성 예시", value = """
                    {
                        "sampleId": "D000006-94-AVG",
                        "foodCode": "D000006",
                        "dbGroup": "음식",
                        "product": "품목대표",
                        "foodName": "꿩불고기",
                        "researchYear": "2019",
                        "makerName": "충주",
                        "collectionTime": "평균",
                        "foodGroup": "구이류",
                        "groupName": "육류구이",
                        "servingSize": "500",
                        "servingSizeUnit": "g",
                        "totalSizeG": "-",
                        "totalSizeMl": "-",
                        "energy": "368.8",
                        "water": "412.6",
                        "protein": "33.5",
                        "fat": "8.5",
                        "carbohydrate": "39.7",
                        "totalSugars": "16.9",
                        "sucrose": "7.2",
                        "glucose": "2.8",
                        "fructose": "2.8",
                        "lactose": "0.7",
                        "maltose": "3.5",
                        "totalDietaryFiber": "9.8",
                        "calcium": "105.61",
                        "ironMg": "-",
                        "ironUg": "4",
                        "magnesium": "85.39",
                        "phosphorus": "458.05",
                        "potassium": "1243.12",
                        "sodium": "1264.31",
                        "zinc": "3.99",
                        "copper": "0.32",
                        "manganese": "0.68",
                        "selenium": "47.55",
                        "retinol": "0",
                        "betaCarotene": "1424.58",
                        "vitaminD3": "-",
                        "tocopherol": "8.73",
                        "tocotrienol": "0.06",
                        "vitaminB1": "0",
                        "vitaminB2": "0.33",
                        "niacin": "3.61",
                        "folate": "63.13",
                        "vitaminB12": "0",
                        "vitaminC": "2.99",
                        "totalAminoAcid": "-",
                        "isoleucine": "1284.38",
                        "leucine": "2328.6",
                        "lysine": "2484.75",
                        "methionine": "645.19",
                        "phenylalanine": "1274.93",
                        "threonine": "1410.84",
                        "valine": "1367.69",
                        "histidine": "848.54",
                        "arginine": "2205.58",
                        "tyrosine": "919.81",
                        "cysteine": "276.5",
                        "alanine": "1642.38",
                        "asparticAcid": "2781.77",
                        "glutamicAcid": "4784.61",
                        "glycine": "1419.92",
                        "proline": "1092.3",
                        "serine": "1264.96",
                        "cholesterol": "106.18",
                        "totalSaturatedFattyAcid": "1.9",
                        "butyricAcid": "0",
                        "caproicAcid": "0",
                        "caprylicAcid": "0",
                        "capricAcid": "0",
                        "lauricAcid": "0.01",
                        "myristicAcid": "0.03",
                        "palmiticAcid": "1.28",
                        "stearicAcid": "0.53",
                        "arachidicAcid": "0.03",
                        "myristoleicAcid": "0",
                        "palmitoleicAcid": "0.08",
                        "oleicAcid": "2.31",
                        "vaccenicAcid": "0.11",
                        "gadoleicAcid": "0.03",
                        "linoleicAcid": "3.24",
                        "alphaLinolenicAcid": "0.66",
                        "gammaLinolenicAcid": "0.02",
                        "acosadienoicAcid": "0.01",
                        "arachidonicAcid": "0",
                        "eicosatrienoicAcid": "0.14",
                        "eicosapentaenoicAcid": "0",
                        "dokosapentaenoicAcid": "0",
                        "dokosahexaenoicAcid": "0.02",
                        "transFattyAcids": "0.1",
                        "transoleicAcid": "0.02",
                        "transLinoleicAcid": "0.05",
                        "transLinolenicAcid": "0",
                        "does": "5.8",
                        "caffeine": "-",
                        "refName": "외식영양성분자료집 통합본(2012-2017년)",
                        "organization": "식품의약품안전"
                    }
                """)
        }
    ))
    public ApiResponse<String> createFood(@Valid @RequestBody FoodCreateRequest request) {
        String createdFoodCode = foodService.insertFood(request);
        return ApiResponse.of(HttpStatus.CREATED, "식품 정보를 생성했습니다.", createdFoodCode);
    }

    @PutMapping("/{foodCode}")
    @Operation(summary = "식품영양정보 수정", description = "식품 영양성분 정보 수정")
    @ApiResponses(value = {
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "식품 정보를 수정했습니다.", content = @Content(mediaType = "application/json")),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "400", description = "잘못된 요청입니다.", content = @Content(mediaType = "application/json")),
        @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "404", description = "해당 식품영양성분 정보가 존재하지 않습니다.", content = @Content(mediaType = "application/json")),
    })
    @Parameter(name = "foodCode", description = "식품코드", example = "D000006", required = true, in = ParameterIn.PATH)
    @io.swagger.v3.oas.annotations.parameters.RequestBody(content = @Content(
        examples = {
            @ExampleObject(name = "예시", description = "식품영양정보 수정 예시", value = """
                    {
                        "sampleId": "D000006-94-AVG",
                        "foodCode": "D000006",
                        "dbGroup": "음식",
                        "product": "품목대표",
                        "foodName": "꿩불고기",
                        "researchYear": "2019",
                        "makerName": "충주",
                        "collectionTime": "평균",
                        "foodGroup": "구이류",
                        "groupName": "육류구이",
                        "servingSize": "500",
                        "servingSizeUnit": "g",
                        "totalSizeG": "-",
                        "totalSizeMl": "-",
                        "energy": "368.8",
                        "water": "412.6",
                        "protein": "33.5",
                        "fat": "8.5",
                        "carbohydrate": "39.7",
                        "totalSugars": "16.9",
                        "sucrose": "7.2",
                        "glucose": "2.8",
                        "fructose": "2.8",
                        "lactose": "0.7",
                        "maltose": "3.5",
                        "totalDietaryFiber": "9.8",
                        "calcium": "105.61",
                        "ironMg": "-",
                        "ironUg": "4",
                        "magnesium": "85.39",
                        "phosphorus": "458.05",
                        "potassium": "1243.12",
                        "sodium": "1264.31",
                        "zinc": "3.99",
                        "copper": "0.32",
                        "manganese": "0.68",
                        "selenium": "47.55",
                        "retinol": "0",
                        "betaCarotene": "1424.58",
                        "vitaminD3": "-",
                        "tocopherol": "8.73",
                        "tocotrienol": "0.06",
                        "vitaminB1": "0",
                        "vitaminB2": "0.33",
                        "niacin": "3.61",
                        "folate": "63.13",
                        "vitaminB12": "0",
                        "vitaminC": "2.99",
                        "totalAminoAcid": "-",
                        "isoleucine": "1284.38",
                        "leucine": "2328.6",
                        "lysine": "2484.75",
                        "methionine": "645.19",
                        "phenylalanine": "1274.93",
                        "threonine": "1410.84",
                        "valine": "1367.69",
                        "histidine": "848.54",
                        "arginine": "2205.58",
                        "tyrosine": "919.81",
                        "cysteine": "276.5",
                        "alanine": "1642.38",
                        "asparticAcid": "2781.77",
                        "glutamicAcid": "4784.61",
                        "glycine": "1419.92",
                        "proline": "1092.3",
                        "serine": "1264.96",
                        "cholesterol": "106.18",
                        "totalSaturatedFattyAcid": "1.9",
                        "butyricAcid": "0",
                        "caproicAcid": "0",
                        "caprylicAcid": "0",
                        "capricAcid": "0",
                        "lauricAcid": "0.01",
                        "myristicAcid": "0.03",
                        "palmiticAcid": "1.28",
                        "stearicAcid": "0.53",
                        "arachidicAcid": "0.03",
                        "myristoleicAcid": "0",
                        "palmitoleicAcid": "0.08",
                        "oleicAcid": "2.31",
                        "vaccenicAcid": "0.11",
                        "gadoleicAcid": "0.03",
                        "linoleicAcid": "3.24",
                        "alphaLinolenicAcid": "0.66",
                        "gammaLinolenicAcid": "0.02",
                        "acosadienoicAcid": "0.01",
                        "arachidonicAcid": "0",
                        "eicosatrienoicAcid": "0.14",
                        "eicosapentaenoicAcid": "0",
                        "dokosapentaenoicAcid": "0",
                        "dokosahexaenoicAcid": "0.02",
                        "transFattyAcids": "0.1",
                        "transoleicAcid": "0.02",
                        "transLinoleicAcid": "0.05",
                        "transLinolenicAcid": "0",
                        "does": "5.8",
                        "caffeine": "-",
                        "refName": "외식영양성분자료집 통합본(2012-2017년)",
                        "organization": "식품의약품안전"
                    }
                """)
        }
    ))
    public ApiResponse<String> updateFood(@PathVariable String foodCode, @Valid @RequestBody FoodUpdateRequest request){
        String deletedFoodCode = foodService.updateFood(foodCode, request);
        return ApiResponse.of(HttpStatus.OK, "식품 정보를 수정했습니다.", deletedFoodCode);
    }

}
