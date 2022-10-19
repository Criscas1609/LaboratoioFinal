package com.example.laboratorioFinal.services;

import com.example.laboratorioFinal.model.Element;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public interface ElementService {

    void crearElemen(TableView<Element> tblElement, String nombre, String tipo, int cantidad, String uso, String ubicacion, String estado, String id, int precio);
    void editarElemen(Element aux, TableView<Element> tblElement);
    void seleccionarElement(TableView<Element> tblElement, TextField cantidadElemen, ChoiceBox usoElemen,ChoiceBox ubiElemen,ChoiceBox tipoElemen,TextField precioElemen,TextField nombreElemen,TextField idElemen,ChoiceBox estadoElemen);
    void eliminarElemen(TableView<Element> tblElement, TextField cantidadElemen, ChoiceBox usoElemen,ChoiceBox ubiElemen,ChoiceBox tipoElemen,TextField precioElemen,TextField nombreElemen,TextField idElemen,ChoiceBox estadoElemen);
    void buscarElemen(TableView<Element> tblElement, String name);
    void cargarElement(TableView<Element> tblElement);
    void fichastype(Label cantFichas);
    void metalType(Label cantMetal);
    void ruedasType(Label cantRuedas);
    void esferasType(Label cantEsferas);
    void allElements(Label cantElement);
    void availableReport(Label cantDisponibles);
    void movimientoReport(Label cantMov);
    void notAvailableReport(Label cantNoDis);
    void ensambleReport(Label cantEnsamble);
    void estructuraReport(Label cantEstructura);
    void totalPrice(Label precioTotal);

    ObservableList<Element> getObservableListElement();
    ObservableList<String> getTipoElemenList();
    ObservableList<String> getUsoElement();
    ObservableList<String> getUbicationElement();
    ObservableList<String> getStateElement();
}
