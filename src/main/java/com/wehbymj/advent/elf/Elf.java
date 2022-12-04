package com.wehbymj.advent.elf;


import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Builder
@RequiredArgsConstructor
@EqualsAndHashCode
public class Elf {
    @NonNull
    @Getter
    private final String name;
    @NonNull
    private final List<Food> foods;

    int getCaloriesCarried() {
        return foods.stream().collect(Collectors.summingInt(Food::getCalories));
    }

    void addFood(Food aFood){
        foods.add(aFood);
    }

    public String toString(){
        return "Elf(name=" + name + ", caloriesCarried=" + getCaloriesCarried() + ")";
    }

}
