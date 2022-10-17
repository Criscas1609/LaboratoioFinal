package com.example.laboratorioFinal.services.impl;

import com.example.laboratorioFinal.model.Administrative;
import com.example.laboratorioFinal.model.Monitor;
import com.example.laboratorioFinal.model.Student;
import com.example.laboratorioFinal.services.MonitorService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.ArrayList;
import java.util.Objects;

public class MonitorServiceImpl implements MonitorService {
    private ArrayList<Monitor> monitorArrayList = new ArrayList<>();
    private Monitor monitor;
    ObservableList<Monitor> monitorObservableList = FXCollections.observableArrayList();

    public ObservableList<Monitor> getMonitorObservableList() {
        return monitorObservableList;
    }

    public void createMonitor(String name, String id, String career, String semester) {
        Monitor person = new Monitor(name, id, career, semester);
        monitorObservableList.add(person);
        monitorArrayList.add(person);
    }

    public void editMonitor(Monitor aux, TableView<Monitor> tableMonitor) {
        if (monitor == null) {
            alertError("Debe tener un elemento seleccionado", "Error");
        } else {
            try {
                if (!monitorObservableList.contains(aux)) {
                    fillTable(aux);
                    tableMonitor.refresh();
                    alert("El editado se ha creado", "¡Exito!");
                } else {
                    alertError("El estudiante ya existe", "Error");
                }
            } catch (NumberFormatException e) {
                alert("Formato incorrecto", "Error");
            }
        }
    }
    public void selecccionarMonitor(TableView<Monitor> tableMonitor, TextField nombreMonitor, ChoiceBox semestreMonitor, TextField codigoMonitor, ChoiceBox carreraMonitor){
        monitor = tableMonitor.getSelectionModel().getSelectedItem();
        fillInput(monitor,nombreMonitor,semestreMonitor,codigoMonitor,carreraMonitor);

    }
    public void searchMonitor(String name, TableView<Monitor> tableMonitor) {
        for (Monitor monitor1 : monitorObservableList) {
            if (Objects.equals(monitor1.getName(), name) || Objects.equals(monitor1.getId(), name)) {
                tableMonitor.getSelectionModel().select(monitor1);
                tableMonitor.refresh();
            }
        }
    }

    public void removeMonitor(TableView<Monitor> tableMonitor) {
        if (monitor == null) {
            alert("Debe tener un estudiante seleccionado", "Error");
        } else {
            monitorObservableList.remove(monitor);
            monitorArrayList.remove(monitor);
            tableMonitor.refresh();
            alert("Se ha eliminado correctamente", "Exito");
        }
    }


        //Funciones auxiliares
    public void fillTable(Monitor aux) {
        monitor.setCareer(aux.getCareer());
        monitor.setId(aux.getId());
        monitor.setSemester(aux.getSemester());
        monitor.setName(aux.getName());
    }
    void fillInput(Monitor monitor1,TextField nombreMonitor, ChoiceBox semestreMonitor, TextField codigoMonitor, ChoiceBox carreraMonitor) {
        nombreMonitor.setText(monitor1.getName());
        codigoMonitor.setText(monitor1.getId());
        semestreMonitor.setValue(monitor1.getSemester());
        carreraMonitor.setValue(monitor1.getCareer());
    }
    void alertError(String message, String title){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    void alert(String message, String title ){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}