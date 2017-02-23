package com.monaboys.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Created by lpetit on 23/02/2017.
 */
public class Writer {
    
    
    public void write(String fileName/*, la chose à serialiser */) {
        
        String output = "";
        try {
            Files.write(Paths.get(fileName + ".out"), output.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
