package com.wehbymj.advent.elf;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.*;



class ElfRepositoryFileImplTest {

    @Test
    void elfRepositoryShouldReturnAllElfs(){
        ElfFile mockedElfFile = mock(ElfFile.class);
        when(mockedElfFile.extractCalories()).thenReturn(fakeReadInFileCalorieList());

        ElfRepository elfRepo = new ElfRepositoryFileImpl(mockedElfFile);
        Iterable<Elf> elfs = elfRepo.findAll();

        List<Elf> actualElfList = new ArrayList<>();
        elfs.forEach(actualElfList::add);

        assertThat("List equality", actualElfList, equalTo(expectedElfList()));
    }


    private List<Elf> expectedElfList(){
        List<Food> firstElffoods = new ArrayList<>();
        Food firstFood = Food.builder().name("").calories(1000).build();
        Food secondFood = Food.builder().name("").calories(2000).build();
        Food thirdFood = Food.builder().name("").calories(3000).build();
        firstElffoods.add(firstFood);
        firstElffoods.add(secondFood);
        firstElffoods.add(thirdFood);
        Elf anElf = new Elf("1", firstElffoods);


        List<Food> secondElfFoods = new ArrayList<>();
        Food secondElfFood = Food.builder().name("").calories(4000).build();
        secondElfFoods.add(secondElfFood);
        Elf anotherElf = new Elf("2", secondElfFoods);

        List<Elf> elfs = new ArrayList<>();
        elfs.add(anElf);
        elfs.add(anotherElf);
        return elfs;
    }

    private List<String> fakeReadInFileCalorieList(){
        List<String> linesInFile = new ArrayList<>(){
            {
                add("1000");
                add("2000");
                add("3000");
                add("\\r\\n");
                add("4000");
            }};
        return linesInFile;
    }

}
