package com.examenmysqljava.entities.Persons.infrastructure.out;

import java.util.List;
import java.util.Optional;

import com.examenmysqljava.entities.Persons.domain.entity.Person;
import com.examenmysqljava.entities.Persons.domain.service.PersonRepository;

public class PersonSQLRepository implements PersonRepository{

    @Override
    public void save(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'save'");
    }

    @Override
    public void update(Person person) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public List<Person> findBySkill(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findBySkill'");
    }

    @Override
    public Optional<Person> getPersonById(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPersonById'");
    }

    @Override
    public void delete(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public void asignskill() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'asignskill'");
    }


}
