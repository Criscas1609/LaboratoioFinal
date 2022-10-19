package com.example.laboratorioFinal.services.impl;

import com.example.laboratorioFinal.model.Element;
import com.example.laboratorioFinal.model.Teacher;
import com.example.laboratorioFinal.services.ElementService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
    ObservableList<String> usoElementList = FXCollections.observableArrayList("Ensamble","Estructura","Movimiento");
    ObservableList<String> ubicationElementList = FXCollections.observableArrayList("A1","B1","C1");
    ObservableList<String> stateElementList = FXCollections.observableArrayList("Disponible","No Disponible");
    public ObservableList<Element> getObservableListElement() {return elementObservableList;}
    public ObservableList<String> getTipoElemenList(){return tipoElemenList;}
    public ObservableList<String> getUsoElement(){return usoElementList;}
    public ObservableList<String> getUbicationElement() {return ubicationElementList;}
    public ObservableList<String> getStateElement() {return stateElementList;}


    public void crearElemen(TableView<Element> tblElement, String nombre, String tipo, int cantidad, String uso, String ubicacion, String estado, String id, int precio) {
        Element element = new Element(nombre, tipo, cantidad, uso, ubicacion, estado, id, precio);
        System.out.println(element.getNombre());
        elementObservableList.add(element);
        listElement.add(element);
        tblElement.setItems(elementObservableList);
        tblElement.refresh();
        alertAT("El elemento se ha creado","¡Exito!");
    }


    public void editarElemen(Element aux, TableView<Element> tblElement) {
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

    public void buscarElemen(TableView<Element> tblElement, String name){
        for (Element element1 : elementObservableList) {
            if (Objects.equals(element1.getNombre(), name) || Objects.equals(element1.getId(), name)) {
                tblElement.getSelectionModel().select(element1);
                tblElement.refresh();
            }
        }
    }
    public void seleccionarElement(TableView<Element> tblElement, TextField cantidadElemen, ChoiceBox usoElemen, ChoiceBox ubiElemen, ChoiceBox tipoElemen, TextField precioElemen, TextField nombreElemen, TextField idElemen, ChoiceBox estadoElemen) {
       element = tblElement.getSelectionModel().getSelectedItem();
       fillInput(element,tblElement,cantidadElemen,usoElemen,ubiElemen,tipoElemen,precioElemen,nombreElemen,idElemen,estadoElemen);

    }


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


    //Reportes

    public void allElements(Label cantElement){
        int allElements = listElement.size();
        cantElement.setText(String.valueOf(allElements));
    }
    public void fichastype(Label cantFichas){
        int fichastype=0;
        for (Element element : listElement){
            if (element.getTipo().equals("Fichas")){
                fichastype++;
            }
        }
        cantFichas.setText(String.valueOf(fichastype));
    }

    public void metalType(Label cantMetal){
        int metalType=0;
        for (Element element : listElement){
            if (element.getTipo().equals("Piezas_Metal")){
                metalType++;
            }
        }
        cantMetal.setText(String.valueOf(metalType));
    }

    public void esferasType(Label cantEsferas){
        int esferasType=0;
        for (Element element : listElement){
            if (element.getTipo().equals("Piezas_Metal")){
                esferasType++;
            }
        }
        cantEsferas.setText(String.valueOf(esferasType));
    }

    public void ruedasType(Label cantRuedas){
        int ruedasType=0;
        for (Element element : listElement){
            if (element.getTipo().equals("Piezas_Metal")){
                ruedasType++;
            }
        }
        cantRuedas.setText(String.valueOf(ruedasType));
    }

    public void availableReport(Label cantDisponibles){
        int availableElements = 0;
        for (Element element : listElement){
            if (element.getEstado().equals("Disponible")){
                availableElements++;
            }
        }
        cantDisponibles.setText(String.valueOf(availableElements));
    }

    public void notAvailableReport(Label cantNoDis){
        int notAvailableElements = 0;
        for (Element element : listElement){
            if (element.getEstado().equals("No Disponible")){
                notAvailableElements++;
            }
        }
        cantNoDis.setText(String.valueOf(notAvailableElements));
    }

    public void ensambleReport(Label cantEnsamble){
        int ensambleElements = 0;
        for (Element element : listElement){
            if (element.getUso().equals("Ensamble")){
                ensambleElements++;
            }
        }
        cantEnsamble.setText(String.valueOf(ensambleElements));
    }

    public void estructuraReport(Label cantEstructura){
        int estructuraElements = 0;
        for (Element element : listElement){
            if (element.getUso().equals("Ensamble")){
                estructuraElements++;
            }
        }
        cantEstructura.setText(String.valueOf(estructuraElements));
    }
    public void movimientoReport(Label cantMov){
        int movimientoElements = 0;
        for (Element element : listElement){
            if (element.getUso().equals("Ensamble")){
                movimientoElements++;
            }
        }
        cantMov.setText(String.valueOf(movimientoElements));
    }

    public void totalPrice(Label precioTotal){
        int totalPrice = 0;
        for (Element element : listElement){
            totalPrice += element.getPrecio()* element.getCantidad();
            }

        precioTotal.setText(String.valueOf(totalPrice));
    }



   //Otras funciones
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

    public void cargarElement(TableView<Element> tblElement) {
        tblElement.setItems(elementObservableList);
        tblElement.refresh();
    }
}
