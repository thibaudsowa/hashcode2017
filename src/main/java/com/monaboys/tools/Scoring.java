package com.monaboys.tools;

import com.monaboys.entity.*;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by gbilley on 23/02/17.
 */
public class Scoring {


    public static Set<EndpointCacheServer> chooseBestWay(Request request, Set<CacheServer> caches) {
        Set<CacheServer> cacheServers = containsVideo(caches, request.getVideo());
        return cacheServers
                .stream()
                .map(cacheServer -> connectedEndPointCacheServer(cacheServer, request.getEndpoint()))
                .filter(Objects::nonNull)
                .collect(Collectors.toSet());
    }

    public static Set<CacheServer> containsVideo(Set<CacheServer> cacheServers, Video video) {
        return cacheServers.stream()
                .filter(cache -> cache.getVideos().containsValue(video))
                .collect(Collectors.toSet());
    }

    public static EndpointCacheServer connectedEndPointCacheServer(CacheServer cacheServer, Endpoint endpoint) {
        Map<Integer, EndpointCacheServer> endpointsCacheServers = cacheServer.getEndpointsCacheServers();
        int size = endpointsCacheServers.size();
        for (int i = 0; i < size; i++) {
            EndpointCacheServer endpointCacheServer = endpointsCacheServers.get(i);
            if (endpointCacheServer.getEndpoint().equals(endpoint)){
                return endpointCacheServer;
            }
        }
        return null;
    }
}
