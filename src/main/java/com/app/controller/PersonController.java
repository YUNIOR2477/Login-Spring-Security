package com.app.controller;

import com.app.controller.dto.PersonDTO;
import com.app.entity.Person;
import com.app.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/person")
@PreAuthorize("denyAll()")
public class PersonController {

    @Autowired
    IPersonService personService;

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/findAll")
    public ResponseEntity<?> findAll() {
        List<PersonDTO> personList = personService.findAll().stream().map(person -> PersonDTO.builder()
                .id(person.getId())
                .name(person.getName())
                .lastName(person.getLastName())
                .phone(person.getPhone())
                .document(person.getDocument())
                .location(person.getLocation())
                .user(person.getUser())
                .build()).toList();

        if (personList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else return ResponseEntity.ok(personList);
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/findName/{name}")
    public ResponseEntity<?> findByNameOrLastName(@PathVariable String name) {
        List<PersonDTO> personList = personService.findByNameOrLastName(name).stream().map(person -> PersonDTO.builder()
                .id(person.getId())
                .name(person.getName())
                .lastName(person.getLastName())
                .phone(person.getPhone())
                .document(person.getDocument())
                .location(person.getLocation())
                .user(person.getUser())
                .build()).toList();
        if (personList.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else return ResponseEntity.ok(personList);
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/find/{id}")
    public ResponseEntity<?> findById(@PathVariable Long id) {
        Optional<Person> personOptional = personService.findById(id);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            PersonDTO personDTO = PersonDTO.builder()
                    .id(person.getId())
                    .name(person.getName())
                    .lastName(person.getLastName())
                    .phone(person.getPhone())
                    .document(person.getDocument())
                    .location(person.getLocation())
                    .user(person.getUser())
                    .build();
            return ResponseEntity.ok(personDTO);
        } else return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAuthority('READ')")
    @GetMapping("/findDocument/{document}")
    public ResponseEntity<?> findByDocument(@PathVariable String document) {
        Optional<Person> personOptional = personService.findByDocument(document);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            PersonDTO personDTO = PersonDTO.builder()
                    .id(person.getId())
                    .name(person.getName())
                    .lastName(person.getLastName())
                    .phone(person.getPhone())
                    .document(person.getDocument())
                    .location(person.getLocation())
                    .user(person.getUser())
                    .build();
            return ResponseEntity.ok(personDTO);
        } else return ResponseEntity.notFound().build();
    }

    @PreAuthorize("hasAuthority('CREATED')")
    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody PersonDTO personDTO) throws URISyntaxException {
        if (personDTO.getName().isBlank() || personDTO.getLastName().isBlank() || personDTO.getDocument().isBlank() || personDTO.getLocation().isBlank() || personDTO.getPhone().isBlank()) {
            return ResponseEntity.badRequest().build();
        } else {
            Person person = Person.builder()
                    .name(personDTO.getName())
                    .lastName(personDTO.getLastName())
                    .document(personDTO.getDocument())
                    .location(personDTO.getLocation())
                    .phone(personDTO.getPhone())
                    .user(personDTO.getUser())
                    .build();
            personService.save(person);
            return ResponseEntity.created(new URI("/api/person/save")).build();
        }
    }

    @PreAuthorize("hasAuthority('UPDATE')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody PersonDTO personDTO) {

        Optional<Person> personOptional = personService.findById(id);
        if (personOptional.isPresent()) {
            Person person = personOptional.get();
            person.setName(personDTO.getName());
            person.setPhone(personDTO.getName());
            person.setLastName(personDTO.getLastName());
            person.setDocument(personDTO.getDocument());
            person.setLocation(personDTO.getLocation());
            person.setPhone(personDTO.getPhone());
            person.setUser(personDTO.getUser());
            personService.save(person);
            return ResponseEntity.ok("Persona actualizada correctamente");
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id){
        if (id!=null){
            personService.deleteById(id);
            return ResponseEntity.noContent().build();
        }else return ResponseEntity.badRequest().build();
    }
}
