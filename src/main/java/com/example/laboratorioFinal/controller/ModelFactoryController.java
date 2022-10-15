package com.example.laboratorioFinal.controller;

import com.example.laboratorioFinal.model.*;
import com.example.laboratorioFinal.services.ModelFactoryControllerService;
import com.example.laboratorioFinal.services.impl.LaboratoryServiceImpl;

import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class ModelFactoryController implements ModelFactoryControllerService {
    LaboratoryServiceImpl laboratory;
    private static class SingletonHolder {
        // El constructor de Singleton puede ser llamado desde aquí al ser protected
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        System.out.println("invocación clase singleton");
        laboratory = new LaboratoryServiceImpl();
    }

    //Funciones login:
    public Boolean login(String user, String password){
        System.out.println(user + password);
        return laboratory.getLoginService().login(user,password);
    }

    @Override
    public void crearElemen(String nombre, String tipo, int cantidad, String uso, String ubicacion, String estado, String id, int precio) {

    }

    //Elementos funciones:
//    public void crearElemen(String nombre, String tipo,int cantidad,String uso, String ubicacion, String estado,String id,int precio){
//        laboratory.getElementService().crearElemen(nombre, tipo, cantidad, uso, ubicacion, estado, id, precio);
//    }
//    public void editarElemen(String nombre, String tipo,int cantidad,String uso, String ubicacion, String estado,String id,int precio){
//        laboratory.getElementService().editarElemen(nombre, tipo, cantidad, uso, ubicacion, estado, id, precio);
//    }

    public ObservableList<Element>getElementArrayList(){return laboratory.getElementService().getObservableListElement();}
    public ObservableList<String>getTipoElement(){
        return laboratory.getElementService().getTipoElemenList();
    }
    public ObservableList<String>getUsoElement(){return laboratory.getElementService().getUsoElement();}
    public ObservableList<String>getUbicationElement(){return laboratory.getElementService().getUbicationElement();}
    public ObservableList<String>getStateElement(){return laboratory.getElementService().getStateElement();}

   // Estudiante funciones:
    public ObservableList<String>getCareerStudent(){return laboratory.getStudentService().getCareerStudent();}
    public ObservableList<String>getSemeStudent(){return laboratory.getStudentService().getSemeStudent();}
    public ObservableList<Student>getStudentArrayList(){return laboratory.getStudentService().getStudentObservableList();}
    public ObservableList<String>getCargoAdmi(){return  laboratory.getAdministrativeService().getCargoAdmi();}
    public ObservableList<String>getCareerTeacher(){return laboratory.getAdministrativeService().getCareerTeacher();}
    public ObservableList<String>getMatterTeacher(){return laboratory.getAdministrativeService().getMatterTeacher();}

    public void addTable(TableView<Student> tablePersonEs){
        laboratory.getStudentService().addTable(tablePersonEs);
    }
    public  void createStudent(String name, String id, String career, String semester){
        laboratory.getStudentService().createStudent(name, id, career, semester);
    }
    public void editStudent(TableView<Student> tablePersonEs,TextField nombreEstudiante, TextField idEstudiante, ChoiceBox<String> semestreEstudiante, ChoiceBox<String> carreraEstudiante,Student student){
        laboratory.getStudentService().editStudent(tablePersonEs, nombreEstudiante, idEstudiante, semestreEstudiante, carreraEstudiante, student);
    }
    public void searchStudent(String name, TableView<Student> tablePersonEs){
        laboratory.getStudentService().searchStudent(name,tablePersonEs);
    }

    public void removeStudent(TableView<Student> tablePersonEs,TextField nombreEstudiante, TextField idEstudiante, ChoiceBox<String> semestreEstudiante, ChoiceBox<String> carreraEstudiante){
        laboratory.getStudentService().removeStudent(tablePersonEs, idEstudiante, nombreEstudiante, semestreEstudiante,carreraEstudiante);
    }


    public void selectionStudent(TableView<Student> tablePersonEs,TextField nombreEstudiante, TextField idEstudiante, ChoiceBox<String> semestreEstudiante, ChoiceBox<String> carreraEstudiante){
        laboratory.getStudentService().selectionStudent(tablePersonEs, nombreEstudiante, idEstudiante, semestreEstudiante, carreraEstudiante);
    }
    // Administrativo funciones

    public  void createAdministrative(TableView<Administrative> tblAdmin,String name, String id, String antiguety, String charger){
        laboratory.getAdministrativeService().createAdministrative(tblAdmin,name, id,antiguety, charger);
    }
    public void editAdmin(Administrative aux,TableView<Administrative> tblAdmin){
        laboratory.getAdministrativeService().editAdmin(aux,tblAdmin);
    }
    public void seleccionarAdmin(TableView<Administrative> tblAdmin, TextField nombreAdmin, TextField idAdmin, TextField antiAdmin, ChoiceBox cargoAdmi){
        laboratory.getAdministrativeService().seleccionarAdmin(tblAdmin, nombreAdmin, idAdmin, antiAdmin, cargoAdmi);
    }
    public void eliminateAdmin(TableView<Administrative> tblAdmin, TextField nombreAdmin, TextField idAdmin, TextField antiAdmin, ChoiceBox cargoAdmin){
        laboratory.getAdministrativeService().eliminateAdmin(tblAdmin, nombreAdmin, idAdmin, antiAdmin, cargoAdmin);
    }
    public void searchAdmin(String name, TableView<Administrative> tblAdmin){laboratory.getAdministrativeService().searchAdmin(name,tblAdmin);}

    // Profesor funciones


    public void createTeacher(TableView<Teacher> tblProfes,String name, String id, String years, String career, String asignature){
        laboratory.getAdministrativeService().createTeacher(tblProfes,name, id, years, career, asignature);
    }
    public void editTeacher(Teacher aux,TableView<Teacher> tblProfes){
        laboratory.getAdministrativeService().editTeacher(aux,tblProfes);
    }
    public void searchTeacher(String name, TableView<Teacher> tblProfes){
        laboratory.getAdministrativeService().searchTeacher(name,tblProfes);
    }
    public void seleccionarTeacher(TableView<Teacher> tblProfes, TextField nombreProfesor, TextField idProfesor, ChoiceBox carreraProfesor, TextField antiProfesor, ChoiceBox materiaProfesor){
        laboratory.getAdministrativeService().seleccionarTeacher(tblProfes, nombreProfesor, idProfesor, carreraProfesor, antiProfesor, materiaProfesor);
    }
    public void eliminateTeacher(TableView<Teacher> tblProfes, TextField nombreProfesor, TextField idProfesor, ChoiceBox carreraProfesor, TextField antiProfesor, ChoiceBox materiaProfesor){
        laboratory.getAdministrativeService().eliminateTeacher(tblProfes, nombreProfesor, idProfesor, carreraProfesor, antiProfesor, materiaProfesor);
    }
    //Loan funciones:
    public void addLoan(TableView<Loan> tblLoan,String element,String amount,String dateLoan,String deliveryDate,String debtorName){
        laboratory.getLoanService().addLoan(tblLoan,element,amount,dateLoan,deliveryDate,debtorName);
    }
    public void finalizarPrestamo(String element, String amount, String dateLoan, String deliveryDate, String debtorName){
        laboratory.getLoanService().finalizarPrestamo(element, amount, dateLoan, deliveryDate, debtorName);
    }
    public void eliminarPrstamo(TableView<Loan> tblLoan, TextField cantidadPrestamo, TextField nombrePrestamista, DatePicker fechaPrestamo, DatePicker entregaPrestamo, ChoiceBox elemenPrestamo){
        laboratory.getLoanService().eliminarPrestamo(tblLoan,cantidadPrestamo,nombrePrestamista,fechaPrestamo,entregaPrestamo,elemenPrestamo);
    }

    // Monitor functions:
    public void newMonitor(String name, String id, String career, String semester){
        laboratory.getMonitorService().createMonitor(name,id,career,semester);

    }
    public ObservableList<Monitor>getMonitorArrayList(){
        return laboratory.getMonitorService().getMonitorObservableList();
    }
    public void selecccionarMonitor(TableView<Monitor> tableMonitor, TextField nombreMonitor, ChoiceBox semestreMonitor, TextField codigoMonitor, ChoiceBox carreraMonitor){
        laboratory.getMonitorService().selecccionarMonitor(tableMonitor, nombreMonitor, semestreMonitor, codigoMonitor, carreraMonitor);
    }
    public void searchMonitor(String name, TableView<Monitor> tableMonitor){
        laboratory.getMonitorService().searchMonitor(name,tableMonitor);
    }

    public void editMonitor(Monitor aux, TableView<Monitor> tableMonitor){
        laboratory.getMonitorService().editMonitor(aux,tableMonitor);
    }
    public void removeMonitor(TableView<Monitor> tableMonitor){
        laboratory.getMonitorService().removeMonitor(tableMonitor);
    }


}

