package com.kvashenko.contact_filter.controller;

import com.kvashenko.contact_filter.model.Contact;
import com.kvashenko.contact_filter.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hello")
public class ContactController {
    @Autowired
    private ContactService contactService;

    @GetMapping("contacts")
    private List<Contact> contactFilter(@RequestParam("nameFilter") String nameFilter) {
        return contactService.contactFilter(nameFilter);
    }

    @GetMapping("generateAndSaveContacts")
    private void generateAndSaveContacts(){
        contactService.saveOneMillionRandomContacts();
    }

}
