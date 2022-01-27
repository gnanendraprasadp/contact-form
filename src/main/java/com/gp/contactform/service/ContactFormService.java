package com.gp.contactform.service;

import com.gp.contactform.entity.ContactForm;
import com.gp.contactform.repository.ContactFormRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactFormService {

    @Autowired
    ContactFormRepository contactFormRepository;

    public String addresponse(ContactForm contactForm) {
        contactFormRepository.save(contactForm);
        return "Your response has been recorded";
    }

    public List<ContactForm> getresponse() {
        return contactFormRepository.findAll();
    }

    public String putresponse(ContactForm contactForm, Long contact_id) {
        Optional<ContactForm> optional = contactFormRepository.findById(contact_id);
        if (optional.isPresent()) {
            optional.get().setName(contactForm.getName());
            optional.get().setEmail(contactForm.getEmail());
            optional.get().setMessage(contactForm.getMessage());
            contactFormRepository.save(optional.get());
            return "Your response has been updated";
        } else {
            return "Your response is not updated";
        }
    }

    public String deleteresponse(Long id) {
        Optional<ContactForm> optional = contactFormRepository.findById(id);
        if (optional.isPresent()) {
            contactFormRepository.deleteById(id);
            return "Your response is deleted";
        } else {
            return "Your response not is deleted";
        }
    }
}
