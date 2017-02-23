package com.monaboys.tools;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by tsowa on 23/02/2017.
 */
@Getter
@Setter
public class HeadLine {
    
    int nbVideo;
    int nbEndpoint;
    int nbRequest;
    int nbCache;
    int cacheSize;
    
    public int getNbVideo() {
        return nbVideo;
    }
    
    public int getNbEndpoint() {
        return nbEndpoint;
    }
    
    public int getNbRequest() {
        return nbRequest;
    }
    
    public int getNbCache() {
        return nbCache;
    }
    
    public int getCacheSize() {
        return cacheSize;
    }
}
