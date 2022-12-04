package com.wehbymj.advent.elf;


import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class ElfRepositoryFileImpl implements ElfRepository{
    @NonNull
    private final ElfFile elfFile;


    @Override
    public Iterable<Elf> findAll() {
        //The "elf" name is based on the index in the file, not ideal
        final List<String> elvesCalories = readInCalorieFile();
        final List<Elf> elfs = new ArrayList<>();

        int currentElfIndex = 0;
        for (int i = 0; i < elvesCalories.size(); i++) {
            String currentLine = elvesCalories.get(i);

            if (isNewLine(currentLine) || i == 0) {
                if(i == 0){
                    List<Food> elfFood = new ArrayList<>();
                    Food aFood = new Food("", Integer.parseInt(currentLine));
                    elfFood.add(aFood);
                    Elf elf = new Elf(Integer.toString(currentElfIndex + 1), elfFood);
                    elfs.add(currentElfIndex, elf);
                }else{
                    currentElfIndex++;
                    List<Food> elfFood = new ArrayList<>();
                    Elf elf = new Elf(Integer.toString(currentElfIndex + 1), elfFood);
                    elfs.add(currentElfIndex, elf);
                }
            }else{
                Elf currentElf = elfs.get(currentElfIndex);
                Food aFood = new Food("", Integer.parseInt(currentLine));
                currentElf.addFood(aFood);
            }
        }
        return elfs;
    }


    private List<String> readInCalorieFile(){
        return elfFile.extractCalories();
    }

    private boolean isNewLine(String valueToTest){
        boolean isNewLine = false;
        String newLineSeparator = System.getProperty("line.separator");
        if(valueToTest.contains(newLineSeparator) || valueToTest.equals("\\r\\n") || valueToTest.trim().equals("")){
            isNewLine = true;
        }
        return isNewLine;
    }
}
