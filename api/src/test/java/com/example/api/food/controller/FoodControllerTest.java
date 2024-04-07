package com.example.api.food.controller;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.api.ControllerTestSupport;
import com.example.api.food.dto.response.FoodDetailResponse;
import com.example.api.food.service.FoodService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
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

}
