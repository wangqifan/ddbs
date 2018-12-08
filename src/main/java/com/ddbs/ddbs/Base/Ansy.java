package com.ddbs.ddbs.Base;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;


@Service
public class Ansy implements InitializingBean {

    @Override
    public void afterPropertiesSet() throws Exception {
       Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(1000);
                    } catch (Exception x) {
                    }
                    redisUtils util = new redisUtils();
                    RedisMsgSubListener pubsub = new RedisMsgSubListener();
                    util.subscribeMsg(pubsub, "test");
                }
            }
        });
        thread.start();
    }
}
