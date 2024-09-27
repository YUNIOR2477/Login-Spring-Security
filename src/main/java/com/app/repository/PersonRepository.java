package com.app.repository;

import com.app.entity.Person;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public interface PersonRepository extends CrudRepository<Person,Long> {

    @Query(value = "SELECT p FROM Person p WHERE p.name LIKE %?1% OR p.lastName LIKE %?1%")
    List<Person> findByNameOrLastName(String name);

    @Query(value = "SELECT p FROM Person p WHERE p.document LIKE %?1%")
    Optional<Person> findByDocument(String document);

}
