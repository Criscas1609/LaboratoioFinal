package com.example.laboratorioFinal.services;

import com.example.laboratorioFinal.model.Element;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public interface ElementService {
    void crearElemen(TableView<Element> tblElement,String nombre, String tipo, int cantidad, String uso, String ubicacion, String estado, String id, int precio);
    void editarElemen(Element aux, TableView<Element> tblElement);
    void seleccionar(TableView<Element> tblElement, TextField cantidadElemen, ChoiceBox usoElemen,ChoiceBox ubiElemen,ChoiceBox tipoElemen,TextField precioElemen,TextField nombreElemen,TextField idElemen,ChoiceBox estadoElemen);
    void eliminarElemen(TableView<Element> tblElement, TextField cantidadElemen, ChoiceBox usoElemen,ChoiceBox ubiElemen,ChoiceBox tipoElemen,TextField precioElemen,TextField nombreElemen,TextField idElemen,ChoiceBox estadoElemen);
    ObservableList<Element> getObservableListElement();
    ObservableList<String> getTipoElemenList();
    ObservableList<String> getUsoElement();
    ObservableList<String> getUbicationElement();
    ObservableList<String> getStateElement();
}
