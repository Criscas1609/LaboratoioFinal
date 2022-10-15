package com.example.laboratorioFinal.controller;

import com.example.laboratorioFinal.HelloApplication;
import com.example.laboratorioFinal.model.Administrative;
import com.example.laboratorioFinal.model.Teacher;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AdministrativeViewController implements Initializable {

   private String nameAdmi;
   private String nameTeacher;
   private String idTeacher;
   private String idAdmi;

   private String antiguatyAdmi;
   private String chargeAdmi;
   private String careerTeacher;
   private String antiguetyTeacher;
   private String asingTeacher;

    ModelFactoryController mfc= ModelFactoryController.getInstance();


    @FXML
    private TextField antiAdmin;
    @FXML
    private TextField inputBuscar;

    @FXML
    private TextField inputBuscarAdmin;

    @FXML
    private TableColumn<?, ?> antiProfes;

    @FXML
    private TextField antiProfesor;

    @FXML
    private ChoiceBox<String> cargoAdmin;

    @FXML
    private TableColumn<?, ?> carreraProfe;

    @FXML
    private ChoiceBox<String> carreraProfesor;

    @FXML
    private TextField idAdmin;

    @FXML
    private TableColumn<?, ?> idProfe;

    @FXML
    private TextField idProfesor;

    @FXML
    private TableColumn<?, ?> materiaProfe;

    @FXML
    private ChoiceBox<String> materiaProfesor;

    @FXML
    private TextField nombreAdmin;

    @FXML
    private TableColumn<?, ?> nombreProfe;

    @FXML
    private TextField nombreProfesor;

    @FXML
    private TableColumn<?, ?> tblAntiAdmin;

    @FXML
    private TableView<Administrative> tblAdmin;

    @FXML
    private TableView<Teacher> tblProfes;

    @FXML
    private TableColumn<?, ?> TblAntiAdminAdmin;

    @FXML
    private TableColumn<?, ?> tblcargoAdmin;

    @FXML
    private TableColumn<?, ?> tblidAdmin;

    @FXML
    private TableColumn<?, ?> tblnombreAdmin;

    @FXML
    void seleccionarAdmin(ActionEvent event) {
        mfc.seleccionarAdmin(tblAdmin, nombreAdmin, idAdmin, antiAdmin, cargoAdmin);
    }

    @FXML
    void seleccionarProfesor(ActionEvent event) {
        mfc.seleccionarTeacher(tblProfes, nombreProfesor, idProfesor, carreraProfesor, antiProfesor, materiaProfesor);
    }


    @FXML
    void buscarAdmin(ActionEvent event) {
        String name = String.valueOf(this.inputBuscarAdmin.getText());
       mfc.searchAdmin(name,tblAdmin);
    }

    @FXML
    void buscarProfesor(ActionEvent event) {
        String name = String.valueOf(this.inputBuscar.getText());
        mfc.searchTeacher(name,tblProfes);

    }

    @FXML
    void crearAdmin(ActionEvent event) {
        getDataAdmi();
        mfc.createAdministrative(tblAdmin,nameAdmi,idAdmi, antiguatyAdmi,chargeAdmi);
        tblAdmin.refresh();
    }

    @FXML
    void crearProfesor(ActionEvent event) {
        getDataTeacher();
        mfc.createTeacher(tblProfes,nameTeacher,idTeacher,antiguetyTeacher,careerTeacher,asingTeacher);
        tblProfes.refresh();
    }

    @FXML
    void editarAdmin(ActionEvent event) {
        getDataAdmi();
        Administrative aux = new Administrative(nameAdmi,idAdmi,antiguatyAdmi,chargeAdmi);
        mfc.editAdmin(aux,tblAdmin);
    }

    @FXML
    void editarProfesor(ActionEvent event) {
        getDataTeacher();
        Teacher aux = new Teacher(nameTeacher,idTeacher,antiguetyTeacher,careerTeacher,asingTeacher);
        mfc.editTeacher(aux,tblProfes);
    }

    @FXML
    void eliminarAdmin(ActionEvent event) {
        getDataAdmi();
        mfc.eliminateAdmin(tblAdmin,nombreAdmin,idAdmin,antiAdmin,cargoAdmin);
    }

    @FXML
    void adminView(ActionEvent event) throws  IOException {
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
    @FXML
    void eliminarProfesor(ActionEvent event) {
        getDataTeacher();
        mfc.eliminateTeacher(tblProfes, nombreProfesor, idProfesor, carreraProfesor, antiProfesor, materiaProfesor);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblnombreAdmin.setCellValueFactory(new PropertyValueFactory<>("name"));
        nombreProfe.setCellValueFactory(new PropertyValueFactory<>("name"));
        tblidAdmin.setCellValueFactory(new PropertyValueFactory<>("id"));
        idProfe.setCellValueFactory(new PropertyValueFactory<>("id"));
        tblcargoAdmin.setCellValueFactory(new PropertyValueFactory<>("charger"));
        carreraProfe.setCellValueFactory(new PropertyValueFactory<>("careerTeacher"));
        System.out.println(careerTeacher);
        tblAntiAdmin.setCellValueFactory(new PropertyValueFactory<>("antiguety"));
        antiProfes.setCellValueFactory(new PropertyValueFactory<>("years"));
        materiaProfe.setCellValueFactory(new PropertyValueFactory<>("asignature"));

        carreraProfesor.setValue("Ingeniería de Software");
        carreraProfesor.setItems(mfc.getCareerTeacher());

        materiaProfesor.setValue("Programacion I");
        materiaProfesor.setItems(mfc.getMatterTeacher());

        cargoAdmin.setValue("jefe de Laboratorio");
        cargoAdmin.setItems(mfc.getCargoAdmi());
    }
    @FXML
    void getDataAdmi(){
        nameAdmi = String.valueOf(this.nombreAdmin.getText());
        idAdmi = String.valueOf(this.idAdmin.getText());
        chargeAdmi = String.valueOf(this.cargoAdmin.getValue());
        antiguatyAdmi = String.valueOf(this.antiAdmin.getText());
    }
    @FXML
    void getDataTeacher(){
        nameTeacher = String.valueOf(this.nombreProfesor.getText());
        idTeacher = String.valueOf(this.idProfesor.getText());
        careerTeacher = String.valueOf(this.carreraProfesor.getValue());
        antiguetyTeacher = String.valueOf((this.antiProfesor.getText()));
        asingTeacher= String.valueOf(this.materiaProfesor.getValue());
    }
/*    @FXML
    void seleccionarAdmin(*//*MouseEvent event*//*) {
        admin = this.tblAdmin.getSelectionModel().getSelectedItem();
    }
   @FXML
    void seleccionarTeacher() {
        teacher = this.tblProfes.getSelectionModel().getSelectedItem();
        fillInputTeacher();
    }*/

/*    @FXML
    void alertError(String message, String title){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void fillTableAdmin(Administrative admin1){
        admin.setName(admin1.getName());
        admin.setAntiguety(admin1.getAntiguety());
        admin.setCharger(admin1.getCharger());
        admin.setId(admin1.getId());

    }
    @FXML
    void fillTableTeacher(Teacher teach){
        teacher.setName(teach.getName());
        teacher.setYears(teach.getYears());
        teacher.setCareerTeacher(teach.getCareerTeacher());
        teacher.setId(teach.getId());
        teacher.setAsignature(teach.getAsignature());
    }
    @FXML
    void alertAT(String message, String title ){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }*/

}
