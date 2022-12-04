package com.wehbymj.advent.elf;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {

    @Test
    void foodCalorieShouldNotBeNull(){
        int foodCalories = 100;
        Food aFood = new Food("A Food Name", foodCalories);
        assertEquals(foodCalories, aFood.getCalories());
    }

    @Test
    void foodShouldHaveNonNullName(){
        String foodName = "Chilli Mac";
        Food aFood = new Food(foodName, 500);
        assertEquals(foodName, aFood.getName());
    }
}
