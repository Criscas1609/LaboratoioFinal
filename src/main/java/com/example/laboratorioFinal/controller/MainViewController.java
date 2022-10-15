package com.example.laboratorioFinal.controller;

import com.example.laboratorioFinal.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class MainViewController {
    private LoginViewController loginController;
    private Stage stage;
    private Parent root;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void elementView(ActionEvent event) throws IOException {
        HelloApplication.elementsViews(event);
    }

    @FXML
    void loanView(ActionEvent event) throws IOException {
        HelloApplication.loanViews(event);

    }

    @FXML
    void personView(ActionEvent event) throws IOException {
        HelloApplication.studentViews(event);
    }

    @FXML
    void reportView(ActionEvent event) throws IOException {
       HelloApplication.reportViews(event);
    }



    public void init( Stage stage, LoginViewController loginViewController) {
    this.loginController = loginViewController;
    this.stage = stage;
    }
}
