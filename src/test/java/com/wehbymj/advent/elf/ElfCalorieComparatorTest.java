package com.wehbymj.advent.elf;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ElfCalorieComparatorTest {


    @Test
    void shouldSortElfCollectionByTotalAmountOfCalories(){
        ElfCalorieComparator calorieComparator = new ElfCalorieComparator();
        List<Elf> elfs = createElfsForTest();
        final Elf elfCarringTheMostCalories = Collections.max(elfs, calorieComparator);
        assertEquals(elfs.get(2), elfCarringTheMostCalories);

    }





    private List<Elf> createElfsForTest(){
        List<Elf> elfs = new ArrayList<>();

        List<Food> foods = new ArrayList<>();
        foods.add(Food.builder().name("Ham").calories(70).build());
        foods.add(Food.builder().name("Water").calories(0).build());
        Elf anElf = new Elf("Nipper Sugar-Socks", foods);
        elfs.add(anElf);

        List<Food> foodsTwo = new ArrayList<>();
        foodsTwo.add(Food.builder().name("Turkey").calories(60).build());
        foodsTwo.add(Food.builder().name("Gravey").calories(110).build());
        Elf anotherElf = new Elf("Happy Angel-Eyes", foodsTwo);
        elfs.add(anotherElf);

        List<Food> foodsThree = new ArrayList<>();
        foodsThree.add(Food.builder().name("Pumpkin Pie").calories(600).build());
        foodsThree.add(Food.builder().name("Ice Cream").calories(330).build());
        Elf anotherOtherElf = new Elf("Tiny Snowballs", foodsThree);
        elfs.add(anotherOtherElf);

        return elfs;
    }
}
