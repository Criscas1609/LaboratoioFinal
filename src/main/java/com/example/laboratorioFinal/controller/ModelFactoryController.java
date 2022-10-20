package com.example.laboratorioFinal.controller;

import com.example.laboratorioFinal.model.*;
import com.example.laboratorioFinal.services.ModelFactoryControllerService;
import com.example.laboratorioFinal.services.impl.LaboratoryServiceImpl;

import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.util.ArrayList;

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
    //Elementos funciones:

    public void crearElemen(TableView<Element> tblElement, String nombre, String tipo, int cantidad, String uso, String ubicacion, String estado, String id, int precio) {
        laboratory.getElementService().crearElemen(tblElement,nombre,tipo,cantidad,uso,ubicacion,estado,id,precio);
    }

    public void editarElemen(Element aux, TableView<Element> tblElement){
        laboratory.getElementService().editarElemen(aux,tblElement);
    }

    public void seleccionarElement(TableView<Element> tblElement, TextField cantidadElemen, ChoiceBox usoElemen, ChoiceBox ubiElemen, ChoiceBox tipoElemen, TextField precioElemen, TextField nombreElemen, TextField idElemen, ChoiceBox estadoElemen){
        laboratory.getElementService().seleccionarElement(tblElement,cantidadElemen,usoElemen,ubiElemen,tipoElemen,precioElemen,nombreElemen,idElemen,estadoElemen);
    }

    public void buscarElemen(TableView<Element> tblElement, String name){
        laboratory.getElementService().buscarElemen(tblElement, name);
    }

    @Override
    public void eliminarElemen(TableView<Element> tblElement, TextField cantidadElemen, ChoiceBox usoElemen, ChoiceBox ubiElemen, ChoiceBox tipoElemen, TextField precioElemen, TextField nombreElemen, TextField idElemen, ChoiceBox estadoElemen) {
        laboratory.getElementService().eliminarElemen(tblElement,cantidadElemen,usoElemen,ubiElemen,tipoElemen,precioElemen,nombreElemen,idElemen,estadoElemen);
    }

    public void cargarElement(TableView<Element> tblElement){
        laboratory.getElementService().cargarElement(tblElement);
    }


    public ObservableList<Element>getElementArrayList(){return laboratory.getElementService().getObservableListElement();}
    public ObservableList<String>getTipoElement(){
        return laboratory.getElementService().getTipoElemenList();
    }
    public ObservableList<String>getUsoElement(){return laboratory.getElementService().getUsoElement();}
    public ObservableList<String>getUbicationElement(){return laboratory.getElementService().getUbicationElement();}
    public ObservableList<String>getStateElement(){return laboratory.getElementService().getStateElement();}

   // Estudiante funciones:
    public ArrayList<Student> getListStudent(){return laboratory.getStudentService().getListStudent();}
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

    public void cargarEs(TableView<Student> tablePersonEs){
        laboratory.getStudentService().cargarEs(tablePersonEs);
    }

    public void bestStudent(Label prestamoEs,ArrayList<Student> studentArrayList){
        laboratory.getLoanService().bestStudent(prestamoEs, studentArrayList);
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

    public void cargarAdmin(TableView<Administrative> tblAdmin){
        laboratory.getAdministrativeService().cargarAdmin(tblAdmin);
    }
    public void cargarProfe(TableView<Teacher> tblProfes){
        laboratory.getAdministrativeService().cargarProfe(tblProfes);
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
    public ObservableList<LoanDetail>getLoanObservableList(){return laboratory.getLoanService().getLoanObservableList();}
    public void addLoan(String element,String amount,TableView<LoanDetail>tblLoan){
        laboratory.getLoanService().addLoan(element,amount,tblLoan);
    }
public void finalizarPrestamo(String dateLoan, String deliveryDate, String debtorName,String tipo, String nombreMonitor){
        laboratory.getLoanService().finalizarPrestamo(dateLoan, deliveryDate,debtorName,tipo,nombreMonitor);
    }
    public void eliminarPrestamo(TableView<LoanDetail> tblLoan, TextField cantidadPrestamo,ChoiceBox elemenPrestamo){
        laboratory.getLoanService().eliminarPrestamo(tblLoan,cantidadPrestamo,elemenPrestamo);
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

    public void cargarMon(TableView<Monitor> tableMonitor){
        laboratory.getMonitorService().cargarMon(tableMonitor);
    }

    //Reportes

    public void allStudent(Label cantEs){
        laboratory.getStudentService().allStudent(cantEs);
    }
    public void allSoftware(Label cantSoft){
        laboratory.getStudentService().allSoftware(cantSoft);
    }
    public void allIndus(Label cantIndus){
        laboratory.getStudentService().allIndus(cantIndus);
    }

    public void allCivil(Label cantCivil){
        laboratory.getStudentService().allCivil(cantCivil);
    }

    public void reportMonitor(Label cantMonitor){
        laboratory.getMonitorService().reportMonitor(cantMonitor);
    }
    public void monitorsCareer(Label cantMSoft, Label cantMIndus, Label cantMCivil){
        laboratory.getMonitorService().monitorsCareer(cantMSoft, cantMIndus, cantMCivil);
    }

    public void allAdmin(Label cantProfes, Label cantAdmin){
        laboratory.getAdministrativeService().allAdmin(cantProfes, cantAdmin);
    }

//Reportes elementos
    public void allElements(Label cantElement){
        laboratory.getElementService().allElements(cantElement);
    }

    public void fichastype(Label cantFichas){
        laboratory.getElementService().fichastype(cantFichas);
    }

    public void metalType(Label cantMetal){
        laboratory.getElementService().metalType(cantMetal);
    }

    public void ruedasType(Label cantRuedas){
        laboratory.getElementService().ruedasType(cantRuedas);
    }
    public void esferasType(Label cantEsferas){
        laboratory.getElementService().esferasType(cantEsferas);
    }

    public void availableReport(Label cantDisponibles){
        laboratory.getElementService().availableReport(cantDisponibles);
    }
    public void notAvailableReport(Label cantNoDis){
        laboratory.getElementService().notAvailableReport(cantNoDis);
    }
    public void estructuraReport(Label cantEstructura){
        laboratory.getElementService().estructuraReport(cantEstructura);
    }

    public void movimientoReport(Label cantMov){
        laboratory.getElementService().movimientoReport(cantMov);
    }

    public void ensambleReport(Label cantEnsamble){
        laboratory.getElementService().ensambleReport(cantEnsamble);
    }

    public void totalPrice(Label precioTotal){
        laboratory.getElementService().totalPrice(precioTotal);
    }

}

