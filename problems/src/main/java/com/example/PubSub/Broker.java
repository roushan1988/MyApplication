package com.example.PubSub;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public final class  Broker {
    private final Object mutex = new Object();
    static class CommonTopics{
        private CommonTopics(){}
        public static final String ON_CACHE_RESET = "onCacheReset";
    }
    public static final Broker brokerInstance = new Broker();

    private Broker(){

    }

    private Map<String, Set<Subscriber>> subscribers = new ConcurrentHashMap<>();

    public boolean deregister(String topic, Subscriber subscriber) {
        if(this.subscribers.containsKey(topic)){
            final Set<Subscriber> subs = this.subscribers.get(topic);
            return subs.remove(subscriber);
        }else
            return false; //Topic not found
    }

    public boolean register(String topic, Subscriber subscriber) {
        boolean returnVal;
        if (subscribers.containsKey(topic)) {
            returnVal = subscribers.get(topic).add(subscriber);
        } else {
            Set<Subscriber> sub = new HashSet<>();
            returnVal = sub.add(subscriber);
            subscribers.put(topic, sub);
        }
        return returnVal;
    }

    public void sendMessage(String topic,Map map){
        if(this.subscribers.containsKey(topic)){
            final Set<Subscriber> sub = this.subscribers.get(topic);
            sub.parallelStream().forEach(subscriber -> subscriber.update(map));
        }else{
            //Topic not found
        }
    }

}
