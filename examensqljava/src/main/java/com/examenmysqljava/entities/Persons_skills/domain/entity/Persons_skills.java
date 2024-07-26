package com.examenmysqljava.entities.Persons_skills.domain.entity;

import java.time.LocalDate;

public class Persons_skills {
    int id;
    LocalDate registration_date;
    int iperson ;
    int idskill ;
    public Persons_skills(LocalDate registration_date, int iperson, int idskill) {
        this.registration_date = registration_date;
        this.iperson = iperson;
        this.idskill = idskill;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public LocalDate getRegistration_date() {
        return registration_date;
    }
    public void setRegistration_date(LocalDate registration_date) {
        this.registration_date = registration_date;
    }
    public int getIperson() {
        return iperson;
    }
    public void setIperson(int iperson) {
        this.iperson = iperson;
    }
    public int getIdskill() {
        return idskill;
    }
    public void setIdskill(int idskill) {
        this.idskill = idskill;
    }

    
}
