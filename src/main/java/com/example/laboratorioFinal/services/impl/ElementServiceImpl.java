package com.example.laboratorioFinal.services.impl;

import com.example.laboratorioFinal.model.Element;
import com.example.laboratorioFinal.services.ElementService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.List;

public class ElementServiceImpl implements ElementService{
    private Element element;
    String nombre;
    String tipo;
    int cantidad;
    String uso;
    String ubicacion;
    String estado;
    String id;
    int precio;
    private List<Element> listElement  = new ArrayList<>();

    public ElementServiceImpl() {
        this.listElement = listElement;
    }

    public List<Element> getListElement() {
        return listElement;
    }

    public void setListElement(List<Element> listElement) {
        this.listElement = listElement;
    }

    ObservableList<Element> elementObservableList= FXCollections.observableArrayList();
    ObservableList<String>tipoElemenList= FXCollections.observableArrayList("Fichas","Piezas_Metal","Esferas","Ruedas");
    ObservableList<String> usoElementList = FXCollections.observableArrayList("ensamble","estructura","movimiento");
    ObservableList<String> ubicationElementList = FXCollections.observableArrayList("A1","B1","C1");
    ObservableList<String> stateElementList = FXCollections.observableArrayList("Disponible","No Disponible");
    public ObservableList<Element> getObservableListElement() {return elementObservableList;}
    public ObservableList<String> getTipoElemenList(){return tipoElemenList;}
    public ObservableList<String> getUsoElement(){return usoElementList;}
    public ObservableList<String> getUbicationElement() {return ubicationElementList;}
    public ObservableList<String> getStateElement() {return stateElementList;}

    @Override
    public void crearElemen(TableView<Element> tblElement, String nombre, String tipo, int cantidad, String uso, String ubicacion, String estado, String id, int precio) {
        Element element = new Element(nombre, tipo, cantidad, uso, ubicacion, estado, id, precio);
        elementObservableList.add(element);
        listElement.add(element);
        tblElement.setItems(elementObservableList);
    }


    public void editarElemen(Element aux, TableView<Element> tblElement) {
        /*seleccionar();*/
        if (element == null){
            alertError("Debe tener un elemento seleccionado","Error");
        }else{
            try {
                if (!elementObservableList.contains(aux)) {
                    fillTable(aux);
                    tblElement.refresh();
                    alertAT("El elemento se ha editado","¡Exito!");
                } else {
                    alertError("El elemento ya existe","Error");
                }
            } catch (NumberFormatException e) {
                alertError("Formato incorrecto","Error");
            }
        }
    }

    @Override
    public void seleccionar(TableView<Element> tblElement, TextField cantidadElemen, ChoiceBox usoElemen, ChoiceBox ubiElemen, ChoiceBox tipoElemen, TextField precioElemen, TextField nombreElemen, TextField idElemen, ChoiceBox estadoElemen) {
       Element element= tblElement.getSelectionModel().getSelectedItem();

    }

    @Override
    public void eliminarElemen(TableView<Element> tblElement, TextField cantidadElemen, ChoiceBox usoElemen, ChoiceBox ubiElemen, ChoiceBox tipoElemen, TextField precioElemen, TextField nombreElemen, TextField idElemen, ChoiceBox estadoElemen) {
        seleccionar(tblElement, cantidadElemen, usoElemen, ubiElemen, tipoElemen, precioElemen, nombreElemen, idElemen, estadoElemen);
        if (element == null){
            alertError("Debe tener un elemento seleccionado","Error");
        }else {
            elementObservableList.remove(element);
            elementObservableList.remove(element);
            tblElement.refresh();
            alertAT("El elemento se ha eliminado","¡Exito!");
        }
    }
    void fillTable(Element element1){
        element.setNombre(element1.getNombre());
        element.setCantidad(element1.getCantidad());
        element.setEstado(element1.getEstado());
        element.setId(element1.getId());
        element.setPrecio(element1.getPrecio());
        element.setTipo(element1.getTipo());
        element.setUbicacion(element1.getUbicacion());
        element.setUso(element1.getUso());

    }
    void fillInput(Element elemen, TableView<Element> tblElement, TextField cantidadElemen, ChoiceBox usoElemen, ChoiceBox ubiElemen, ChoiceBox tipoElemen, TextField precioElemen, TextField nombreElemen, TextField idElemen, ChoiceBox estadoElemen){
        cantidadElemen.setText(String.valueOf(elemen.getCantidad()));
        usoElemen.setValue(String.valueOf(elemen.getUso()));
        ubiElemen.setValue(String.valueOf(elemen.getUbicacion()));
        tipoElemen.setValue(elemen.getTipo());
        precioElemen.setText(String.valueOf(elemen.getPrecio()));
        nombreElemen.setText(String.valueOf(elemen.getNombre()));
        idElemen.setText(String.valueOf(elemen.getId()));
        estadoElemen.setValue(String.valueOf(elemen.getEstado()));

    }
    void alertError(String message, String title){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    void alertAT(String message, String title ){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
