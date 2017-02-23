package com.monaboys.tools;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.monaboys.entity.CacheServer;
import com.monaboys.solver.RandomSolver;

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
    public void itShouldGenerateRandom()
            throws IOException {
        List<String> fileNames = new ArrayList<>();
        fileNames.add("kittens");
        fileNames.add("me_at_the_zoo");
        fileNames.add("trending_today");
        fileNames.add("videos_worth_spreading");
        
        for (String fileName : fileNames) {
            String filename = FileHelper.getOutputFilename(fileName);
            Statement statement = Parser.parse(fileName);
            Collection<CacheServer> cacheServers = RandomSolver.solve(
                    statement.getCacheServers(),
                    statement.getVideos()
            );
            new Writer().write(filename, cacheServers);            
        }
    }
}
