package com.example.laboratorioFinal.services.impl;
import com.example.laboratorioFinal.model.Element;
import com.example.laboratorioFinal.model.Loan;
import com.example.laboratorioFinal.services.LoanService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class LoanServiceImpl implements LoanService {
    private Loan loan;
    String element;
    String amount;
    String dateLoan;
    String deliveryDate;
    String debtorName;

    private List<Loan> listLoan = new ArrayList<>();

    public LoanServiceImpl() {this.listLoan = listLoan;}

    public List<Loan> getListLoan() {return listLoan;}

    public void setListLoan(List<Loan> listLoan) {this.listLoan = listLoan;}

    ObservableList<String> elementLoanList = FXCollections.observableArrayList("");
    ObservableList<Loan> loanObservableList= FXCollections.observableArrayList();


    public ObservableList<String> getElementLoanList() {return elementLoanList;}

    public ObservableList<Loan> getLoanObservableList() {return loanObservableList;}


    public void addLoan( TableView<Loan> tblLoan,String debtorName,String element,String amount, String dateLoan,String deliveryDate) {
        Loan loan = new Loan(debtorName, element, amount, dateLoan, deliveryDate);
        System.out.println(loan.getDateLoan());
        loanObservableList.add(loan);
        tblLoan.setItems(loanObservableList);
        tblLoan.refresh();
        alertAT("El prestamo se ha añadido","¡Exito!");
    }

    @Override
    public void finalizarPrestamo(String element, String amount, String dateLoan, String deliveryDate, String debtorName) {
        Loan loan = new Loan(debtorName, element, amount, dateLoan, deliveryDate);
        listLoan.add(loan);
        alertAT("El prestamo se ha finalizado y guardado exitosamente","¡Exito!");
    }


    public void seleccionar(TableView<Loan> tblLoan, TextField cantidadPrestamo, ChoiceBox nombreEstudiante, DatePicker fechaPrestamo, DatePicker entregaPrestamo, ChoiceBox elemenPrestamo) {
        loan= tblLoan.getSelectionModel().getSelectedItem();
        fillInputLoan(loan,tblLoan,cantidadPrestamo,nombreEstudiante,fechaPrestamo,entregaPrestamo,elemenPrestamo);
    }
    void fillInputLoan(Loan loan1, TableView<Loan> tblLoan,TextField cantidadPrestamo, ChoiceBox nombreEstudiante, DatePicker fechaPrestamo, DatePicker entregaPrestamo, ChoiceBox elemenPrestamo){
        cantidadPrestamo.setText(loan1.getAmount());
        nombreEstudiante.setValue(loan1.getDebtorName());
        fechaPrestamo.setId(loan1.getDateLoan());
        entregaPrestamo.setId(loan1.getDeliveryDate());
        elemenPrestamo.setValue(loan1.getElement());
    }


    public void eliminarPrestamo(TableView<Loan> tblLoan, TextField cantidadPrestamo, ChoiceBox nombreEstudiante, DatePicker fechaPrestamo, DatePicker entregaPrestamo, ChoiceBox elemenPrestamo) {
        seleccionar(tblLoan,cantidadPrestamo,nombreEstudiante,fechaPrestamo,entregaPrestamo,elemenPrestamo);
        if (loan == null){
            alertError("Debe tener un elemento seleccionado","Error");
        }else {
            loanObservableList.remove(loan);
            listLoan.remove(loan);
            tblLoan.refresh();
            alertAT("El prestamo se ha eliminado","¡Exito!");
        }
    }
    void alertError(String message, String title){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    void alertAT(String message, String title ){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
    /*void fillTable(Loan loan1){
        loan.setAmount(loan1.getAmount());
        loan.setElement(loan1.getElement());
        loan.setDateLoan(loan1.getDateLoan());
        loan.setDeliveryDate(loan1.getDeliveryDate());
        loan.setDebtorName(loan1.getDebtorName());
    }*/
}
