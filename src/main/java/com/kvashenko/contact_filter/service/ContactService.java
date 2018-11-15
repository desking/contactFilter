package com.kvashenko.contact_filter.service;

import com.kvashenko.contact_filter.dao.ContactDao;
import com.kvashenko.contact_filter.model.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class ContactService {
    @Autowired
    private ContactDao contactDao;

    public List<Contact> contactFilter(String regex) {
        List<Contact> filteredContacts = new ArrayList<>();
        int maxRows = 1000;
        long countRows = contactDao.countRows();
        int i = 0;
        while (i < countRows) {
            filteredContacts.addAll(filter(contactDao.findBatchContacts(i, maxRows), regex));
            i += maxRows;
        }

        return filteredContacts;
    }

    private List<Contact> filter(List<Contact> contacts, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return contacts.stream()
                .filter(c -> !pattern.matcher(c.getName()).matches())
                .collect(Collectors.toList());
    }

    public void saveOneMillionRandomContacts() {
        contactDao.saveOneMillionRandomContacts();
    }
}
