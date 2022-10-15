package com.example.laboratorioFinal.services;

import com.example.laboratorioFinal.model.*;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public interface ModelFactoryControllerService {
    //login
    Boolean login(String username, String password);

    //Estudiante
    void crearElemen(String nombre, String tipo,int cantidad,String uso, String ubicacion, String estado,String id,int precio);
    void addTable(TableView<Student> tablePersonEs);
    void createStudent(String name, String id, String career, String semester);
    void editStudent(TableView<Student> tablePersonEs, TextField nombreEstudiante, TextField idEstudiante, ChoiceBox<String> semestreEstudiante, ChoiceBox<String> carreraEstudiante, Student student);
    void searchStudent(String name, TableView<Student> tablePersonEs);
    void removeStudent(TableView<Student> tablePersonEs,TextField nombreEstudiante, TextField idEstudiante, ChoiceBox<String> semestreEstudiante, ChoiceBox<String> carreraEstudiante);
    void selectionStudent(TableView<Student> tablePersonEs,TextField nombreEstudiante, TextField idEstudiante, ChoiceBox<String> semestreEstudiante, ChoiceBox<String> carreraEstudiante);

    //Administrativo
    void createAdministrative(TableView<Administrative> tblAdmin, String name, String id, String antiguety, String charger);
    void editAdmin(Administrative aux,TableView<Administrative> tblAdmin);
    void seleccionarAdmin(TableView<Administrative> tblAdmin, TextField nombreAdmin, TextField idAdmin, TextField antiAdmin, ChoiceBox cargoAdmi);
    void eliminateAdmin(TableView<Administrative> tblAdmin, TextField nombreAdmin, TextField idAdmin, TextField antiAdmin, ChoiceBox cargoAdmin);
    void searchAdmin(String name, TableView<Administrative> tblAdmin);

    //Teacher
    void createTeacher(TableView<Teacher> tblProfes, String name, String id, String years, String career, String asignature);
    void editTeacher(Teacher aux,TableView<Teacher> tblProfes);
    void searchTeacher(String name, TableView<Teacher> tblProfes);
    void seleccionarTeacher(TableView<Teacher> tblProfes, TextField nombreProfesor, TextField idProfesor, ChoiceBox carreraProfesor, TextField antiProfesor, ChoiceBox materiaProfesor);
    void eliminateTeacher(TableView<Teacher> tblProfes, TextField nombreProfesor, TextField idProfesor, ChoiceBox carreraProfesor, TextField antiProfesor, ChoiceBox materiaProfesor);

    //Loan
    void addLoan(TableView<Loan> tblLoan, String element, String amount, String dateLoan, String deliveryDate, String debtorName);
    void finalizarPrestamo(String element, String amount, String dateLoan, String deliveryDate, String debtorName);
    void eliminarPrstamo(TableView<Loan> tblLoan, TextField cantidadPrestamo, TextField nombrePrestamista, DatePicker fechaPrestamo, DatePicker entregaPrestamo, ChoiceBox elemenPrestamo);

    //Monitor
    void newMonitor(String name, String id, String career, String semester);
    void selecccionarMonitor(TableView<Monitor> tableMonitor, TextField nombreMonitor, ChoiceBox semestreMonitor, TextField codigoMonitor, ChoiceBox carreraMonitor);
    void searchMonitor(String name, TableView<Monitor> tableMonitor);
    void editMonitor(Monitor aux, TableView<Monitor> tableMonitor);
    void removeMonitor(TableView<Monitor> tableMonitor);

    }
