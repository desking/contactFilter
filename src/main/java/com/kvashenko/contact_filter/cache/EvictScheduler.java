package com.kvashenko.contact_filter.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class EvictScheduler {

    @Autowired
    private LocalCacheEvict localCacheEvict;

    @Scheduled(fixedDelay = 36000000)
    public void clearCaches() {
        localCacheEvict.evictAllContacts();
    }

}
