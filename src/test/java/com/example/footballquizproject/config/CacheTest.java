package com.example.footballquizproject.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CacheTest {

    Cache cache = new Cache();

    @Test
    void put() {
        cache.put("key", "value");
        assertEquals("value", cache.get("key"));
        assertNotEquals("value2", cache.get("key"));
    }

    @Test
    void put_1001() {
        for(int i = 0; i < 1001; i++) {
            cache.put("key" + i, "value" + i);
        }
        assertEquals(1000, cache.size());
    }

    @Test
    void get() {
        cache.put("key", "value");
        assertEquals("value", cache.get("key"));
        assertNull(cache.get("key_X"));
    }

    @Test
    void containsKey() {
        cache.put("key", "value");
        assertTrue(cache.containsKey("key"));
        assertFalse(cache.containsKey("key_X"));
    }

    @Test
    void clear() {
        cache.put("key", "value");
        cache.put("key1", "value2");
        cache.clear();
        assertNull(cache.get("key"));
        assertNull(cache.get("key1"));
    }

    @Test
    void pop() {
        cache.put("key", "value");
        cache.put("key1", "value2");
        cache.pop();
        assertNull(cache.get("key1"));
    }

}