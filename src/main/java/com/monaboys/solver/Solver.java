package com.monaboys.solver;

import com.monaboys.entity.CacheServer;
import com.monaboys.tools.Statement;

import java.util.Set;

/**
 * Created by matti on 23/02/17.
 */
public interface Solver {

    Set<CacheServer> solve(Statement statement);
}
