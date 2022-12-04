package com.wehbymj.advent.elf;

import java.util.Comparator;

public class ElfCalorieComparator implements Comparator<Elf> {

    public int compare(Elf a, Elf b){
        return a.getCaloriesCarried() - b.getCaloriesCarried();
    }

}
