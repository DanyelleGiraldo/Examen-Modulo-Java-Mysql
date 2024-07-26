package com.examenmysqljava.entities.Persons.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.examenmysqljava.config.DatabaseConfig;
import com.examenmysqljava.entities.Persons.domain.entity.Person;
import com.examenmysqljava.entities.Persons.domain.service.PersonRepository;

public class PersonSQLRepository implements PersonRepository {

    @Override
    public void save(Person person) {
        String query = "INSERT INTO persons (id, name, lastname, idcity, address, age, email, idgender) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, person.getId());
            statement.setString(2, person.getName());
            statement.setString(3, person.getLastname());
            statement.setInt(4, person.getIdcity());
            statement.setString(5, person.getAddress());
            statement.setInt(6, person.getAge());
            statement.setString(7, person.getEmail());
            statement.setInt(8, person.getIdgender());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Person person) {
        String query = "UPDATE persons SET name = ?, lastname = ?, idcity = ?, address = ?, age = ?, email = ?, idgender = ? WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, person.getName());
            statement.setString(2, person.getLastname());
            statement.setInt(3, person.getIdcity());
            statement.setString(4, person.getAddress());
            statement.setInt(5, person.getAge());
            statement.setString(6, person.getEmail());
            statement.setInt(7, person.getIdgender());
            statement.setInt(8, person.getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Person> findBySkill(int id) {
        List<Person> persons = new ArrayList<>();
        String query = "SELECT p.* FROM persons p JOIN persons_skill ps ON p.id = ps.iperson WHERE ps.idskill = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    Person person = new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("idcity"),
                        resultSet.getString("address"),
                        resultSet.getInt("age"),
                        resultSet.getString("email"),
                        resultSet.getInt("idgender")
                    );
                    persons.add(person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return persons;
    }

    @Override
    public Optional<Person> getPersonById(int id) {
        String query = "SELECT * FROM persons WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Person person = new Person(
                        resultSet.getInt("id"),
                        resultSet.getString("name"),
                        resultSet.getString("lastname"),
                        resultSet.getInt("idcity"),
                        resultSet.getString("address"),
                        resultSet.getInt("age"),
                        resultSet.getString("email"),
                        resultSet.getInt("idgender")
                    );
                    return Optional.of(person);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    @Override
    public void delete(int id) {
        String query = "CALL deleteperson(?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
}
