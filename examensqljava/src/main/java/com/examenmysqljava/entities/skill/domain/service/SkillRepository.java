package com.examenmysqljava.entities.skill.domain.service;

import java.util.Optional;

import com.examenmysqljava.entities.skill.domain.entity.Skill;

public interface SkillRepository {
    void createSkill(Skill skill);
    Optional<Skill> getSkillByID(int id);
}
