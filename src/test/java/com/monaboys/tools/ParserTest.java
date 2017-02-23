package com.monaboys.tools;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;

import org.junit.Test;

/**
 * Created by tsowa on 23/02/2017.
 */
public class ParserTest {
    
    @Test
    public void itShouldReadFile()
            throws IOException {
        //  GIVEN
        String filename = "kittens";
        
        //  WHEN
        Statement statement = Parser.parse(filename);
        
        //  THEN    
        assertNotNull(statement);
        
    }
}
