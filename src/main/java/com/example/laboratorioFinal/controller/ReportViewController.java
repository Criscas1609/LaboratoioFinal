package com.example.laboratorioFinal.controller;

import com.example.laboratorioFinal.HelloApplication;
import com.example.laboratorioFinal.model.Student;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class ReportViewController implements Initializable {
    private String search;
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableColumn<?, ?> cantiEl;

    @FXML
    private TableColumn<?, ?> careerEs;

    @FXML
    private TextField codigoReporte;

    @FXML
    private TableColumn<?, ?> idEl;

    @FXML
    private TableColumn<?, ?> idEs;

    @FXML
    private TableColumn<?, ?> localEl;

    @FXML
    private TableColumn<?, ?> nameEl;

    @FXML
    private TableColumn<?, ?> nameEs;

    @FXML
    private TextField nombreBuscarE;

    @FXML
    private TableColumn<?, ?> priceEl;

    @FXML
    private TableColumn<?, ?> semEs;

    @FXML
    private TableColumn<?, ?> stateEl;

    @FXML
    private TableView<?> tableReportEst;

    @FXML
    private TableColumn<?, ?> typeEl;

    @FXML
    private TableColumn<?, ?> useEl;

    @FXML
    void buscarCodigoR(ActionEvent event) {

    }

    @FXML
    void buscarNombre(ActionEvent event) {

    }

    @FXML
    void buscarPrestamoE(ActionEvent event) {
        getData();
    }

    @FXML
    void cantidadPrestamo(ActionEvent event) {

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void MainView(ActionEvent event) throws IOException {
        HelloApplication.mainViews(event);
    }
    @FXML
    void getData(){
        search = String.valueOf(this.nombreBuscarE.getText());
    }
    @FXML
    void fillTable(Student student, Student student1){
        student.setName(student1.getName());
        student.setId(student1.getId());
        student.setCareer(student1.getCareer());
        student.setSemester(student1.getSemester());
    }
}

