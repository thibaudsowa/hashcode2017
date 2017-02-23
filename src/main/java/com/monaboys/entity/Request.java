package com.monaboys.entity;

/**
 * Created by lpetit on 23/02/2017.
 */
public class Request extends Base {
    int nb;
    Endpoint endpoint;
    Video video;
    
    public Request(int id, int nb, Endpoint endpoint, Video video) {
        super(id);
        this.nb = nb;
        this.endpoint = endpoint;
        this.video = video;
    }
}
