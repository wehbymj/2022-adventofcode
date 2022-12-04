package com.wehbymj.advent.elf;


import com.wehbymj.util.FileUtil;
import lombok.RequiredArgsConstructor;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@RequiredArgsConstructor
public class ElfFile {
    private final String pathToElfCalorieFile;

    List<String> extractCalories(){
        List<String> strCaloriesList = null;

        URL urlFromResourcePath = FileUtil.createURLFromResourcePath(pathToElfCalorieFile);
        File testDataFile = FileUtil.createFileFromURL(urlFromResourcePath);

        try {
            strCaloriesList = Files.readAllLines(Path.of( testDataFile.getPath() ));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return strCaloriesList;
    }

}
