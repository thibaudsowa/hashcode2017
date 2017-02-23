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
public class Video extends Base {
    int size;
    Set<Request> requests;
    Set<CacheServer> cacheServers;
    
    public Video(int id, int size) {
        super(id);
        this.size = size;
        this.requests = new HashSet<>();
    }
}
