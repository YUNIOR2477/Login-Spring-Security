package com.app.persistence.implement;

import com.app.entity.Person;
import com.app.persistence.IPersonDAO;
import com.app.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PersonDAOImpl implements IPersonDAO {

    @Autowired
    private PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return (List<Person>) personRepository.findAll();
    }

    @Override
    public List<Person> findByNameOrLastName(String name) {
        return personRepository.findByNameOrLastName(name);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personRepository.findById(id);
    }

    @Override
    public Optional<Person> findByDocument(String document) {
        return personRepository.findByDocument(document);
    }

    @Override
    public void save(Person person) {
        personRepository.save(person);
    }

    @Override
    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }
}
