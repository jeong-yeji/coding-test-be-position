package com.example.api.food.repository;

import static org.junit.jupiter.api.Assertions.*;

import com.example.api.IntegrationTestSupport;
import org.springframework.beans.factory.annotation.Autowired;

class FoodRepositoryTest extends IntegrationTestSupport {

    @Autowired
    private FoodRepository foodRepository;

}
