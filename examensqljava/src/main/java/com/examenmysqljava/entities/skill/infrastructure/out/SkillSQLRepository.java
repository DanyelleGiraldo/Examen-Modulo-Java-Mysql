package com.examenmysqljava.entities.skill.infrastructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.examenmysqljava.config.DatabaseConfig;
import com.examenmysqljava.entities.skill.domain.entity.Skill;
import com.examenmysqljava.entities.skill.domain.service.SkillRepository;

public class SkillSQLRepository implements SkillRepository {

    @Override
    public void createSkill(Skill skill) {
        String query = "INSERT INTO skill(id, name) VALUES (?, ?)";
        try(Connection connection = DatabaseConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)){
                statement.setInt(1, skill.getId());
                statement.setString(2, skill.getName());
                statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Skill> getSkillByID(int id) {
        String query = "SELECT * FROM skill WHERE id = ?";
        try (Connection connection = DatabaseConfig.getConnection();
            PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Skill skill = new Skill(
                        resultSet.getInt("id"),
                        resultSet.getString("name")
                    );
                    return Optional.of(skill); 
                }
            } catch (SQLException e) {
                e.printStackTrace(); 
            }
        } catch (SQLException e) {
            e.printStackTrace(); 
        }
        return Optional.empty();
    }
}
