package com.github.superwen0001.practice;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.util.Pool;

import java.util.logging.Logger;

/**
 * Created by wenshiliang on 2017/3/20.
 */
public class MyJedisPool extends Pool<Jedis> {

    protected Logger log = Logger.getLogger(getClass().getName());

//    private volatile JedisFactory factory;
    private volatile HostAndPort currentHostMaster;



}
