package com.wehbymj.advent;


import com.wehbymj.advent.elf.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;


public class AdventOfCode {

    public static void main(String[] args){
        dayOne();
    }


    static void dayOne() {
       ElfFile elfFile = new ElfFile("advent-test-data-day1.txt");

       ElfRepository elfRepository = new ElfRepositoryFileImpl(elfFile);
       Iterable<Elf> elfs = elfRepository.findAll();

        Collection<Elf> elfCollection = iterableToCollection(elfs);
        Elf elfCarryingTheMostCalories = Collections.max(elfCollection, new ElfCalorieComparator());
        System.out.println("Elf carrying the most calories: " + elfCarryingTheMostCalories);

        //Part two
        elfCollection.remove(elfCarryingTheMostCalories);
        Elf elfCarryingTheSecondMostCalories = Collections.max(elfCollection, new ElfCalorieComparator());
        System.out.println("Elf carrying the second most calories: " + elfCarryingTheSecondMostCalories);

        elfCollection.remove(elfCarryingTheSecondMostCalories);
        Elf elfCarryingTheThirdMostCalories = Collections.max(elfCollection, new ElfCalorieComparator());
        System.out.println("Elf carrying the third most calories: " + elfCarryingTheThirdMostCalories);


        int totalCalorieCount =  elfCarryingTheMostCalories.getCaloriesCarried()
                                + elfCarryingTheSecondMostCalories.getCaloriesCarried()
                                + elfCarryingTheThirdMostCalories.getCaloriesCarried();
        System.out.println("Total calories carried by the top 3 elfs:" + totalCalorieCount);

    }

    private static <T> Collection<T> iterableToCollection(Iterable<T> iterable)
    {
        Collection<T> collection = new ArrayList<>();
        for (T e: iterable) {
            collection.add(e);
        }
        return collection;
    }

}
