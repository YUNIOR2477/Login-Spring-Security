package com.app.service.implement;

import com.app.entity.Person;
import com.app.persistence.IPersonDAO;
import com.app.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonServiceImpl implements IPersonService {

    @Autowired
    private IPersonDAO personDAO;

    @Override
    public List<Person> findAll() {
        return personDAO.findAll();
    }

    @Override
    public List<Person> findByNameOrLastName(String name) {
        return personDAO.findByNameOrLastName(name);
    }

    @Override
    public Optional<Person> findById(Long id) {
        return personDAO.findById(id);
    }

    @Override
    public Optional<Person> findByDocument(String document) {
        return personDAO.findByDocument(document);
    }

    @Override
    public void save(Person person) {
        personDAO.save(person);
    }

    @Override
    public void deleteById(Long id) {
        personDAO.deleteById(id);
    }
}
