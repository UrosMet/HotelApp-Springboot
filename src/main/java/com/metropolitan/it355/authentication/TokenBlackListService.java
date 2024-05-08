package com.metropolitan.it355.authentication;

import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class TokenBlackListService {
    private final Set<String> blacklist = ConcurrentHashMap.newKeySet();

    public void blacklistToken(String token) {
        System.err.println("Blacklisted token : " + token);
        blacklist.add(token);
    }

    public boolean isTokenBlacklisted(String token) {
        return blacklist.contains(token);
    }
}
