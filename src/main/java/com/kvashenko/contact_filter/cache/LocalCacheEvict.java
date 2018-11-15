package com.kvashenko.contact_filter.cache;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Component;

@Component
public class LocalCacheEvict {

    @CacheEvict(cacheNames = "contacts", allEntries = true)
    public void evictAllContacts() {
    }
}
