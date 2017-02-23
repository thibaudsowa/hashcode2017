package com.monaboys.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by lpetit on 23/02/2017.
 */
@Getter
@Setter
public class Request extends Base {
    int nb;
    Endpoint endpoint;
    Video video;
    
    public Request(int id, int nb, Endpoint endpoint, Video video) {
        super(id);
        this.nb = nb;
        this.endpoint = endpoint;
        this.video = video;
        this.endpoint.getRequests().put(id, this);
        this.video.getRequests().put(id, this);
    }
}
