package com.monaboys.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lpetit on 23/02/2017.
 */
public class FileHelper {
    
    public static final String OUTPUT_FOLDER_PATH = "C:\\TEMP";
    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd_hh-mm-ss");
    
    public static String getOuputFolderPath(){
        return "output";
    }
    
    public static void createOutputFolder()
            throws IOException {
        Files.createDirectories(Paths.get(getOuputFolderPath()));
    }
    
    public static String getOutputFilename(){
        return new StringBuilder()
                .append(getOuputFolderPath())
                .append("\\")
                .append(DATE_FORMAT.format(new Date()))
                .append(".out")
                .toString();
    }
    
}
