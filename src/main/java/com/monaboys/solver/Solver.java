package com.monaboys.solver;

import com.monaboys.entity.Endpoint;
import com.monaboys.entity.EndpointCacheServer;

import java.util.List;

/**
 * Created by matti on 23/02/17.
 */
public interface Solver {

    List<EndpointCacheServer> solve(Endpoint endpoint);
}
