package com.examenmysqljava.entities.Persons.domain.service;

import java.util.List;
import java.util.Optional;

import com.examenmysqljava.entities.Persons.domain.entity.Person;

public interface PersonRepository {
    void save(Person person);
    void update(Person person);
    List<Person> findBySkill(int id);
    Optional<Person> getPersonById(int id);
    void delete(int id);

}
