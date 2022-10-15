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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        colIdElem.setCellValueFactory(new PropertyValueFactory<>("id"));
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
        mfc.crearElemen(nombre,tipo,cantidad,uso,ubicacion,estado,id,precio);
        tblElement.setItems(mfc.laboratory.getElementService().getObservableListElement());
        tblElement.refresh();

        alert("El elemento se ha creado","¡Exito!");

    }
    @FXML
    void seleccionarElement(ActionEvent event) {

    }

    @FXML
    void buscarElemen(ActionEvent event) {
        String nombre = String.valueOf(this.nombreElemen.getText());
    }

    @FXML
    void editarElemen(ActionEvent event) {
       /* getData();
        Element aux= new Element(nombre,tipo,cantidad,uso,ubicacion,estado,id,precio);
       seleccionar();
        if (element == null){
            alertError("Debe tener un elemento seleccionado","Error");
        }else{
            try {
                getData();
                mfc.editarElemen(nombre,tipo,cantidad,uso,ubicacion,estado,id,precio);
                Element aux= new Element(nombre,tipo,cantidad,uso,ubicacion,estado,id,precio);
                if (!this.mfc.getElementArrayList().contains(aux)) {
                    fillTable(aux);
                    alert("El elemento se ha editado","¡Exito!");
                } else {
                    alertError("El elemento ya existe","Error");
                }
            } catch (NumberFormatException e) {
                alertError("Formato incorrecto","Error");
            }
        }*/
    }

    @FXML
    void eliminarElemen(ActionEvent event) {
        seleccionar();
        if (element == null){
            alertError("Debe tener un elemento seleccionado","Error");
        }else {
            this.mfc.getElementArrayList().remove(element);
            this.tblElement.refresh();
            alert("El elemento se ha eliminado","¡Exito!");
        }
    }

    @FXML
    void seleccionar(/*MouseEvent event*/) {element= this.tblElement.getSelectionModel().getSelectedItem();}

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

    /*@FXML
    void fillTable(Element element1){
        element.setNombre(element1.getNombre());
        element.setCantidad(element1.getCantidad());
        element.setEstado(element1.getEstado());
        element.setId(element1.getId());
        element.setPrecio(element1.getPrecio());
        element.setTipo(element1.getTipo());
        element.setUbicacion(element1.getUbicacion());
        element.setUso(element1.getUso());

    }*/

    @FXML
    void alertError(String message, String title){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void alert(String message, String title ){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();

    }

}

