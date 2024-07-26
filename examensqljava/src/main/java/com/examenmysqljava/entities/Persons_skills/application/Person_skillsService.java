package com.examenmysqljava.entities.Persons_skills.application;

import com.examenmysqljava.entities.Persons_skills.domain.entity.Persons_skills;
import com.examenmysqljava.entities.Persons_skills.domain.service.Person_SkillsRepository;

public class Person_skillsService {
    private final Person_SkillsRepository person_SkillsRepository;

    public Person_skillsService(Person_SkillsRepository person_SkillsRepository) {
        this.person_SkillsRepository = person_SkillsRepository;
    }
    public void asignskill(Persons_skills persons_skills) {
        person_SkillsRepository.asignskill(persons_skills);
    }

}
