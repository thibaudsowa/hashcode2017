package com.monaboys.tools;

import com.monaboys.entity.*;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by gbilley on 23/02/17.
 */
public class Scoring {


    public int chooseBestWay(Request request, Set<CacheServer> caches) {
        Set<CacheServer> cacheServers = containsVideo(caches, request.getVideo());
        cacheServers = isConnected(cacheServers, request.getEndpoint());
    }

    private Set<CacheServer> containsVideo(Set<CacheServer> cacheServers, Video video) {
        return cacheServers.stream()
                .filter(cache -> cache.getVideos().containsValue(video))
                .collect(Collectors.toSet());
    }

    private EndpointCacheServer connectedEndPointCacheServer(Set<CacheServer> cacheServers, Endpoint endpoint) {
        for (CacheServer cacheServer : cacheServers) {
            for (EndpointCacheServer endpointCacheServer : cacheServer.getEndpointsCacheServers()) {
                if (endpointCacheServer.getEndpoint().equals(endpoint)) {
                    return endpointCacheServer;
                }
            }
        }
        return null;
    }

    private boolean containsEndPoint(Endpoint endpoint, CacheServer cacheServer) {
        return cacheServer.getEndpointsCacheServers()
                .stream()
                .anyMatch(
                        endpointCacheServer -> endpointCacheServer.getEndpoint().equals(endpoint)
                );
    }
}
