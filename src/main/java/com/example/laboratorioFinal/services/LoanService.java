package com.example.laboratorioFinal.services;

import com.example.laboratorioFinal.model.Loan;
import javafx.collections.ObservableList;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public interface LoanService {
    void addLoan(TableView<Loan> tblLoan,String element,String amount,String dateLoan,String deliveryDate,String debtorName);
    void finalizarPrestamo(String element,String amount,String dateLoan,String deliveryDate,String debtorName);
    void eliminarPrestamo(TableView<Loan> tblLoan, TextField cantidadPrestamo, ChoiceBox nombreEstudiante, DatePicker fechaPrestamo, DatePicker entregaPrestamo, ChoiceBox elemenPrestamo);
    void seleccionar(TableView<Loan> tblLoan, TextField cantidadPrestamo, ChoiceBox nombreEstudiante, DatePicker fechaPrestamo, DatePicker entregaPrestamo, ChoiceBox elemenPrestamo);
    ObservableList<Loan> getLoanObservableList();
    ObservableList <String> getElementLoanList();
}
