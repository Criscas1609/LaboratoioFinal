package com.example.laboratorioFinal.services;

import com.example.laboratorioFinal.model.Student;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public interface StudentService {
    void createStudent(String name, String id, String career, String semester);
    ObservableList<Student> getStudentObservableList();
    ObservableList<String> getCareerStudent();
    ObservableList<String> getSemeStudent();
    void searchStudent(String name, TableView<Student> tablePersonEs);
    void addTable(TableView<Student> tablePersonEs);
    void editStudent(TableView<Student> tablePersonEs, TextField nombreEstudiante, TextField idEstudiante, ChoiceBox<String> semestreEstudiante, ChoiceBox<String> carreraEstudiante, Student student);
    void removeStudent(TableView<Student> tablePersonEs,TextField nombreEstudiante, TextField idEstudiante, ChoiceBox<String> semestreEstudiante, ChoiceBox<String> carreraEstudiante);
    void selectionStudent(TableView<Student> tablePersonEs,TextField nombreEstudiante, TextField idEstudiante, ChoiceBox<String> semestreEstudiante, ChoiceBox<String> carreraEstudiante);
}
