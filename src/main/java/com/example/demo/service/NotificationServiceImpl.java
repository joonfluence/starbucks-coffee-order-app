package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotificationServiceImpl implements NotificationService {
    @Override
    public void NotifyUser(Long memberId) {
        log.info("NotifyUser to {}", memberId.toString());
    }
}
