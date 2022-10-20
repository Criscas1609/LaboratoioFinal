package com.example.laboratorioFinal.services.impl;

import com.example.laboratorioFinal.model.Administrative;
import com.example.laboratorioFinal.model.Element;
import com.example.laboratorioFinal.model.Monitor;
import com.example.laboratorioFinal.model.Student;
import com.example.laboratorioFinal.services.MonitorService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.Objects;

public class MonitorServiceImpl implements MonitorService {
    private Monitor monitor;
    private ArrayList<Monitor> monitorArrayList = new ArrayList<>();

    private ObservableList<String> listMonitorNames = FXCollections.observableArrayList();

    public ObservableList<String> getListMonitorNames() {
        return listMonitorNames;
    }


    ObservableList<Monitor> monitorObservableList = FXCollections.observableArrayList();

    public ObservableList<Monitor> getMonitorObservableList() {
        return monitorObservableList;
    }

    public void createMonitor(String name, String id, String career, String semester) {
        Monitor person = new Monitor(name, id, career, semester);
        monitorObservableList.add(person);
        monitorArrayList.add(person);
        listMonitorNames.add(person.getName());
    }

    public void editMonitor(Monitor aux, TableView<Monitor> tableMonitor) {
        if (monitor == null) {
            alertError("Debe tener un elemento seleccionado", "Error");
        } else {
            try {
                if (!monitorObservableList.contains(aux)) {
                    fillTable(aux);
                    editMonitor(aux);
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
            listMonitorNames.remove(monitor.getName());
            tableMonitor.refresh();
            alert("Se ha eliminado correctamente", "Exito");
        }
    }

    //Reportes

    public void reportMonitor(Label cantMonitor){
        String allMonitors = String.valueOf(monitorArrayList.size());
        cantMonitor.setText(allMonitors);
    }

    public void monitorsCareer(Label cantMSoft, Label cantMIndus, Label cantMCivil) {
        int softwareMonitors = 0;
        int indusMonitors = 0;
        int civilMonitors = 0;
        for (Monitor monitor : monitorArrayList) {
            if (monitor.getCareer().equals("Ingeniería de Software")) {
                softwareMonitors++;
            }
            if (monitor.getCareer().equals("Ingeniería Industrial")) {
                indusMonitors++;
            }
            if (monitor.getCareer().equals("Ingeniería Civil")){
                civilMonitors++;
            }
        }
        cantMSoft.setText(String.valueOf(softwareMonitors));
        cantMIndus.setText(String.valueOf(indusMonitors));
        cantMCivil.setText(String.valueOf(civilMonitors));
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

    public void cargarMon(TableView<Monitor> tableMonitor) {
        tableMonitor.setItems(monitorObservableList);
        tableMonitor.refresh();
    }
    public void editMonitor(Monitor monitor) {
        for (Monitor list : monitorArrayList) {
            if (list.getName() == (monitor.getName()) && list.getId() == monitor.getId()) {
                list.setName(monitor.getName());
                list.setId(monitor.getId());
                list.setSemester(monitor.getSemester());
                list.setCareer(monitor.getCareer());
                editListNames();
            }
        }
    }

    public void editListNames() {
        listMonitorNames.clear();
        for (Monitor moni : monitorArrayList) {
            listMonitorNames.add(moni.getName());
        }
    }
}
