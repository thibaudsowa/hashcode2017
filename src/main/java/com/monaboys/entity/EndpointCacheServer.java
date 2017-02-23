package com.monaboys.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by lpetit on 23/02/2017.
 */
@Getter
@Setter
public class EndpointCacheServer {
    Endpoint endpoint;
    CacheServer server;
    int latency;
    
    public EndpointCacheServer(Endpoint endpoint, CacheServer server, int latency) {
        this.endpoint = endpoint;
        this.server = server;
        this.latency = latency;
    }
}
