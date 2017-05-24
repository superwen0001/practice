package com.github.superwen0001.practice;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by wenshiliang on 2017/3/20.
 */
public class PoolJedis {
    public static void main(String[] args) {
        JedisPool pool = new JedisPool(new JedisPoolConfig(), "192.168.1.80",6384);


//        JedisCluster
//        new JedisSentinelPool()
        Jedis jedis = pool.getResource();


        System.out.println(jedis.get("test1"));

    }
}
