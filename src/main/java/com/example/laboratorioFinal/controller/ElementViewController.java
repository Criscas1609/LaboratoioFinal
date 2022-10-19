package com.example.laboratorioFinal.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.laboratorioFinal.HelloApplication;
import com.example.laboratorioFinal.controller.ModelFactoryController;
import com.example.laboratorioFinal.model.Element;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;

import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;


public class ElementViewController implements Initializable {

    ModelFactoryController mfc= ModelFactoryController.getInstance();
    private Element element;
    String nombre;
    String tipo;
    int cantidad;
    String uso;
    String ubicacion;
    String estado;
    String id;
    int precio;


    /*
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;*/

    @FXML
    private Button buttonEdit;

    @FXML
    private TableColumn<?, ?> colEstadoEle;

    @FXML
    private TableColumn<?, ?> colIdElem;

    @FXML
    private TableColumn<?, ?> colNombreEle;

    @FXML
    private TableColumn<?, ?> colPrecioElem;

    @FXML
    private TableColumn<?, ?> colTipoEle;

    @FXML
    private TextField inputBuscar;

    @FXML
    private TableColumn<?, ?> colUbiEle;

    @FXML
    private TableColumn<?, ?> colUsoEle;

    @FXML
    private TableColumn<?, ?> conlCantiEle;

    @FXML
    private ChoiceBox<String> estadoElemen;
    @FXML
    private TextField idElemen;

    @FXML
    private TextField nombreElemen;

    @FXML
    private TextField precioElemen;

    @FXML
    private ChoiceBox<String> tipoElemen;
    @FXML
    private ChoiceBox<String> ubiElemen;

    @FXML
    private ChoiceBox<String> usoElemen;
    /* private Alert alert;*/

    @FXML
    private TextField cantidadElemen;

    @FXML
    private TableView<Element> tblElement;

    /* private ObservableList<Element> elements;*/
    @FXML
    void MainView(ActionEvent event) throws IOException {
        HelloApplication.mainViews(event);
    }

    @FXML
    void cargarElement(ActionEvent event) {
        mfc.cargarElement(tblElement);
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colIdElem.setCellValueFactory(new PropertyValueFactory<>("id"));
        conlCantiEle.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colEstadoEle.setCellValueFactory(new PropertyValueFactory<>("estado"));
        colPrecioElem.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colNombreEle.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colTipoEle.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colUbiEle.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));
        colUsoEle.setCellValueFactory(new PropertyValueFactory<>("uso"));

        tipoElemen.setValue("Fichas");
        tipoElemen.setItems(mfc.getTipoElement());

        usoElemen.setValue("ensamble");
        usoElemen.setItems(mfc.getUsoElement());

        ubiElemen.setValue("A1");
        ubiElemen.setItems(mfc.getUbicationElement());

        estadoElemen.setValue("Disponible");
        estadoElemen.setItems(mfc.getStateElement());
    }

    @FXML
    void crearElemen(ActionEvent event) {
        getData();
        mfc.crearElemen(tblElement,nombre,tipo,cantidad,uso,ubicacion,estado,id,precio);


    }
    @FXML
    void seleccionarElement(ActionEvent event) {
        mfc.seleccionarElement(tblElement,cantidadElemen,usoElemen,ubiElemen,tipoElemen,precioElemen,nombreElemen,idElemen,estadoElemen);
    }



    @FXML
    void buscarElemen(ActionEvent event) {
        String nombre = String.valueOf(this.inputBuscar.getText());
        mfc.buscarElemen(tblElement,nombre);
    }

    @FXML
    void editarElemen(ActionEvent event) {
       getData();
       Element aux= new Element(nombre,tipo,cantidad,uso,ubicacion,estado,id,precio);
       mfc.editarElemen(aux,tblElement);

    }

    @FXML
    void eliminarElemen(ActionEvent event) {
        getData();
        mfc.eliminarElemen(tblElement,cantidadElemen,usoElemen,ubiElemen,tipoElemen,precioElemen,nombreElemen,idElemen,estadoElemen);

    }

    @FXML
    void getData(){
        nombre = String.valueOf(this.nombreElemen.getText());
        tipo = String.valueOf(this.tipoElemen.getValue());
        cantidad = Integer.parseInt(this.cantidadElemen.getText());
        uso = String.valueOf(this.usoElemen.getValue());
        ubicacion = String.valueOf(this.ubiElemen.getValue());
        estado = String.valueOf(this.estadoElemen.getValue());
        id = String.valueOf(this.idElemen.getText());
        precio = Integer.parseInt(this.precioElemen.getText());
    }

}

