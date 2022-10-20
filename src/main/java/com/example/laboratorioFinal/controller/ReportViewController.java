package com.example.laboratorioFinal.controller;

import com.example.laboratorioFinal.HelloApplication;
import com.example.laboratorioFinal.model.Loan;
import com.example.laboratorioFinal.model.LoanDetail;
import com.example.laboratorioFinal.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class ReportViewController implements Initializable {

    ModelFactoryController mfc = ModelFactoryController.getInstance();

    String amount;
    String name;

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
    private Label prestamoElement;

    @FXML
    private Label prestamoEs;

    @FXML
    private Label prestamosMon;

    @FXML
    private Label totalPrestamo;

    @FXML
    private TableView<Loan> tblReportLoan;

    @FXML
    private TableColumn<?, ?> tipoPrestamoTab;

    @FXML
    private TableColumn<LoanDetail, LoanDetail> cantidadElementsTab;

    @FXML
    private TableColumn<?, ?> monitorTab;

    @FXML
    private TableColumn<?, ?> deudorTab;

    @FXML
    private TableColumn<?, ?> entregaPrestamoTab;

    @FXML
    private TableColumn<?, ?> fechaPrestamoTab;
    @FXML
    private TextField inputBuscar;

    @FXML
    void botonBuscar(ActionEvent event) {
         name= String.valueOf(this.inputBuscar.getText());
        mfc.botonBuscar(name,tblReportLoan);
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

    //Reporte de prestamos

    @FXML
    void botonCargar(ActionEvent event) {
        cargarTabla();
        totalLoan();
        bestStudent();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        deudorTab.setCellValueFactory(new PropertyValueFactory<>("debtorName"));
        monitorTab.setCellValueFactory(new PropertyValueFactory<>("nombreMonitor"));
        fechaPrestamoTab.setCellValueFactory(new PropertyValueFactory<>("dateLoan"));
        entregaPrestamoTab.setCellValueFactory(new PropertyValueFactory<>("deliveryDate"));
        tipoPrestamoTab.setCellValueFactory(new PropertyValueFactory<>("tipo"));


    }
    @FXML
    void cargarTabla(){
        tblReportLoan.setItems(mfc.laboratory.getLoanService().getLoanReportList());
        tblReportLoan.refresh();
    }
    @FXML
    void bestStudent(){
        mfc.bestStudent(prestamoEs,mfc.laboratory.getStudentService().getListStudent());
    }

    @FXML
    void totalLoan(){
        mfc.totalLoan(totalPrestamo);
    }

}

