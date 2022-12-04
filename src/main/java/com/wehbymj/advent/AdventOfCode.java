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

        Elf elfCarryingTheMostCalories = Collections.max(iterableToCollection(elfs), new ElfCalorieComparator());
        System.out.println("Elf carrying the most calories: " + elfCarryingTheMostCalories);
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
