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
public class Endpoint extends Base {
    int datacenterLatency;
    Map<Integer, Request> requests;
    Map<Integer, EndpointCacheServer> endpointsCacheServers;
    
    public Endpoint(int id, int datacenterLatency) {
        super(id);
        this.datacenterLatency = datacenterLatency;
        this.requests = new HashMap<>();
        this.endpointsCacheServers = new HashMap<>();
    }
    
    public void addEnpointCacheServer(CacheServer cacheServer, int latency){
        EndpointCacheServer ecs = new EndpointCacheServer(this, cacheServer, latency);
        endpointsCacheServers.put(cacheServer.getId(), ecs);
        cacheServer.getEndpointsCacheServers().put(getId(), ecs);
    }
}
