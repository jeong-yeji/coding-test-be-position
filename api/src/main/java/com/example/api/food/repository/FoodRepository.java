package com.example.api.food.repository;

import com.example.api.food.entity.Food;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository<Food, Long> {

    Optional<Food> findByFoodNameAndResearchYearAndMakerNameAndFoodCode(
        String foodName, String researchYear, String makerName, String foodCode);

    Optional<Food> findByFoodCode(String foodCode);

    void deleteByFoodCode(String foodCode);
}
