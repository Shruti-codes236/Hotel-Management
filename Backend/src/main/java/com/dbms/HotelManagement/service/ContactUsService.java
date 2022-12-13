package com.dbms.HotelManagement.service;

import com.dbms.HotelManagement.model.ContactUs;
import com.dbms.HotelManagement.repository.ContactUsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ContactUsService {
    private final ContactUsRepository contactUsRepository;

    @Autowired
    public ContactUsService(ContactUsRepository contactUsRepository) {
        this.contactUsRepository = contactUsRepository;
    }

    public void addQuery(UUID queryID, String name, String contactNumber, String reply, String query, String emailID, UUID customerID) {
        contactUsRepository.submitQuery(queryID, name, contactNumber, reply, query, emailID, customerID);
    }

    public List<ContactUs> getRepliedQuery(UUID customerID) {
        return contactUsRepository.getRepliedQuery(customerID);
    }

    public List<ContactUs> getnullQuery(UUID customerID) {
        return contactUsRepository.getnullQuery(customerID);
    }
}
