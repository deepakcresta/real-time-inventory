package com.deepak.realtimeinventorybackend.contact;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    public ContactRepository contactRepository;

    public ContactResponseDto addContact(ContactCreateDto contactCreateDto) {
        Contact contact = new Contact();

        contact.setName(contactCreateDto.getName());
        contact.setPhoneNumber(contactCreateDto.getPhoneNumber());
        contact.setEmail(contactCreateDto.getEmail());
        contact.setMessage(contactCreateDto.getMessage());

        Contact savedContact = contactRepository.save(contact);
        ContactResponseDto response = new ContactResponseDto();
        response.setEmail(savedContact.getEmail());
        response.setName(savedContact.getName());
        response.setPhoneNumber(savedContact.getPhoneNumber());
        return response;


    }

    public ContactResponseDto getContactResponseDto(Contact savedContact) {
        ContactResponseDto response = new ContactResponseDto();
            response.setId(savedContact.getId());
            response.setName(savedContact.getName());
            response.setEmail(savedContact.getEmail());
            response.setPhoneNumber(savedContact.getPhoneNumber());
            response.setMessage(savedContact.getMessage());
        return response;
    }

    public ContactResponseListDto getAll() {
        List<ContactResponseDto> contactResponseList = new ArrayList<>();
        List<Contact> contact = (List<Contact>) contactRepository.findAll();

        for (Contact contacts : contact) {
            contactResponseList.add(getContactResponseDto(contacts));
        }
        ContactResponseListDto response = new ContactResponseListDto();
        response.setContacts(contactResponseList);
        response.setTotal((long) contact.size());

        return response;
    }


    public ContactResponseDto getById(Long id) {
        Optional<Contact> optionalContact = contactRepository.findById(id);
        if (optionalContact.isPresent()) {
            return getContactResponseDto(optionalContact.get());
        }
        return null;
    }

   @Transactional
    public void deleteContact(Long id) {
        contactRepository.deleteById(id);
    }

}
