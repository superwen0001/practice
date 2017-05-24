package com.github.superwen0001.practice;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by wenshiliang on 2017/3/20.
 */
public class JedisSentinelPoolTest {
    public static void main(String[] args) {

        String masterName = "mymaster";
        Set<String> sentinels = new HashSet<>();
        sentinels.add("192.168.180.113:26379");
        JedisSentinelPool pool = new JedisSentinelPool(masterName, sentinels, new GenericObjectPoolConfig(), 1000);

        while (true){
            Jedis jedis = pool.getResource();


            System.out.println(jedis.get("test1"));
            jedis.close();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
