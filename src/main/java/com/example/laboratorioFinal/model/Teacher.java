package com.example.laboratorioFinal.model;

import java.util.Objects;

public class Teacher extends Person{
    private String years;
    private String careerTeacher;
    private String asignature;

    public Teacher(String name, String id, String years, String career, String asignature) {
        super(name, id);
        this.years = years;
        this.careerTeacher = career;
        this.asignature = asignature;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public String getCareerTeacher() {
        return careerTeacher;
    }

    public void setCareerTeacher(String career) {
        this.careerTeacher = career;
    }

    public String getAsignature() {
        return asignature;
    }

    public void setAsignature(String asignature) {
        this.asignature = asignature;
    }




}
