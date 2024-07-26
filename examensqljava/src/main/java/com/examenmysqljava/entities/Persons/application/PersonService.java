package com.examenmysqljava.entities.Persons.application;

import java.util.List;
import java.util.Optional;

import com.examenmysqljava.entities.Persons.domain.entity.Person;
import com.examenmysqljava.entities.Persons.domain.service.PersonRepository;

public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void createPerson(Person person) {
        personRepository.save(person);
    }

    public void updatePerson(Person person) {
        personRepository.update(person);
    }

    public Optional<Person> getPersonById(int id) {
        return personRepository.getPersonById(id);
    }

    public List<Person> getPersonBySkill(int id) {
        return personRepository.findBySkill(id);
    }

    public void deletePerson(int id) {
        personRepository.delete(id);
    }

    public void asignskill() {
        personRepository.asignskill();
    }
}
