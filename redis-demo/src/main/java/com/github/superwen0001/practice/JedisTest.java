package com.github.superwen0001.practice;

import redis.clients.jedis.Jedis;

/**
 * Created by wenshiliang on 2017/3/20.
 */
public class JedisTest {
    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.1.80", 6387);

        jedis.set("test","test1");

        System.out.println(jedis.get("test"));

        jedis.close();
    }
}
