package com.monaboys.entity;

import java.util.HashSet;
import java.util.Set;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by lpetit on 23/02/2017.
 */
@Getter
@Setter
public class CacheServer extends Base {
    int maxCapacity;
    Set<Video> videos;
    Set<EndpointCacheServer> endpointsCacheServers;
    
    public CacheServer(int id, int maxCapacity) {
        super(id);
        this.maxCapacity = maxCapacity;
        this.videos = new HashSet<>();
        this.endpointsCacheServers = new HashSet<>();
    }
}
