package com.examenmysqljava.entities.Persons_skills.infrastructure.in;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;
import java.util.Scanner;

import com.examenmysqljava.entities.Persons.application.PersonService;
import com.examenmysqljava.entities.Persons.domain.entity.Person;
import com.examenmysqljava.entities.Persons_skills.application.Person_skillsService;
import com.examenmysqljava.entities.Persons_skills.domain.entity.Persons_skills;

public class Person_SkillsConsoleAdapter {
    private final Scanner sc = new Scanner(System.in);
    private final PersonService personService;
    private final Person_skillsService person_skillsService;

    
    public Person_SkillsConsoleAdapter(PersonService personService, Person_skillsService person_skillsService) {
        this.personService = personService;
        this.person_skillsService = person_skillsService;
    }


    public void asignSkill() {
        System.out.println("Ingrese el id de la Persona");
        int personId = sc.nextInt();
        sc.nextLine(); 
    
        Optional<Person> person = personService.getPersonById(personId);
    
        person.ifPresentOrElse(a -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    
            System.out.println("Ingrese la fecha de registro (dd-MM-yyyy): ");
            String date = sc.nextLine();
            LocalDate fecha;
            try {
                fecha = LocalDate.parse(date, formatter);
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida. Por favor, use el formato dd-MM-yyyy.");
                return; 
            }
    
            System.out.println("Ingrese el id de la skill.");
            int idSkill = sc.nextInt();
            sc.nextLine(); 
            
            Persons_skills newpersons_skills = new Persons_skills(fecha, personId, idSkill);
            person_skillsService.asignskill(newpersons_skills);
        }, 
        () -> System.out.println("Esa persona no existe"));
    }
}
