package com.monaboys;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import com.monaboys.entity.CacheServer;
import com.monaboys.entity.Video;

/**
 * Created by lpetit on 23/02/2017.
 */
public class Factory {
    
    final static int MAX_CAPACITY = 1000;
    
    public static Collection<CacheServer> createCacheServers(){
    
        Video v0 = new Video(0, 10);
        Video v1 = new Video(1, 100);
        Video v2 = new Video(2, 1000);
        Collection<CacheServer> cacheServers = new ArrayList<CacheServer>(){{
            add(new CacheServer(0, MAX_CAPACITY){{
                setVideos(new HashMap<Integer, Video>(){{
                    put(v0.getId(), v0);
                }});
            }});
            add(new CacheServer(1, MAX_CAPACITY){{
                setVideos(new HashMap<Integer, Video>(){{
                    put(v0.getId(), v0);
                    put(v1.getId(), v1);
                }});
            }});
            add(new CacheServer(2, MAX_CAPACITY){{
                setVideos(new HashMap<Integer, Video>(){{
                    put(v0.getId(), v0);
                    put(v1.getId(), v1);
                    put(v2.getId(), v2);
                }});
            }});
        }};
        return cacheServers;
    }
    
}
