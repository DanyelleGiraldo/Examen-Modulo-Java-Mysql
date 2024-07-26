package com.examenmysqljava.entities.skill.infrastructure.in;

import java.util.Optional;
import java.util.Scanner;

import com.examenmysqljava.entities.skill.application.SkillService;
import com.examenmysqljava.entities.skill.domain.entity.Skill;

public class SkillConsoleAdapter {
    private final Scanner sc = new Scanner(System.in);
    private final SkillService skillService;

    public SkillConsoleAdapter(SkillService skillService) {
        this.skillService = skillService;
    }

    public void createskill(){
        String option = "S";

        while(option.equalsIgnoreCase("S")){
            System.out.println("Ingrese el id de la skill a crear");
            int newID = sc.nextInt();
            sc.nextLine();

            Optional<Skill> skill = skillService.getSkillByID(newID);
            skill.ifPresentOrElse(a-> System.out.println("Esta skill ya existe"), 
            ()->{
                System.out.println("Ingrese el nombre de la skill");
                String nameskill = sc.nextLine();

                Skill newskill = new Skill(newID, nameskill);
                skillService.createSkill(newskill);
            });
            System.out.println("Dese crear otra skill?, de ser el caso presione [S] de lo contrario cualquier tecla.");
            option = sc.nextLine();
        }
    }
}
