package com.example.laboratorioFinal.controller;

import com.example.laboratorioFinal.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LoginViewController  {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private TextField txtName;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private PasswordField loginContraseña;

    @FXML
    private TextField loginUsuario;



    @FXML
    public void mainView(ActionEvent event) throws IOException {
        System.out.println(loginContraseña.getText()+loginUsuario.getText());
        boolean x = ModelFactoryController.getInstance().login(loginUsuario.getText(),loginContraseña.getText());
        if(x){
            HelloApplication.mainViews(event);
        }
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public TextField getTxtName() {
        return txtName;
    }

    public void setTxtName(TextField txtName) {
        this.txtName = txtName;
    }

    public ResourceBundle getResources() {
        return resources;
    }

    public void setResources(ResourceBundle resources) {
        this.resources = resources;
    }

    public URL getLocation() {
        return location;
    }

    public void setLocation(URL location) {
        this.location = location;
    }


}
