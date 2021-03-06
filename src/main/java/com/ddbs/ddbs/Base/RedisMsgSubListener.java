package com.ddbs.ddbs.Base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ddbs.ddbs.Model.customer;
import org.springframework.beans.factory.annotation.Autowired;
import redis.clients.jedis.JedisPubSub;
import com.ddbs.ddbs.DAO.customerDAO;

public class RedisMsgSubListener extends JedisPubSub {

    @Autowired
    private customerDAO customerDAO;
    // 取得订阅的消息后的处理
    public void onMessage(String channel, String message) {
        System.out.println(channel + "=" + message);
        JSONObject jsonObject = JSON.parseObject(message);
        customer customer= JSON.toJavaObject(jsonObject,customer.class);
        customerDAO.Addcustomer(customer);
    }

    // 初始化订阅时候的处理
    public void onSubscribe(String channel, int subscribedChannels) {
        // System.out.println(channel + "=" + subscribedChannels);
    }

    // 取消订阅时候的处理
    public void onUnsubscribe(String channel, int subscribedChannels) {
        // System.out.println(channel + "=" + subscribedChannels);
    }

    // 初始化按表达式的方式订阅时候的处理
    public void onPSubscribe(String pattern, int subscribedChannels) {
        // System.out.println(pattern + "=" + subscribedChannels);
    }

    // 取消按表达式的方式订阅时候的处理
    public void onPUnsubscribe(String pattern, int subscribedChannels) {
        // System.out.println(pattern + "=" + subscribedChannels);
    }

    // 取得按表达式的方式订阅的消息后的处理
    public void onPMessage(String pattern, String channel, String message) {
        System.out.println(pattern + "=" + channel + "=" + message);
    }
}
