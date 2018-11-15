package com.kvashenko.contact_filter;

import com.kvashenko.contact_filter.dao.ContactDao;
import com.kvashenko.contact_filter.model.Contact;
import com.kvashenko.contact_filter.service.ContactService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {
    @InjectMocks
    private ContactService contactService;
    @Mock
    private ContactDao contactDao;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        Mockito.when(contactDao.countRows()).thenReturn(10L);
        Mockito.when(contactDao.findBatchContacts(Mockito.anyInt(), Mockito.anyInt())).thenReturn(createContacts());
    }

    private List<Contact> createContacts() {
        List<Contact> contacts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            contacts.add(new Contact("contact" + i));
        }
        return contacts;
    }

    @Test
    public void testSucessfullFilterContacts() {
        List<Contact> contacts = contactService.contactFilter("^.*[123].*$");
        Assert.assertEquals(7,contacts.size());
    }
}
