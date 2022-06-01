package ar.com.inna.xcale.challenge.service;

import ar.com.inna.xcale.challenge.model.Contact;
import ar.com.inna.xcale.challenge.repository.IContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {
    @Autowired
    private IContactRepository iContactRepository;

    public Contact Setup(String phoneNumber) {
        return this.iContactRepository.save(new Contact(phoneNumber));
    }
}
