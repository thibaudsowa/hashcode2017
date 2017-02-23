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
public class Endpoint extends Base {
    int datacenterLatency;
    Set<Request> requests;
    Set<EndpointCacheServer> endpointsCacheServers;
    
    public Endpoint(int id, int datacenterLatency) {
        super(id);
        this.datacenterLatency = datacenterLatency;
        this.requests = new HashSet<>();
        this.endpointsCacheServers = new HashSet<>();
    }
}
