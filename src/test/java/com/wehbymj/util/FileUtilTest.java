package com.wehbymj.util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    @Test
    void testCreateURLFromStringPathReturnsNullIfNotFound(){
        URL shouldBeNull = FileUtil.createURLFromResourcePath("madeUp");
        assertNull(shouldBeNull);
    }

    @Test
    void testCreateURLFromStringPathReturnsNotNullIfFound(){
        final String excelForTest = "advent-test-data-day1.txt";
        URL shouldNotBeNullURL = FileUtil.createURLFromResourcePath(excelForTest);
        assertNotNull(shouldNotBeNullURL);
        assertTrue(shouldNotBeNullURL.toString().endsWith("advent-test-data-day1.txt"));
    }

    @Test
    void testCreateFileFromURLThrownsIllegalArgumentExceptionIfURLSyntaxIsIncorrect()  {
        URL urlForTest = null;
        try {
            urlForTest = new URL("file: /U/U/U");
        }catch(MalformedURLException me){
           me.toString();
        }

        URL finalUrlForTest = urlForTest;
        Assertions.assertThrows(IllegalArgumentException.class, () -> {

            FileUtil.createFileFromURL(finalUrlForTest);
        });
    }

    @Test
    void testCreateFileFromURL() throws MalformedURLException {
        final URL urlForTest = new URL("file:/somepath/somefile.txt");
        File fileForTestURL = FileUtil.createFileFromURL(urlForTest);
        assertNotNull(fileForTestURL);
    }
}
