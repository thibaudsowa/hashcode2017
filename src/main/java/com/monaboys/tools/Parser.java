package com.monaboys.tools;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

import com.monaboys.entity.CacheServer;
import com.monaboys.entity.Endpoint;
import com.monaboys.entity.Request;
import com.monaboys.entity.Video;

/**
 * Created by tsowa on 22/02/2017.
 */
public class Parser {
    
    public static Statement parse(String fileName)
            throws IOException {
        
        List<String> lines = Files.readAllLines(Paths.get("input/" + fileName + ".in"));
        
        Statement statement = new Statement();
        
        //HEAD
        readHeadLine(lines, statement);
        
        createVideoLine(lines, statement);
        createCacheServer(lines, statement);
        createEndpoint(lines, statement);
        createRequest(lines, statement);
        
        return statement;
    }
    
    private static void readHeadLine(List<String> lines, Statement statement) {
        String[] data = lines.get(0).split(" ");
        
        HeadLine headline = new HeadLine();
        headline.setNbVideo(Integer.parseInt(data[0]));
        headline.setNbEndpoint(Integer.parseInt(data[1]));
        headline.setNbRequest(Integer.parseInt(data[2]));
        headline.setNbCache(Integer.parseInt(data[3]));
        headline.setCacheSize(Integer.parseInt(data[4]));
        
        statement.setHeadLine(headline);
    }
    
    private static void createVideoLine(List<String> lines, Statement statement) {
        String[] data = lines.get(1).split(" ");
        
        statement.setVideos(new HashMap<>());
        
        int idVideo = 0;
        for (String videoSize : data) {
            
            Video video = new Video(idVideo, Integer.parseInt(videoSize));
            statement.getVideos().put(idVideo, video);
            
            idVideo++;
        }
    }
    
    private static void createCacheServer(List<String> lines, Statement statement) {
        statement.setCacheServers(new HashMap<>());
        
        for (int id = 0; id < statement.getHeadLine().getNbCache(); id++) {
            statement.getCacheServers().put(id, new CacheServer(id, statement.getHeadLine().getCacheSize()));
        }
    }
    
    private static void createEndpoint(List<String> lines, Statement statement) {
        statement.setEndpoints(new HashMap<>());
        
        int idEndpoint = 0;
        int cacheNumber = Integer.parseInt(lines.get(2).split(" ")[1]);
        Endpoint endpoint = new Endpoint(idEndpoint, Integer.parseInt(lines.get(2).split(" ")[0]));
        
        for (int lineNumber = 3; lineNumber < lines.size(); lineNumber++) {
            String[] data = lines.get(lineNumber).split(" ");
            
            if (cacheNumber == 0) {
                //On crée l'endpoint
                cacheNumber = Integer.parseInt(data[1]);
                endpoint = new Endpoint(idEndpoint, Integer.parseInt(data[0]));
            } else {
                
                //On lie le précédent a un cache server
                endpoint.addEnpointCacheServer(statement.getCacheServers().get(Integer.parseInt(data[0])),
                        Integer.parseInt(data[1]));
                
                cacheNumber--;
                if (cacheNumber == 0) {
                    statement.getEndpoints().put(idEndpoint, endpoint);
                    
                    if (statement.getEndpoints().size() == statement.getHeadLine().getNbEndpoint()) {
                        break;
                    }
                    
                    idEndpoint++;
                }
            }
        }
    }
    
    private static void createRequest(List<String> lines, Statement statement) {
        statement.setRequests(new HashMap<>());
        
        int idRequest = 0;
        for (int lineNumber = 2; lineNumber < lines.size(); lineNumber++) {
            String[] data = lines.get(lineNumber).split(" ");
            
            if (data.length == 3) {
                statement.getRequests().put(idRequest, new Request(
                        idRequest,
                        Integer.parseInt(data[2]),
                        statement.getEndpoints().get(Integer.parseInt(data[1])),
                        statement.getVideos().get(Integer.parseInt(data[0]))));
            }
            
            idRequest++;
        }
    }
}
