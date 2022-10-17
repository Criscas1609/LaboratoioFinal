package com.example.laboratorioFinal.controller;

import com.example.laboratorioFinal.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;

public class ReportViewController {

    @FXML
    private TableColumn<?, ?> colCantiLoan;

    @FXML
    private TableColumn<?, ?> colDeudorLoan;

    @FXML
    private TableColumn<?, ?> colDeudorLoan1;

    @FXML
    private TableColumn<?, ?> colDeudorLoan11;

    @FXML
    private TableColumn<?, ?> colElementLoan;

    @FXML
    private TableColumn<?, ?> colEntregaLoan;

    @FXML
    private TableColumn<?, ?> colPrestamoLoan;

    @FXML
    private TextField inputBuscar;

    @FXML
    private TableView<?> tblLoan;


    @FXML
    void botonBuscar(ActionEvent event) {
    }



    @FXML
    void MainView(ActionEvent event) throws IOException {
        HelloApplication.mainViews(event);
    }


}

