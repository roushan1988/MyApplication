package com.example.PubSub;

import java.util.Map;

public class ExampleSubscriber implements Subscriber {
    @Override
    public void update(Map map) {
        System.out.println(map.get("oldCachedValue"));
        System.out.println(map.get("newCachedValue"));
    }

    public static void main(String[] args) {
        ExampleSubscriber subscriber = new ExampleSubscriber();
        Broker.brokerInstance.register(Broker.CommonTopics.ON_CACHE_RESET,subscriber);
    }
}
