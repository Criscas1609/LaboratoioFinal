package com.example.laboratorioFinal.controller;
import com.example.laboratorioFinal.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import com.example.laboratorioFinal.model.Student;
import javafx.stage.Stage;

import javax.swing.table.TableRowSorter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class StudentViewController implements Initializable {

    private Student student;

    private String name;
    private String id;
    private String career;
    private String semester;


    ModelFactoryController mfc = ModelFactoryController.getInstance();

    @FXML
    private TableColumn<?, ?> SemEs;

    @FXML
    private TableColumn<?, ?> careerEs;

    @FXML
    private ChoiceBox<String> carreraEstudiante;

    @FXML
    private TableColumn<?, ?> idEs;

    @FXML
    private TextField idEstudiante;

    @FXML
    private TableColumn<?, ?> nameEs;

    @FXML
    private TextField nombreEstudiante;

    @FXML
    private ChoiceBox<String> semestreEstudiante;

    @FXML
    private TableView<Student> tablePersonEs;
    @FXML
    private TextField inputBuscar;

    @FXML
    void seleccionarElement(ActionEvent event) {
        mfc.selectionStudent(tablePersonEs, nombreEstudiante, idEstudiante, semestreEstudiante, carreraEstudiante);
    }


    @FXML
    void botonBuscarE(ActionEvent event) {
        name = String.valueOf(this.inputBuscar.getText());
        mfc.searchStudent(name, tablePersonEs);
    }

    @FXML
    void botonCrearE(ActionEvent event) {
        getData();
        mfc.createStudent(name, id, career, semester);
        mfc.addTable(tablePersonEs);

    }

    @FXML
    void botonEditarE(ActionEvent event) {
        getData();
        Student aux = new Student(name, id, career, semester);
        mfc.editStudent(tablePersonEs, nombreEstudiante, idEstudiante, semestreEstudiante, carreraEstudiante, aux);
    }

    @FXML
    void botonEliminarE(ActionEvent event) {
        getData();
        mfc.removeStudent(tablePersonEs, idEstudiante, nombreEstudiante, semestreEstudiante,carreraEstudiante);
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
        nameEs.setCellValueFactory(new PropertyValueFactory<>("name"));
        idEs.setCellValueFactory(new PropertyValueFactory<>("id"));
        careerEs.setCellValueFactory(new PropertyValueFactory<>("career"));
        SemEs.setCellValueFactory(new PropertyValueFactory<>("semester"));

        semestreEstudiante.setValue("I");
        semestreEstudiante.setItems(mfc.getSemeStudent());

        carreraEstudiante.setValue("Ingeniería de Software");
        carreraEstudiante.setItems(mfc.getCareerStudent());
    }

    @FXML
    void getData() {
        name = String.valueOf(this.nombreEstudiante.getText());
        id = String.valueOf(this.idEstudiante.getText());
        semester = String.valueOf(this.semestreEstudiante.getValue());
        career = String.valueOf(this.carreraEstudiante.getValue());
    }
    @FXML
    void cargarEs(ActionEvent event) {
        mfc.cargarEs(tablePersonEs);
    }
}

