package com.example.footballquizproject.config;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class RankingCache extends AbstractCache<String, Map<Integer, Integer>> {
}
