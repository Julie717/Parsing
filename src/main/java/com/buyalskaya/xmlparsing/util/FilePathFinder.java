package com.buyalskaya.xmlparsing.util;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

public final class FilePathFinder {
    private static final Logger logger= LogManager.getLogger();
    private static final FilePathFinder instance = new FilePathFinder();

    private FilePathFinder() {
    }

    public static FilePathFinder getInstance() {
        return instance;
    }

    public String findPath(String fileName) {
        String filePath = fileName;
        if (fileName != null && !fileName.isEmpty()) {
            URL urlFile = getClass().getClassLoader().getResource(fileName);
            if (urlFile != null) {
                try {
                    File fileLocation = Paths.get(urlFile.toURI()).toFile();
                    filePath = fileLocation.toString();
                } catch (URISyntaxException ex) {
                    logger.log(Level.WARN, "XML file isn't found");
                }
            }
        }else{
            logger.log(Level.WARN, "Incorrect file name");
        }
        return filePath;
    }
}