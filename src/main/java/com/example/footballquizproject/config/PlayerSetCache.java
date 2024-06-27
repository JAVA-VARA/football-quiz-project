package com.example.footballquizproject.config;

import com.example.footballquizproject.domain.Players;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class PlayerSetCache extends AbstractCache<String, Set<Players>> {
}
