package com.gp.contactform.controller;

import com.gp.contactform.entity.ContactForm;
import com.gp.contactform.service.ContactFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ContactFormController {

    @Autowired
    ContactFormService contactFormService;

    @PostMapping("/postresponse")
    public String postresponse(@RequestBody ContactForm contactForm) {
        return contactFormService.addresponse(contactForm);
    }

    @GetMapping("/getresponse")
    public List<ContactForm> getresponse() {
        return contactFormService.getresponse();
    }

    @PutMapping("/putresponse/{contact_id}")
    public String putresponse(@PathVariable("contact_id") Long id, @RequestBody ContactForm contactForm) {
        return contactFormService.putresponse(contactForm, id);
    }

    @DeleteMapping("/deleteresponse/{contact_id}")
    public String deleteresponse(@PathVariable("contact_id") Long id) {
        return contactFormService.deleteresponse(id);
    }
}
