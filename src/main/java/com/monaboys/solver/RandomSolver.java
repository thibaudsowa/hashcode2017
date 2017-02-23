package com.monaboys.solver;

import java.util.Collection;
import java.util.Map;

import com.monaboys.entity.CacheServer;
import com.monaboys.entity.Video;

/**
 * Created by lpetit on 23/02/2017.
 */
public class RandomSolver {
    
    public Collection<CacheServer> solve(Map<Integer, CacheServer> cacheServers, Map<Integer, Video> videos){
        for(Video video : videos.values()){
            int nbCacheServer =(int)(Math.random() * (cacheServers.size() / 2));
            for(int i = 0; i<nbCacheServer; i++){
                int cacheServerIndex = (int)(Math.random() * cacheServers.size());
                CacheServer cacheServer = cacheServers.get(cacheServerIndex);
                if(getCacheServerSpace(cacheServer) >= video.getSize()) {
                    cacheServer.addVideo(video);
                }
            }
        }
        return cacheServers.values();
    }
    
    private int getCacheServerSpace(CacheServer cacheServer){
        int videoSpace = 0;
        for(Video video : cacheServer.getVideos().values()){
            videoSpace += video.getSize();
        }
        return cacheServer.getMaxCapacity() - videoSpace;
    }
    
}
