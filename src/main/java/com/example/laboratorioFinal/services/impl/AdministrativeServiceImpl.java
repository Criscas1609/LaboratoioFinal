
package com.example.laboratorioFinal.services.impl;

import com.example.laboratorioFinal.model.Administrative;
import com.example.laboratorioFinal.model.Student;
import com.example.laboratorioFinal.model.Teacher;
import com.example.laboratorioFinal.services.AdministrativeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.ChoiceBox;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Collection;
import java.util.Objects;

public class AdministrativeServiceImpl implements AdministrativeService {
    public List<Teacher> tutorArrayList = new ArrayList<>();
    public List<Administrative> adminArrayList = new ArrayList<>();

    private Administrative admin;
    private Teacher teacher;

    String nameAdmi;
    String nameTeacher;
    String idTeacher;
    String idAdmi;

    String antiguatyAdmi;
    String chargeAdmi;
    String careerTeach;
    String antiguetyTeacher;
    String asingTeacher;

    ObservableList<Administrative> administrativeObservableList = FXCollections.observableArrayList();
    ObservableList<Teacher> teacherObservableList = FXCollections.observableArrayList();
    ObservableList<String> cargoAdmi = FXCollections.observableArrayList("Contador", "Coordinador@ Academica", "Secretaria", "Coordinadora de Proyección Social",
            "Decano", "Coordinador@ Investigación", "jefe de Laboratorio");
    ObservableList<String> careerTeacher = FXCollections.observableArrayList("Ingeniería de Software", "Ingeniería Industrial", "Ingeniería Civil");
    ObservableList<String> matterTeacher = FXCollections.observableArrayList("Programcion I", "Algoritmo y logica computacional",
            "Ciencia de los materiales", "Economia", "Fisica Mecanica", "Algebra Lineal");

    public ObservableList<Administrative> getAdministrativeObservableList() {
        return administrativeObservableList;
    }

    public ObservableList<Teacher> getTeacherObservableList() {
        return teacherObservableList;
    }

    public ObservableList<String> getCargoAdmi() {
        return cargoAdmi;
    }

    public ObservableList<String> getCareerTeacher() {
        return careerTeacher;
    }

    public ObservableList<String> getMatterTeacher() {
        return matterTeacher;
    }

    public void createTeacher( TableView<Teacher> tblProfes, String name, String id, String years, String career, String asignature) {
        Teacher person = new Teacher(name, id, years, career, asignature);
        teacherObservableList.add(person);
        tutorArrayList.add(person);
        tblProfes.setItems(teacherObservableList);
    }


    public void createAdministrative(TableView<Administrative> tblAdmin,String name, String id, String antiguety, String charger) {
        Administrative person = new Administrative(name, id, antiguety, charger);
        administrativeObservableList.add(person);
        adminArrayList.add(person);
        tblAdmin.setItems(administrativeObservableList);
    }
    public void editAdmin(Administrative aux,TableView<Administrative> tblAdmin){
        if(admin ==null){
            alertError("Debe tener un elemento seleccionado","Error");
        }else{
            try{
                if (!administrativeObservableList.contains(aux)) {
                    fillTableAdmin(aux);
                    tblAdmin.refresh();
                    alertAT("El elemento se ha editado","¡Exito!");
                } else {
                    alertError("El elemento ya existe","Error");
                }
            }catch (NumberFormatException e) {
                alertError("Formato incorrecto","Error");
            }
        }
    }
    public void editTeacher(Teacher auxT,TableView<Teacher> tblProfes){
        if (teacher == null){
            alertError("Debe tener un elemento seleccionado","Error");
        }else{
            try {
                if (!teacherObservableList.contains(auxT)) {
                    fillTableTeacher(auxT);
                    tblProfes.refresh();
                    alertAT("El profesor se ha editado","¡Exito!");
                } else {
                    alertError("El elemento ya existe","Error");
                }
            } catch (NumberFormatException e) {
                alertError("Formato incorrecto","Error");
            }
        }
    }
    public void searchAdmin(String name, TableView<Administrative> tblAdmin) {
        for (Administrative administrative : administrativeObservableList) {
            if (Objects.equals(administrative.getName(), name) || Objects.equals(administrative.getId(), name)) {
                tblAdmin.getSelectionModel().select(administrative);
                tblAdmin.refresh();
            }
        }

    }
    public void eliminateAdmin(TableView<Administrative> tblAdmin, TextField nombreAdmin, TextField idAdmin, TextField antiAdmin, ChoiceBox cargoAdmin){
        if (admin == null){
            alertError("Debe tener un elemento seleccionado","Error");
        }else {
            administrativeObservableList.remove(admin);
            adminArrayList.remove(admin);
            tblAdmin.refresh();
            alertAT("El elemento se ha eliminado","¡Exito!");
        }
    }
    public void eliminateTeacher(TableView<Teacher> tblProfes, TextField nombreProfesor, TextField idProfesor, ChoiceBox carreraProfesor, TextField antiProfesor, ChoiceBox materiaProfesor){
        seleccionarTeacher(tblProfes, nombreProfesor, idProfesor, carreraProfesor, antiProfesor, materiaProfesor);
        if (teacher == null){
            alertError("Debe tener un profesor seleccionado","Error");
        }else {
            teacherObservableList.remove(teacher);
            teacherObservableList.remove(teacher);
            tblProfes.refresh();
            alertAT("El elemento se ha eliminado", "¡Exito!");
        }
    }
    public void searchTeacher(String name, TableView<Teacher> tblProfes) {
        for (Teacher teacher : teacherObservableList) {
            if (Objects.equals(teacher.getName(), name) || Objects.equals(teacher.getId(), name)) {
                tblProfes.getSelectionModel().select(teacher);
                tblProfes.refresh();
            }
        }

    }

    //Reportes
    public void allAdmin(Label cantProfes,Label cantAdmin){
        String allAdmin = String.valueOf(adminArrayList.size());
        String allTeacher = String.valueOf(tutorArrayList.size());
        cantProfes.setText(allTeacher);
        cantAdmin.setText(allAdmin);

    }




//Funciones aparte

    void fillInputTeacher( TableView<Teacher> tblProfes, TextField nombreProfesor, TextField idProfesor, ChoiceBox carreraProfesor, TextField antiProfesor, ChoiceBox materiaProfesor) {
        nombreProfesor.setText(teacher.getName());
        idProfesor.setText(teacher.getId());
        carreraProfesor.setValue(teacher.getCareerTeacher());
        antiProfesor.setText(teacher.getYears());
        materiaProfesor.setValue(teacher.getAsignature());
    }


    void fillInputAdmi( TableView<Administrative> tblAdmin, TextField nombreAdmin, TextField idAdmin, TextField antiAdmin, ChoiceBox cargoAdmi) {
        nombreAdmin.setText(admin.getName());
        idAdmin.setText(admin.getId());
        antiAdmin.setText(admin.getAntiguety());
        cargoAdmi.setValue(admin.getCharger());
    }


    public  void seleccionarTeacher(TableView<Teacher> tblProfes, TextField nombreProfesor, TextField idProfesor, ChoiceBox carreraProfesor, TextField antiProfesor, ChoiceBox materiaProfesor) {
        teacher = tblProfes.getSelectionModel().getSelectedItem();
        fillInputTeacher(tblProfes, nombreProfesor, idProfesor, carreraProfesor, antiProfesor, materiaProfesor);
    }

     public void  seleccionarAdmin(TableView<Administrative> tblAdmin, TextField nombreAdmin, TextField idAdmin, TextField antiAdmin, ChoiceBox cargoAdmi) {
         admin = tblAdmin.getSelectionModel().getSelectedItem();
        fillInputAdmi( tblAdmin, nombreAdmin, idAdmin, antiAdmin, cargoAdmi);
    }

    void fillTableAdmin(Administrative admin1){
        admin.setName(admin1.getName());
        admin.setAntiguety(admin1.getAntiguety());
        admin.setCharger(admin1.getCharger());
        admin.setId(admin1.getId());
    }

    void fillTableTeacher(Teacher teach){
        teacher.setName(teach.getName());
        teacher.setYears(teach.getYears());
        teacher.setCareerTeacher(teach.getCareerTeacher());
        teacher.setId(teach.getId());
        teacher.setAsignature(teach.getAsignature());
    }

    void alertError(String message, String title){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    void alertAT(String message, String title ){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public void cargarProfe(TableView<Teacher> tblProfes){
        tblProfes.setItems(teacherObservableList);
        tblProfes.refresh();
    }
    public void cargarAdmin(TableView<Administrative> tblAdmin){
        tblAdmin.setItems(administrativeObservableList);
        tblAdmin.refresh();
    }

}



