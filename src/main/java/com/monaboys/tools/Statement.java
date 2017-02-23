package com.monaboys.tools;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

import com.monaboys.entity.CacheServer;
import com.monaboys.entity.Endpoint;
import com.monaboys.entity.Request;
import com.monaboys.entity.Video;

/**
 * Created by tsowa on 23/02/2017.
 */
@Getter
@Setter
public class Statement {
    
    HeadLine headLine;
    Map<Integer, Video> videos;
    Map<Integer, Endpoint> endpoints;
    Map<Integer, CacheServer> cacheServers;
    Map<Integer, Request> requests;
}
