package com.examenmysqljava.entities.Persons_skills.infrastructure.out;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.examenmysqljava.config.DatabaseConfig;
import com.examenmysqljava.entities.Persons_skills.domain.entity.Persons_skills;
import com.examenmysqljava.entities.Persons_skills.domain.service.Person_SkillsRepository;

public class Person_skillSQLRepository implements Person_SkillsRepository {
    @Override
    public void asignskill(Persons_skills persons_skills) {
        String query = "INSERT INTO persons_skill (registration_date, iperson, idskill) VALUES (?, ?, ?)";
        try (Connection connection = DatabaseConfig.getConnection();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setDate(1, Date.valueOf(persons_skills.getRegistration_date()));
            statement.setInt(2, persons_skills.getIperson());
            statement.setInt(3, persons_skills.getIdskill());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
