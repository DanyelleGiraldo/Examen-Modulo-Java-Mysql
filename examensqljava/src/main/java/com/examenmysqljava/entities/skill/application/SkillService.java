package com.examenmysqljava.entities.skill.application;

import java.util.Optional;

import com.examenmysqljava.entities.skill.domain.entity.Skill;
import com.examenmysqljava.entities.skill.domain.service.SkillRepository;

public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public void createSkill(Skill skill){
        skillRepository.createSkill(skill);
    }

    public Optional<Skill> getSkillByID(int id){
        return skillRepository.getSkillByID(id);
    }
}
