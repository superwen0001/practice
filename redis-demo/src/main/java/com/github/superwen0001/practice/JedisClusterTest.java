package com.github.superwen0001.practice;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by wenshiliang on 2017/3/20.
 */
public class JedisClusterTest {
    public static void main(String[] args) {

        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
//Jedis Cluster will attempt to discover cluster nodes automatically
        jedisClusterNodes.add(new HostAndPort("192.168.1.80", 6387));
        JedisCluster jc = new JedisCluster(jedisClusterNodes);
        jc.set("foo", "bar");
        String value = jc.get("foo");
        System.out.println(value);
        test("1","22");
    }


    public static void test(String... aa){

    }
}
