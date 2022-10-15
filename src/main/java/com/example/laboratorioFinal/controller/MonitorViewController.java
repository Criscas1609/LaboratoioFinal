package com.example.laboratorioFinal.controller;

import com.example.laboratorioFinal.HelloApplication;
import com.example.laboratorioFinal.model.Monitor;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MonitorViewController implements Initializable{

    ModelFactoryController mfc= ModelFactoryController.getInstance();
    private Monitor monitor;
    String name;
    String id;
    String career;
    String semester;

    @FXML
    private TableColumn<?, ?> careerMo;

    @FXML
    private ChoiceBox<String> carreraMonitor;

    @FXML
    private TextField codigoMonitor;

    @FXML
    private TableColumn<?, ?> idMo;

    @FXML
    private TableColumn<?, ?> nameMo;

    @FXML
    private TextField nombreMonitor;

    @FXML
    private TableColumn<?, ?> semMo;

    @FXML
    private ChoiceBox<String> semestreMonitor;

    @FXML
    private TableView<Monitor> tableMonitor;

    @FXML
    private TextField inputBuscar;

    @FXML
    void seleccionarElement(ActionEvent event) {
        mfc.selecccionarMonitor(tableMonitor,nombreMonitor,semestreMonitor,codigoMonitor,carreraMonitor);
    }

    @FXML
    void buscarMonitor(ActionEvent event) {
        name = String.valueOf(this.inputBuscar.getText());
        mfc.searchMonitor(name, tableMonitor);
    }

    @FXML
    void crearMonitor(ActionEvent event) {
        getData();
        mfc.newMonitor(name,id,career,semester);
        tableMonitor.setItems(mfc.laboratory.getMonitorService().getMonitorObservableList());
        tableMonitor.refresh();
    }

    @FXML
    void editarMonitor(ActionEvent event) {
        getData();
        Monitor aux = new Monitor(name,id, career, semester);
        mfc.editMonitor(aux,tableMonitor);

    }

    @FXML
    void eliminarMonitor(ActionEvent event) {
        mfc.removeMonitor(tableMonitor);

    }

    @FXML
    void adminView(ActionEvent event) throws IOException {
        HelloApplication.adminViews(event);

    }

    @FXML
    void monitorView(ActionEvent event) throws IOException {
        HelloApplication.monitorViews(event);
    }

    @FXML
    void studentView(ActionEvent event) throws IOException {
        HelloApplication.studentViews(event);
    }
    @FXML
    void MainView(ActionEvent event) throws IOException {
        HelloApplication.mainViews(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        nameMo.setCellValueFactory(new PropertyValueFactory<>("name"));
        idMo.setCellValueFactory(new PropertyValueFactory<>("id"));
        careerMo.setCellValueFactory(new PropertyValueFactory<>("career"));
        semMo.setCellValueFactory(new PropertyValueFactory<>("semester"));

        semestreMonitor.setValue("I");
        semestreMonitor.setItems(mfc.getSemeStudent());

        carreraMonitor.setValue("Ingeniería de Software");
        carreraMonitor.setItems(mfc.getCareerStudent());
    }

    public void getData(){
        name = String.valueOf(this.nombreMonitor.getText());
        id = String.valueOf(this.codigoMonitor.getText());
        semester = String.valueOf(this.semestreMonitor.getValue());
        career = String.valueOf(this.carreraMonitor.getValue());
    }

}
