package com.monaboys.tools;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;

import com.monaboys.entity.CacheServer;
import com.monaboys.entity.Video;

/**
 * Created by lpetit on 23/02/2017.
 */
public class Writer {
    
    private static final String SEPARATOR = " ";
    
    public void write(String fileName, Collection<CacheServer> cacheServers) {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName, "UTF-8"){
                //  UNIX FORMAT
                @Override
                public void println() {
                    write("\n");
                }
            };
            write(writer, cacheServers);
        } 
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(writer != null){
                writer.close();
            }
        }
    }
    
    public void write(PrintWriter writer, Collection<CacheServer> cacheServers){
        writer.println(getLine(cacheServers));
        for(CacheServer cacheServer : cacheServers){
            writer.println(getLine(cacheServer));
        }
    }
    
    private Collection<CacheServer> getNotEmptyCacheServers(Collection<CacheServer> cacheServers){
        Collection<CacheServer> notEmptyCacheServers = new ArrayList<>();
        for(CacheServer cacheServer : cacheServers){
            if(!cacheServer.getVideos().isEmpty()){
                notEmptyCacheServers.add(cacheServer);
            }
        }
        return notEmptyCacheServers;
    }
    
    private String getLine(Collection<CacheServer> cacheServers){
        return Integer.toString(cacheServers.size());
    }
    
    private String getLine(CacheServer cacheServer){
        StringBuilder sb = new StringBuilder().append(cacheServer.getId());
        for(Video video : cacheServer.getVideos().values()){
            sb.append(SEPARATOR).append(video.getId());
        }
        return sb.toString();
    }
    
}
