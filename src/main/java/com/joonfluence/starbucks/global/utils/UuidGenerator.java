package com.joonfluence.starbucks.global.utils;

import java.util.UUID;

public class UuidGenerator {
    public static String generate(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
