package com.example.laboratorioFinal.controller;

import com.example.laboratorioFinal.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ReportViewController {

    ModelFactoryController mfc = ModelFactoryController.getInstance();

    @FXML
    private Label canMonitor;

    @FXML
    private Label cantAdmin;

    @FXML
    private Label cantCivil;

    @FXML
    private Label cantDisponibles;

    @FXML
    private Label cantElements;

    @FXML
    private Label cantEnsamble;

    @FXML
    private Label cantEs;

    @FXML
    private Label cantEsferas;

    @FXML
    private Label cantEstructura;

    @FXML
    private Label cantFichas;

    @FXML
    private Label cantIndus;

    @FXML
    private Label cantMCivil;

    @FXML
    private Label cantMIndus;

    @FXML
    private Label cantMSoft;

    @FXML
    private Label cantMetal;

    @FXML
    private Label cantMov;

    @FXML
    private Label cantNoDis;

    @FXML
    private Label cantProfes;

    @FXML
    private Label cantRuedas;

    @FXML
    private Label cantSoft;
    @FXML
    private Label precioTotal;
    @FXML
    private TableColumn<?, ?> colCantiLoan;

    @FXML
    private TableColumn<?, ?> colDeudorLoan;

    @FXML
    private TableColumn<?, ?> colDeudorLoan1;

    @FXML
    private TableColumn<?, ?> colDeudorLoan11;

    @FXML
    private TableColumn<?, ?> colElementLoan;

    @FXML
    private TableColumn<?, ?> colEntregaLoan;

    @FXML
    private TableColumn<?, ?> colPrestamoLoan;

    @FXML
    private TextField inputBuscar;

    @FXML
    private TableView<?> tblLoan;


    @FXML
    void botonBuscar(ActionEvent event) {
    }



    @FXML
    void MainView(ActionEvent event) throws IOException {
        HelloApplication.mainViews(event);
    }



    @FXML
    void loadPerson(ActionEvent event) {
        //Estudiante
        reportAllStudents();
        reportAllSoftwareStudent();
        reportIndus();
        reportCivil();
        //Monitor
        reportAllMonitors();
        careerMonitor();
        //Administrativos
        reportAdmin();

    }

    //Reporte Personas
    @FXML
    void reportAllStudents(){
        mfc.allStudent(cantEs);
    }

    @FXML
    void reportAllSoftwareStudent(){
        mfc.allSoftware(cantSoft);
    }

    @FXML
    void reportIndus() {
        mfc.allIndus(cantIndus);
    }

    @FXML
    void reportCivil() {
        mfc.allCivil(cantCivil);
    }

    @FXML
    void reportAllMonitors(){
        mfc.reportMonitor(canMonitor);
    }

    @FXML
    void careerMonitor(){
        mfc.monitorsCareer(cantMSoft, cantMIndus,cantMCivil);
    }

    @FXML
    void reportAdmin() {
        mfc.allAdmin(cantProfes,cantAdmin);
    }

    //Reporte Elementos

    @FXML
    void loadElements(ActionEvent event) {
        allElements();
        fichastype();
        metalType();
        esferasType();
        ruedasType();
        availableReport();
        notAvailableReport();
        estructuraReport();
        movimientoReport();
        ensambleReport();
        totalPrice();
    }


    @FXML
    void allElements(){
        mfc.allElements(cantElements);
    }

    @FXML
    void fichastype(){
        mfc.fichastype(cantFichas);
    }

    @FXML
    void metalType(){
        mfc.metalType(cantMetal);
    }

    @FXML
    void esferasType(){
        mfc.esferasType(cantEsferas);
    }

    @FXML
    void ruedasType(){
        mfc.ruedasType(cantRuedas);
    }

    @FXML
    void availableReport(){
        mfc.availableReport(cantDisponibles);
    }

    @FXML
    void notAvailableReport(){
        mfc.notAvailableReport(cantNoDis);
    }

    @FXML
    void estructuraReport(){
        mfc.estructuraReport(cantEstructura);
    }

    @FXML
    void movimientoReport(){
        mfc.movimientoReport(cantMov);
    }

    @FXML
    void ensambleReport(){
        mfc.ensambleReport(cantEnsamble);
    }
    @FXML
    void totalPrice(){
        mfc.totalPrice(precioTotal);
    }


}

