package com.monaboys.entity;

import java.util.HashMap;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by lpetit on 23/02/2017.
 */
@Getter
@Setter
public class Video extends Base {
    int size;
    Map<Integer, Request> requests;
    Map<Integer, CacheServer> cacheServers;
    
    public Video(int id, int size) {
        super(id);
        this.size = size;
        this.requests = new HashMap<>();
    }
    
    public void addCacheServer(CacheServer cacheServer){
        cacheServers.put(cacheServer.getId(), cacheServer);
        cacheServer.getVideos().put(getId(), this);
    }
}
