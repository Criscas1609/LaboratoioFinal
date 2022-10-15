package com.example.laboratorioFinal.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.laboratorioFinal.HelloApplication;
import com.example.laboratorioFinal.model.Loan;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import org.kordamp.bootstrapfx.BootstrapFX;

public class LoanViewController implements Initializable {

    ModelFactoryController mfc= ModelFactoryController.getInstance();
    private Loan loan;
    String element;
    String amount;
    String dateLoan;
    String deliveryDate;
    String debtorName;

   /* @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;*/

    @FXML
    private TextField cantidadPrestamo;

    @FXML
    private TableColumn<?, ?> colCantiLoan;

    @FXML
    private TableColumn<?, ?> colElementLoan;

    @FXML
    private TableColumn<?, ?> colEntregaLoan;

    @FXML
    private TableColumn<?, ?> colDeudorLoan;

    @FXML
    private TableColumn<?, ?> colPrestamoLoan;

    @FXML
    private ChoiceBox<?> elemenPrestamo;

    @FXML
    private DatePicker entregaPrestamo;

    @FXML
    private CheckBox externo;

    @FXML
    private DatePicker fechaPrestamo;

    @FXML
    private CheckBox interno;

    @FXML
    private TextField nombreMonitorPrestamo;

    @FXML
    private TextField nombrePrestamista;

    @FXML
    private TableView<Loan> tblLoan;

    @FXML
    void addLoan(ActionEvent event) {
        getData();
        mfc.addLoan(tblLoan,debtorName, element, amount, dateLoan, deliveryDate);
        tblLoan.refresh();

        /*alert("El prestamo se ha añadido","¡Exito!");*/
    }

    @FXML
    void eliminarPrestamo(ActionEvent event) {
        mfc.eliminarPrstamo(tblLoan,cantidadPrestamo,nombrePrestamista,fechaPrestamo,entregaPrestamo,elemenPrestamo);
    }

    @FXML
    void finalizarPrestamo(ActionEvent event) {
        mfc.finalizarPrestamo(debtorName, element, amount, dateLoan, deliveryDate);
    }
    @FXML
    void MainView(ActionEvent event) throws IOException {
        HelloApplication.mainViews(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colCantiLoan.setCellValueFactory(new PropertyValueFactory<>("cantidad"));
        colElementLoan.setCellValueFactory(new PropertyValueFactory<>("elemento"));
        colEntregaLoan.setCellValueFactory(new PropertyValueFactory<>("entrega"));
        colPrestamoLoan.setCellValueFactory(new PropertyValueFactory<>("prestamo"));
        colDeudorLoan.setCellValueFactory(new PropertyValueFactory<>("deudor"));

        /*elemenPrestamo.setValue("");
        elemenPrestamo.setItems(mfc.getElementLoanList());*/
    }



    @FXML
    void getData(){
        amount = String.valueOf(this.cantidadPrestamo.getText());
        dateLoan = String.valueOf(this.fechaPrestamo.getValue());
        deliveryDate = String.valueOf(this.entregaPrestamo.getValue());
        debtorName = String.valueOf(this.nombrePrestamista.getText());

    }
    /*@FXML
    void fillTable(Loan loan1){
        loan.setAmount(loan1.getAmount());
        loan.setElement(loan1.getElement());
        loan.setDateLoan(loan1.getDateLoan());
        loan.setDeliveryDate(loan1.getDeliveryDate());
        loan.setDebtorName(loan1.getDebtorName());
    }*/
    /*@FXML
    void alertError(String message, String title){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void alert(String message, String title ){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();

    }*/
    @FXML
    void getDate(ActionEvent event) {
        LocalDate myDate= fechaPrestamo.getValue();
        colPrestamoLoan.setText(String.valueOf(myDate));
    }

    @FXML
    void getDelivery(ActionEvent event) {

    }

}
