package com.deepak.realtimeinventorybackend.contact;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ContactResponseDto addContact(@RequestBody ContactCreateDto contactCreateDto) {
        return contactService.addContact(contactCreateDto);
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ContactResponseListDto getAll() {

        return contactService.getAll();
    }


    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ContactResponseDto getById(@PathVariable("id") Long id) {
        return contactService.getById(id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteContact(@PathVariable("id") Long id) {
        contactService.deleteContact(id);
    }

}
