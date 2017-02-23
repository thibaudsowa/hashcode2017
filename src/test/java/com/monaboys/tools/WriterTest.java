package com.monaboys.tools;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import org.junit.Test;

import com.monaboys.entity.CacheServer;
import com.monaboys.entity.Video;

/**
 * Created by lpetit on 23/02/2017.
 */
public class WriterTest {
    
    final static int MAX_CAPACITY = 1000;
    
    @Test
    public void itShouldWriteFile()
            throws IOException {
        //  GIVEN
        String filename = "C:/TEMP/hashcode2017.out";
        Video v0 = new Video(0, 10);
        Video v1 = new Video(1, 100);
        Video v2 = new Video(2, 1000);
        Collection<CacheServer> cacheServers = new ArrayList<CacheServer>(){{
            add(new CacheServer(0, MAX_CAPACITY){{
                setVideos(new HashMap<Integer, Video>(){{
                    put(v0.getId(), v0);
                }});
            }});
            add(new CacheServer(1, MAX_CAPACITY){{
                setVideos(new HashMap<Integer, Video>(){{
                    put(v0.getId(), v0);
                    put(v1.getId(), v1);
                }});
            }});
            add(new CacheServer(2, MAX_CAPACITY){{
                setVideos(new HashMap<Integer, Video>(){{
                    put(v0.getId(), v0);
                    put(v1.getId(), v1);
                    put(v2.getId(), v2);
                }});
            }});
        }};
        
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
