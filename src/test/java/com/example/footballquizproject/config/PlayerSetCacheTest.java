package com.example.footballquizproject.config;

import com.example.footballquizproject.domain.Players;
import com.example.footballquizproject.repository.PlayersRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@WebAppConfiguration
class PlayerSetCacheTest {

    @Autowired
    private PlayersRepository playersRepository;
    private Set<Players> playersSet1;
    private Set<Players> playersSet2;

    AbstractCache<String, Set<Players>> abstractCache = new PlayerSetCache();

    @BeforeEach
    void initializeCache(){
        playersSet1 = playersRepository.findByTeamId(1L);
        playersSet2 = playersRepository.findByTeamId(2L);
        abstractCache.put("key" , playersSet1);
    }

    @Test
    public void testPut(){
        assertEquals(playersSet1, abstractCache.get("key"));
        assertNotEquals(playersSet2, abstractCache.get("key"));
    }

    @Test
    public void testPut_1001(){
        for(int i = 0; i < 1001; i++) {
            abstractCache.put("key" + i, playersSet1);
        }
        assertEquals(1000, abstractCache.size());
    }

    @Test
    void testGet(){
        assertEquals(playersSet1, abstractCache.get("key"));
        assertNull(abstractCache.get("key_x"));
    }

    @Test
    void testContainsKey(){
        assertTrue(abstractCache.containsKey("key"));
        assertFalse(abstractCache.containsKey("key_x"));

    }

    @Test
    void testClear(){
        abstractCache.clear();
        assertNull(abstractCache.get("key"));
    }

    @Test
    void testPop(){
        abstractCache.pop();
        assertNull(abstractCache.get("key"));
    }
}