package com.app.persistence;

import com.app.entity.Person;

import java.util.List;
import java.util.Optional;

public interface IPersonDAO {

    //Metodo para obtener la lista completa de todas las personas
    List<Person> findAll();

    //Metodo para obtener la lista de personas por su nombre o apellido
    List<Person> findByNameOrLastName(String name);

    //Metodo para obtener una persona por su id
    Optional<Person> findById(Long id);

    //Metodo para obtener una persona por su documento
    Optional<Person> findByDocument(String document);

    //Metodo para guardar una persona
    void save(Person person);

    //Metodo para eliminar una persona
    void deleteById(Long id);
}
