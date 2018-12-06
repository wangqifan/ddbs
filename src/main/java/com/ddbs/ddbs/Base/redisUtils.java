package com.ddbs.ddbs.Base;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPubSub;

public class redisUtils {

    Jedis jedis = new Jedis("127.0.0.1", 6379);


    public void publishMsg(String channel, String message) {
        try {
            jedis.publish(channel, message);
        } catch (Exception e) {
        }
    }

    /**
     * 接收消息。在main方法调用后，会一直执行下去。当有发布对应消息时，就会在jedisPubSub中接收到！
     *
     * @param jedisPubSub
     * @param channels
     */
    public void subscribeMsg(JedisPubSub jedisPubSub, String channels) {
        try {
            jedis.subscribe(jedisPubSub, channels);
        } catch (Exception e) {
        }
    }


}
