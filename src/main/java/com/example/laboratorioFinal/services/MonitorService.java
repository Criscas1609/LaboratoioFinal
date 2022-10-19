package com.example.laboratorioFinal.services;

import com.example.laboratorioFinal.model.Monitor;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;

public interface MonitorService {
    void createMonitor(String name, String id, String career, String semester);
    ObservableList <Monitor> getMonitorObservableList();
    void selecccionarMonitor(TableView<Monitor> tableMonitor, TextField nombreMonitor, ChoiceBox semestreMonitor, TextField codigoMonitor, ChoiceBox carreraMonitor);
    void searchMonitor(String name, TableView<Monitor> tableMonitor);
    void editMonitor(Monitor aux, TableView<Monitor> tableMonitor);
    void removeMonitor(TableView<Monitor> tableMonitor);

    void reportMonitor(Label cantMonitor);
    void monitorsCareer(Label cantMSoft, Label cantMIndus, Label cantMCivil);
    void cargarMon(TableView<Monitor> tableMonitor);
}
