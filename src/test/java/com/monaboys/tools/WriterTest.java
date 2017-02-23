package com.monaboys.tools;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

import com.monaboys.Factory;
import com.monaboys.entity.CacheServer;

/**
 * Created by lpetit on 23/02/2017.
 */
public class WriterTest {
    
    @Test
    public void itShouldWriteFile()
            throws IOException {
        //  GIVEN
        String filename = "C:/TEMP/hashcode2017.out";
        Collection<CacheServer> cacheServers = Factory.createCacheServers();
        
        //  WHEN
        Writer writer = new Writer();
        writer.write(filename, cacheServers);
        
        //  THEN    
        Path filePath = Paths.get(filename);
        List<String> lines = Files.readAllLines(filePath);
        assertEquals(4, lines.size());
        assertEquals("3", lines.get(0));
        assertEquals("0 0", lines.get(1));
        assertEquals("1 0 1", lines.get(2));
        assertEquals("2 0 1 2", lines.get(3));        
        Files.delete(filePath);
    }
}
