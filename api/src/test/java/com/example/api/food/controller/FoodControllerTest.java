package com.example.api.food.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.api.ControllerTestSupport;
import com.example.api.food.dto.request.FoodCreateRequest;
import com.example.api.food.dto.request.FoodUpdateRequest;
import com.example.api.food.dto.response.FoodDetailResponse;
import com.example.api.food.service.FoodService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

class FoodControllerTest extends ControllerTestSupport {

    @MockBean
    private FoodService foodService;

    @Test
    void foodSearchApi() throws Exception {
        String foodName = "꿩불고기";
        String researchYear = "2019";
        String makerName = "충주";
        String foodCode = "D000006";
        given(foodService.findFood(foodName, researchYear, makerName, foodCode))
            .willReturn(FoodDetailResponse.builder().build());

        mockMvc.perform(
                get("/api/v1/foods")
                    .param("food_name", foodName)
                    .param("research_year", researchYear)
                    .param("maker_name", makerName)
                    .param("food_code", foodCode)
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code").value("200"))
            .andExpect(jsonPath("$.status").value("OK"))
            .andExpect(jsonPath("$.message").value("OK"))
            .andExpect(jsonPath("$.data").exists());
    }

    @Test
    void readFood() throws Exception {
        String foodCode = "D000006";
        given(foodService.getFood(anyString()))
            .willReturn(FoodDetailResponse.builder().build());

        mockMvc.perform(
                get("/api/v1/foods/{}", foodCode)
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code").value("200"))
            .andExpect(jsonPath("$.status").value("OK"))
            .andExpect(jsonPath("$.message").value("OK"))
            .andExpect(jsonPath("$.data").exists());
    }

    @Test
    void removeFood() throws Exception {
        String foodCode = "D000006";
        given(foodService.deleteFood(anyString()))
            .willReturn(anyString());

        mockMvc.perform(
                delete("/api/v1/foods/{}", foodCode)
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code").value("200"))
            .andExpect(jsonPath("$.status").value("OK"))
            .andExpect(jsonPath("$.message").value("식품 정보를 삭제했습니다."))
            .andExpect(jsonPath("$.data").isString());
    }

    @Test
    void createFood() throws Exception {
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

        given(foodService.insertFood(eq(request)))
            .willReturn(request.foodCode());

        mockMvc.perform(
                post("/api/v1/foods")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code").value(HttpStatus.CREATED.value()))
            .andExpect(jsonPath("$.status").value(HttpStatus.CREATED.name()))
            .andExpect(jsonPath("$.message").value("식품 정보를 생성했습니다."))
            .andExpect(jsonPath("$.data").value(request.foodCode()));
    }

    @Test
    void createFoodWithMissedValue() throws Exception {
        FoodCreateRequest request = FoodCreateRequest.builder()
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

        mockMvc.perform(
                post("/api/v1/foods")
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.code").value(HttpStatus.BAD_REQUEST.value()))
            .andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.name()))
            .andExpect(jsonPath("$.message").value("SAMPLE ID를 입력해주세요."));
    }

    @Test
    void updateFood() throws Exception {
        String foodCode = "D000006";
        FoodUpdateRequest request = FoodUpdateRequest.builder()
            .foodCode(foodCode)
            .foodName("불고기꿩")
            .researchYear("2024")
            .makerName("서울")
            .build();

        given(foodService.updateFood(eq(foodCode), eq(request)))
            .willReturn(foodCode);

        mockMvc.perform(
                put("/api/v1/foods/" + foodCode)
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print())
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.code").value(HttpStatus.OK.value()))
            .andExpect(jsonPath("$.status").value(HttpStatus.OK.name()))
            .andExpect(jsonPath("$.message").value("식품 정보를 수정했습니다."))
            .andExpect(jsonPath("$.data").value(foodCode));
    }

    @Test
    void updateFoodNoFoodCode() throws Exception {
        String foodCode = "D000006";
        FoodUpdateRequest request = FoodUpdateRequest.builder()
            .foodName("불고기꿩")
            .researchYear("2024")
            .makerName("서울")
            .build();

        given(foodService.updateFood(eq(foodCode), eq(request)))
            .willReturn(foodCode);

        mockMvc.perform(
                put("/api/v1/foods/" + foodCode)
                    .content(objectMapper.writeValueAsString(request))
                    .contentType(MediaType.APPLICATION_JSON)
            ).andDo(print())
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.code").value(HttpStatus.BAD_REQUEST.value()))
            .andExpect(jsonPath("$.status").value(HttpStatus.BAD_REQUEST.name()))
            .andExpect(jsonPath("$.message").value("식품코드를 입력해주세요."));
    }
}
