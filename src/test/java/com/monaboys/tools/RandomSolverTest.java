package com.monaboys.tools;

import java.io.IOException;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

import com.monaboys.Factory;
import com.monaboys.entity.CacheServer;

/**
 * Created by lpetit on 23/02/2017.
 */
public class RandomSolverTest {
    
    @Before
    public void init()
            throws IOException {
        FileHelper.createOutputFolder();
    }
    
    @Test
    public void itShouldGenerateRandom() {
        //  GIVEN
        String filename = FileHelper.getOutputFilename();
        
        //  WHEN
        Collection<CacheServer> cacheServers = Factory.createCacheServers();        
        
        //  THEN
        new Writer().write(filename, cacheServers);
    }
}
