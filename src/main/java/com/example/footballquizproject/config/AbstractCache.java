package com.example.footballquizproject.config;

import org.springframework.scheduling.annotation.Scheduled;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    protected Map<K, V> cache = new HashMap<>();
    int maxCacheSize = 1000;

    public void put(K key, V value) {

        if (cache.size() >= maxCacheSize) {
            this.pop();
        }

        cache.put(key, value);
    }

    public V get(K key) {
        return cache.get(key);
    }

    public boolean containsKey(K key) {
        return cache.containsKey(key);
    }

    public void pop() {
        cache.remove(cache.keySet().iterator().next());
    }

    public int size() {
        return cache.size();
    }

    public void clear() {
        cache.clear();
    }

    @Scheduled(fixedRate = 360000) // 1시간 마다 실행
    public void clearCachePeriodically() {
        System.out.println("Clearing cache at: " + new java.util.Date());
        this.clear();
    }

}
