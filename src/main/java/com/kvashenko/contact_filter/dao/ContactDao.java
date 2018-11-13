package com.kvashenko.contact_filter.dao;

import com.kvashenko.contact_filter.model.Contact;
import com.kvashenko.contact_filter.service.ContactGenerator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ContactDao implements ContactDaoI {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Contact> findBatchContacts(int first, int max) {
        return entityManager.createQuery("from Contact c")
                .setFirstResult(first)
                .setMaxResults(max)
                .getResultList();
    }

    @Override
    public long countRows() {
        return (long) entityManager.createQuery("select count(c) from Contact c").getSingleResult();
    }

    @Transactional
    public void saveOneMillionRandomContacts() {
        int entityCount = 1000000;
        int batchSize = 2000;
        for (int i = 0; i < entityCount; i++) {
            Contact contact = new Contact(ContactGenerator.generateRandomStrings());
            entityManager.persist(contact);
            if (i > 0 && i % batchSize == 0) {
                entityManager.flush();
                entityManager.clear();
            }
        }
    }
}
