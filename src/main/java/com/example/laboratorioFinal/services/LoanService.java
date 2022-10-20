package com.example.laboratorioFinal.services;

import com.example.laboratorioFinal.model.Loan;
import com.example.laboratorioFinal.model.LoanDetail;
import com.example.laboratorioFinal.model.Student;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.util.ArrayList;

public interface LoanService {
    void addLoan(String element, String amount,TableView<LoanDetail> tblLoan);
    void finalizarPrestamo(String dateLoan, String deliveryDate, String debtorName,String tipo, String nombreMonitor);
    void eliminarPrestamo(TableView<LoanDetail> tblLoan, TextField cantidadPrestamo, ChoiceBox elemenPrestamo);
    void seleccionar(TableView<LoanDetail> tblLoan, TextField cantidadPrestamo, ChoiceBox elemenPrestamo);
    void totalLoan(Label totalPrestamo);
    void botonBuscar(String name,TableView<Loan>tblReportLoan);
    void bestStudent(Label prestamoEs, ArrayList<Student> studentArrayList);

    ObservableList<LoanDetail> getLoanObservableList();
    ObservableList<String> getTipoList();
    ObservableList<Loan> getLoanReportList();
    ObservableList<LoanDetail> getObservableListElement();
    /*ObservableList <String> getElementLoanList();*/
}
