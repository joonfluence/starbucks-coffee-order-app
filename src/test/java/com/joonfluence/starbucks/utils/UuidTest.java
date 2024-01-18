package com.joonfluence.starbucks.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.UUID;

public class UuidTest {
    @DisplayName("")
    @Test
    void test(){
        // given
        // when
        // then
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        System.out.println("Your UUID is: " + uuidAsString);
    }
}
