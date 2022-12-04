package com.wehbymj.advent.elf;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElfTest {

    @Test
    void elfShouldHaveNonNullName() {
        String elfName = "Pixie McJingles";
        Elf anElf = new Elf(elfName, new ArrayList<Food>());
        assertEquals(elfName, anElf.getName());
    }

    @Test
    void elfShouldCountFoodCalories(){
        List<Food> foods = new ArrayList<>();
        Food firstFood = Food.builder().name("Chilli Mac").calories(500).build();
        Food secondFood = Food.builder().name("Ham").calories(70).build();
        Food thirdFood = Food.builder().name("Water").calories(0).build();
        foods.add(firstFood);
        foods.add(secondFood);
        foods.add(thirdFood);

        Elf anElf = new Elf("Nipper Sugar-Socks", foods);
        assertEquals(570, anElf.getCaloriesCarried());
    }

    @Test
    void elfShouldBeAbleToAddFoodAfterCreation(){

        List<Food> foods = new ArrayList<>();
        Food firstFood = Food.builder().name("Chilli Mac").calories(1500).build();

        Elf anElf = new Elf("Nipper Sugar-Socks", foods);
        anElf.addFood(firstFood);
        assertEquals(1500, anElf.getCaloriesCarried());
    }

}
