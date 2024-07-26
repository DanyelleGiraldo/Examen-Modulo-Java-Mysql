package com.examenmysqljava.entities.Persons.infrastructure.in;


import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import com.examenmysqljava.entities.Persons.application.PersonService;
import com.examenmysqljava.entities.Persons.domain.entity.Person;

public class PersonConsoleAdapter {
    private final Scanner sc = new Scanner(System.in);
    private final PersonService personService;

    
    public PersonConsoleAdapter(PersonService personService) {
        this.personService = personService;
    }

    public void createPerson(){
        String option = "S";
        while(option.equalsIgnoreCase("S")){
            System.out.println("Ingrese el id de la persona");
            int newId = sc.nextInt();
            sc.nextLine();

            Optional<Person> person= personService.getPersonById(newId);
            person.ifPresentOrElse(a->{
                System.out.println("Esta persona con este id ya existe");
                System.out.println("Presione cualquier tecla para seguir");
                sc.nextLine();
            }, ()->{
                System.out.println("Ingrese el nombre de la persona");
                String newname = sc.nextLine();

                System.out.println("Ingrese el apellido de la persona");
                String newLastName = sc.nextLine();

                System.out.println("Ingrese el id de la ciudad de la persona");
                int newidcity = sc.nextInt();
                sc.nextLine();

                System.out.println("Ingrese la direccion de la persona");
                String newaddress =sc.nextLine();

                System.out.println("Ingrese la edad de la persona");
                int newage= sc.nextInt();
                sc.nextLine();

                System.out.println("Ingrese el email de la persona");
                String newemail = sc.nextLine();

                System.out.println("Ingrese el id del genero");
                int newidgender = sc.nextInt();
                sc.nextLine();

                Person newperson = new Person(newId, newname, newLastName, newidcity, newaddress, newage, newemail, newidgender);
                personService.createPerson(newperson);
            });
            
        }
    }

    public void searchPersonBySkill() {
        System.out.println("Ingrese el id de la skill a buscar: ");
        int skillID = sc.nextInt();
        sc.nextLine();  
                
        List<Person> persons = personService.getPersonBySkill(skillID);
        
        if (persons.isEmpty()) {
            System.out.println("No hay personas con esa skill");
        } else {
            persons.forEach(person -> 
                System.out.println("ID: " + person.getId() + " Nombre: " + person.getName() + " Apellido: " + person.getLastname() + " Edad: " + person.getAge())
            );
        }
        
        System.out.println("Presione cualquier tecla para continuar...");
        sc.nextLine();
    }

    public void updatePerson(){
        String option = "S";
        while(option.equalsIgnoreCase("S")){
            System.out.println("Ingrese el id de la persona a actualizar");
            int newId = sc.nextInt();
            sc.nextLine();

            Optional<Person> person= personService.getPersonById(newId);
            person.ifPresentOrElse(a->{
                System.out.println("Esta persona con este id no existe");
                System.out.println("Presione cualquier tecla para seguir");
                sc.nextLine();
            }, ()->{
                System.out.println("Ingrese el nombre de la persona");
                String newname = sc.nextLine();

                System.out.println("Ingrese el apellido de la persona");
                String newLastName = sc.nextLine();

                System.out.println("Ingrese el id de la ciudad de la persona");
                int newidcity = sc.nextInt();
                sc.nextLine();

                System.out.println("Ingrese la direccion de la persona");
                String newaddress =sc.nextLine();

                System.out.println("Ingrese la edad de la persona");
                int newage= sc.nextInt();
                sc.nextLine();

                System.out.println("Ingrese el email de la persona");
                String newemail = sc.nextLine();

                System.out.println("Ingrese el id del genero");
                int newidgender = sc.nextInt();
                sc.nextLine();

                Person newperson = new Person(newId, newname, newLastName, newidcity, newaddress, newage, newemail, newidgender);
                personService.updatePerson(newperson);
            });
            System.out.println("Dese actualizar otra persona?, de ser el caso presione [S] de lo contrario cualquier tecla.");
            option = sc.nextLine();
        }
    }

    public void deletePerson(){
        System.out.println("Ingrese el id de la persona a eliminar");
        int personId = sc.nextInt();
        sc.nextLine();

        Optional<Person> person = personService.getPersonById(personId);

        person.ifPresentOrElse(a-> System.out.println("Persona no encontrada")
        , ()-> {
            personService.deletePerson(personId);
            System.out.println("Persona eliminada");
        });
        
        System.out.println("Presione cualquier tecla");
        sc.nextLine();  
    }

    
    


}