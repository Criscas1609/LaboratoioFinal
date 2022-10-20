package com.example.laboratorioFinal.services;

import com.example.laboratorioFinal.model.*;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.util.ArrayList;

public interface ModelFactoryControllerService {
    //login
    Boolean login(String username, String password);

    //Estudiante

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
    void addLoan(String element,String amount,TableView<LoanDetail>tblLoan);
    void finalizarPrestamo(String dateLoan, String deliveryDate, String debtorName,String tipo, String nombreMonitor);
    void eliminarPrestamo(TableView<LoanDetail> tblLoan, TextField cantidadPrestamo,ChoiceBox elemenPrestamo);
    void totalLoan(Label totalPrestamo);
    void botonBuscar(String name,TableView<Loan> tblReportLoan);
    void bestStudent(Label prestamoEs, ArrayList<Student> studentArrayList);

    //Monitor
    void newMonitor(String name, String id, String career, String semester);
    void selecccionarMonitor(TableView<Monitor> tableMonitor, TextField nombreMonitor, ChoiceBox semestreMonitor, TextField codigoMonitor, ChoiceBox carreraMonitor);
    void searchMonitor(String name, TableView<Monitor> tableMonitor);
    void editMonitor(Monitor aux, TableView<Monitor> tableMonitor);
    void removeMonitor(TableView<Monitor> tableMonitor);

    //Elementos
    void crearElemen(TableView<Element> tblElement, String nombre, String tipo, int cantidad, String uso, String ubicacion, String estado, String id, int precio);
    void editarElemen(Element aux, TableView<Element> tblElement);
    void buscarElemen(TableView<Element> tblElement, String name);
    void eliminarElemen(TableView<Element> tblElement, TextField cantidadElemen, ChoiceBox usoElemen,ChoiceBox ubiElemen,ChoiceBox tipoElemen,TextField precioElemen,TextField nombreElemen,TextField idElemen,ChoiceBox estadoElemen);
    void seleccionarElement(TableView<Element> tblElement, TextField cantidadElemen, ChoiceBox usoElemen, ChoiceBox ubiElemen, ChoiceBox tipoElemen, TextField precioElemen, TextField nombreElemen, TextField idElemen, ChoiceBox estadoElemen);


    //Reportes

    void allStudent(Label cantEs);
    void allSoftware(Label cantSoft);
    void allIndus(Label cantIndus);
    void allCivil(Label cantCivil);
    void reportMonitor(Label cantMonitor);
    void monitorsCareer(Label cantMSoft, Label cantMIndus, Label cantMCivil);
    void allAdmin(Label cantProfes, Label cantAdmin);
    void allElements(Label cantElement);
    void fichastype(Label cantFichas);
    void metalType(Label cantMetal);
    void ruedasType(Label cantRuedas);
    void esferasType(Label cantEsferas);
    void availableReport(Label cantDisponibles);
    void movimientoReport(Label cantMov);
    void notAvailableReport(Label cantNoDis);
    void ensambleReport(Label cantEnsamble);
    void estructuraReport(Label cantEstructura);
    void cargarAdmin(TableView<Administrative> tblAdmin);
    void cargarProfe(TableView<Teacher> tblProfes);
    void totalPrice(Label precioTotal);
    void cargarEs(TableView<Student> tablePersonEs);
    void cargarMon(TableView<Monitor> tableMonitor);
    void cargarElement(TableView<Element> tblElement);
}
