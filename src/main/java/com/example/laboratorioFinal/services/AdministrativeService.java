package com.example.laboratorioFinal.services;

import com.example.laboratorioFinal.model.Administrative;
import com.example.laboratorioFinal.model.Teacher;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public interface AdministrativeService {
    void createTeacher(TableView<Teacher> tblProfes,String name, String id, String yearsOfAntiguety, String career, String asignature);
    void createAdministrative(TableView<Administrative> tblAdmin,String name, String id, String antiguety, String charger);
    void searchAdmin(String name, TableView<Administrative> tblAdmin);
    void searchTeacher(String name, TableView<Teacher> tblProfes);
    void editAdmin(Administrative aux,TableView<Administrative> tblAdmin);
    void editTeacher(Teacher aux,TableView<Teacher> tblProfes);
    void seleccionarAdmin(TableView<Administrative> tblAdmin, TextField nombreAdmin, TextField idAdmin, TextField antiAdmin, ChoiceBox cargoAdmin);
    void seleccionarTeacher(TableView<Teacher> tblProfes, TextField nombreProfesor, TextField idProfesor, ChoiceBox carreraProfesor, TextField antiProfesor, ChoiceBox materiaProfesor);
    void eliminateAdmin(TableView<Administrative> tblAdmin, TextField nombreAdmin, TextField idAdmin, TextField antiAdmin, ChoiceBox cargoAdmin);
    void eliminateTeacher(TableView<Teacher> tblProfes, TextField nombreProfesor, TextField idProfesor, ChoiceBox carreraProfesor, TextField antiProfesor, ChoiceBox materiaProfesor);
    ObservableList<String> getCargoAdmi();
    ObservableList<String> getCareerTeacher();
    ObservableList<String> getMatterTeacher();
    ObservableList<Teacher> getTeacherObservableList();
    ObservableList<Administrative> getAdministrativeObservableList();
    void allAdmin(Label cantProfes, Label cantAdmin);
    void cargarAdmin(TableView<Administrative> tblAdmin);
    void cargarProfe(TableView<Teacher> tblProfes);
}
