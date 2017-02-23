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
public class CacheServer extends Base {
    int maxCapacity;
    Map<Integer, Video> videos;
    Map<Integer, EndpointCacheServer> endpointsCacheServers;
    
    public CacheServer(int id, int maxCapacity) {
        super(id);
        this.maxCapacity = maxCapacity;
        this.videos = new HashMap<>();
        this.endpointsCacheServers = new HashMap<>();
    }
    
    public void addVideo(Video video){
        videos.put(video.getId(), video);
        video.getCacheServers().put(getId(), this);
    }
    
    public void addEnpointCacheServer(Endpoint endpoint, int latency){
        EndpointCacheServer ecs = new EndpointCacheServer(endpoint, this, latency);
        endpointsCacheServers.put(endpoint.getId(), ecs);
        endpoint.getEndpointsCacheServers().put(getId(), ecs);
    }
}
