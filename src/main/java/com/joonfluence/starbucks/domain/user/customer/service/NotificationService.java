package com.joonfluence.starbucks.domain.user.customer.service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotificationService {
    public void NotifyUser(Long memberId) {
        log.info("NotifyUser to {}", memberId.toString());
    }
}
