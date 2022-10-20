package com.example.laboratorioFinal.controller;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.Objects;
import java.util.ResourceBundle;

import com.example.laboratorioFinal.HelloApplication;
import com.example.laboratorioFinal.model.Element;
import com.example.laboratorioFinal.model.Loan;
import com.example.laboratorioFinal.model.LoanDetail;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
    private ChoiceBox<String> elemenPrestamo;

    @FXML
    private DatePicker entregaPrestamo;

    @FXML
    private CheckBox externo;

    @FXML
    private DatePicker fechaPrestamo;

    @FXML
    private CheckBox interno;

    @FXML
    private ChoiceBox<String> nombreEstudiante;

    @FXML
    private ChoiceBox<String> nombreMonitor;

    @FXML
    private ChoiceBox<String> tipoPrestamo;

    @FXML
    private TableView<LoanDetail> tblLoan;

    @FXML
    void addLoan(ActionEvent event) {
        getData();
        mfc.addLoan(element, amount,tblLoan);
        /*alert("El prestamo se ha añadido","¡Exito!");*/
    }

    @FXML
    void eliminarPrestamo(ActionEvent event) {
        mfc.eliminarPrestamo(tblLoan,cantidadPrestamo,elemenPrestamo);
    }

    @FXML
    void finalizarPrestamo(ActionEvent event) {
        getData();
        mfc.finalizarPrestamo(dateLoan,deliveryDate,debtorName,tipo,monitorName);
        tblLoan.setItems(mfc.laboratory.getLoanService().getObservableListElement());
        tblLoan.refresh();
    }
    @FXML
    void MainView(ActionEvent event) throws IOException {
        HelloApplication.mainViews(event);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colCantiLoan.setCellValueFactory(new PropertyValueFactory<>("amount"));
        colElementLoan.setCellValueFactory(new PropertyValueFactory<>("element"));

       elemenPrestamo.getItems().addAll(mfc.laboratory.getElementService().getListNames());
       nombreEstudiante.getItems().addAll(mfc.laboratory.getStudentService().getListStudentNames());
       nombreMonitor.getItems().addAll(mfc.laboratory.getMonitorService().getListMonitorNames());

        tipoPrestamo.setValue("interno");
        tipoPrestamo.setItems(mfc.laboratory.getLoanService().getTipoList());
        //cantidadPrestamo.(mfc.laboratory.getLoanService().getObservableListElement());

    }



    @FXML
    void getData(){
        monitorName = String.valueOf(this.nombreMonitor.getValue());
        amount = String.valueOf(this.cantidadPrestamo.getText());
        dateLoan = String.valueOf(this.fechaPrestamo.getValue());
        deliveryDate = String.valueOf(this.entregaPrestamo.getValue());
        debtorName = String.valueOf(this.nombreEstudiante.getValue());
        element = String.valueOf(this.elemenPrestamo.getValue());
        tipo=String.valueOf(this.tipoPrestamo.getValue());
    }
    /*@FXML
    void getDate(ActionEvent event) {
        LocalDate myDate= fechaPrestamo.getValue();
        colPrestamoLoan.setText(String.valueOf(myDate));

    }

    @FXML
    void getDelivery(ActionEvent event) {

    }*/

}
