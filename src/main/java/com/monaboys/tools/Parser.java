package com.monaboys.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by tsowa on 22/02/2017.
 */
public class Parser {
    
    public void read(String fileName) {
        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName + ".in"));
            
            //HEAD
            readHeadLine(lines);
            
            //CONTENT
            readContent(lines);
    
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private void readHeadLine(List<String> lines) {
        String headLine = lines.get(0);
    }
    
    private void readContent(final List<String> lines) {
        for (int i = 1; i < lines.size(); i++) {
            String contentLine = lines.get(i);
        }
    }
    
    public void write(String fileName/*, la chose à serialiser */) {
        
        String output = getHeadToWrite() + getContentToWrite();
        
        System.out.println(output);
        try {
            Files.write(Paths.get(fileName + ".out"), output.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    private String getHeadToWrite(/*, la chose à serialiser */) {
        
    }
    
    private String getContentToWrite(/*, la chose à serialiser */) {
        
    }
}
