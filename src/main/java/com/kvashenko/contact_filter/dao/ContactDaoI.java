package com.kvashenko.contact_filter.dao;

import com.kvashenko.contact_filter.model.Contact;

import java.util.List;

public interface ContactDaoI {
    List<Contact> findBatchContacts(int first, int max);

    long countRows();


}
