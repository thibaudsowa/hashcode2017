package com.monaboys.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import com.monaboys.entity.CacheServer;
import com.monaboys.entity.Video;

/**
 * Created by tsowa on 22/02/2017.
 */
public class Parser {
    
    public Statement read(String fileName)
            throws IOException {
        
        List<String> lines = Files.readAllLines(Paths.get(fileName + ".in"));
        
        Statement statement = new Statement();
        
        //HEAD
        readHeadLine(lines, statement);
        
        createVideoLine(lines, statement);
        createCacheServer(lines, statement);
//        createEndpoint(lines, statement);
        
        return statement;
    }
    
    private void readHeadLine(List<String> lines, Statement statement) {
        String[] data = lines.get(0).split(" ");
        
        HeadLine headline = new HeadLine();
        headline.setNbVideo(Integer.parseInt(data[0]));
        headline.setNbEndpoint(Integer.parseInt(data[1]));
        headline.setNbRequest(Integer.parseInt(data[2]));
        headline.setNbCache(Integer.parseInt(data[3]));
        headline.setCacheSize(Integer.parseInt(data[4]));
        
        statement.setHeadLine(headline);
    }
    
    private void createVideoLine(List<String> lines, Statement statement) {
        String[] data = lines.get(0).split(" ");
        
        statement.setVideos(new HashMap<>());
        
        int idVideo = 0;
        for (String videoSize : data) {
            
            Video video = new Video(idVideo, Integer.parseInt(videoSize));
            statement.getVideos().put(idVideo, video);
            
            idVideo++;
        }
    }
    
    private void createCacheServer(List<String> lines, Statement statement) {
        statement.setCacheServers(new HashMap<>());
        
        for (int id = 0; id < statement.getHeadLine().getNbCache(); id++) {
            statement.getCacheServers().put(id, new CacheServer(id, statement.getHeadLine().getCacheSize()));
        }
    }

//    private void createEndpoint(List<String> lines, Statement statement) {
//        statement.setEndpoints(new HashMap<>());
//        
//        int idEnpoint = 0;
//        int cacheNumber = Integer.parseInt(lines.get(2).split(" ")[1]);
//        
//        for (int lineNumber = 2; lineNumber < lines.size(); lineNumber++) {
//            String[] data = lines.get(lineNumber).split(" ");
//            
//            //Si size == 3 on passe dans les requestes
//            if(data.length > 2) {
//                break;
//            }
//            
//            if(cacheNumber == 0) {
//                Endpoint endpoint = new Endpoint(idEnpoint, Integer.parseInt(data[0]));
//                cacheNumber = Integer.parseInt(data[1]);
//            } else {
//                
//            }
//            
//            statement.getEndpoints().put()
//        }
//    }
}
