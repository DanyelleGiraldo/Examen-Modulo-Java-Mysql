package com.examenmysqljava.View;

import java.util.Scanner;

import com.examenmysqljava.entities.Persons.application.PersonService;
import com.examenmysqljava.entities.Persons.infrastructure.in.PersonConsoleAdapter;
import com.examenmysqljava.entities.Persons.infrastructure.out.PersonSQLRepository;
import com.examenmysqljava.entities.Persons_skills.application.Person_skillsService;
import com.examenmysqljava.entities.Persons_skills.infrastructure.in.Person_SkillsConsoleAdapter;
import com.examenmysqljava.entities.Persons_skills.infrastructure.out.Person_skillSQLRepository;
import com.examenmysqljava.entities.skill.application.SkillService;
import com.examenmysqljava.entities.skill.infrastructure.in.SkillConsoleAdapter;
import com.examenmysqljava.entities.skill.infrastructure.out.SkillSQLRepository;

public class UseView {
    PersonSQLRepository personSQLRepository = new PersonSQLRepository();
    Person_skillSQLRepository person_skillSQLRepository = new Person_skillSQLRepository();
    SkillSQLRepository skillsqlRepository = new SkillSQLRepository();

    PersonService personService = new PersonService(personSQLRepository);
    PersonConsoleAdapter personConsoleAdapter = new PersonConsoleAdapter(personService);

    SkillService skillService = new SkillService(skillsqlRepository);
    SkillConsoleAdapter skillConsoleAdapter = new SkillConsoleAdapter(skillService);

    Person_skillsService person_skillsService = new Person_skillsService(person_skillSQLRepository);
    Person_SkillsConsoleAdapter person_SkillsConsoleAdapter = new Person_SkillsConsoleAdapter(personService, person_skillsService, skillService);



    public void start(){
        Scanner sc = new Scanner(System.in);

        System.out.println("Seleccione una opcion ");
        System.out.println("1.Registrar una Persona");
        System.out.println("2.Asignar una Habilidad a una Persona");
        System.out.println("3: Crear una Nueva Habilidad");
        System.out.println("4: Consultar Personas por Habilidad");
        System.out.println("5: Actualizar Información de una Persona");
        System.out.println("6: Eliminar una Persona");
        int opcion = sc.nextInt();
        sc.nextLine();

        switch (opcion) {
            case 1:
                personConsoleAdapter.createPerson();
                break;
            
            case 2:
                person_SkillsConsoleAdapter.asignSkill();
                break;
            case 3:
                skillConsoleAdapter.createskill();
                break;
            case 4: 
                personConsoleAdapter.searchPersonBySkill();
                break;
            case 5:
                personConsoleAdapter.updatePerson();
                break;
            case 6:
                personConsoleAdapter.deletePerson();
                break;
            default:
                break;
        }
        sc.close();
    }
}
