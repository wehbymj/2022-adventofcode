package com.wehbymj.util;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

public class FileUtil {

    private FileUtil() {
        throw new IllegalStateException("Utility class");
    }

    public static URL createURLFromResourcePath(String resourcePath){
        return FileUtil.class.getClassLoader().getResource(resourcePath);
    }

    public static File createFileFromURL(URL urlForResource) {
        File createdFile;
        try{
            createdFile = new File(urlForResource.toURI());
            return createdFile;
        }catch(URISyntaxException use){
            throw new IllegalArgumentException("Invalid URI", use);
        }
    }
}
