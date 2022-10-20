package com.example.laboratorioFinal.services.impl;
import com.example.laboratorioFinal.model.Element;
import com.example.laboratorioFinal.model.Loan;
import com.example.laboratorioFinal.model.LoanDetail;
import com.example.laboratorioFinal.model.Student;
import com.example.laboratorioFinal.services.LoanService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import java.util.ArrayList;
import java.util.List;

public class LoanServiceImpl implements LoanService {
    private LoanDetail loanDetail;
    String element;
    String amount;
    String dateLoan;
    String deliveryDate;
    String debtorName;

    private ArrayList<Loan> listLoan = new ArrayList<>();
    private ArrayList<LoanDetail> listElement= new ArrayList<>();

    private ObservableList<Loan> loanReportList = FXCollections.observableArrayList();

    public ObservableList<Loan> getLoanReportList() {
        return loanReportList;
    }

    private ObservableList<LoanDetail> observableListElement = FXCollections.observableArrayList();

    public ObservableList<LoanDetail> getObservableListElement() {
        return observableListElement;
    }

    public ArrayList<LoanDetail> getListElement() {
        return listElement;
    }

    public void setListElement(ArrayList<LoanDetail> listElement) {
        this.listElement = listElement;
    }

    public LoanServiceImpl() {this.listLoan = listLoan;}

    public ArrayList<Loan> getListLoan() {return listLoan;}

    public void setListLoan(ArrayList<Loan> listLoan) {this.listLoan = listLoan;}

    ObservableList<String> elementLoanList = FXCollections.observableArrayList("");
    ObservableList<Loan> loanObservableList= FXCollections.observableArrayList();


    public ObservableList<String> getElementLoanList() {return elementLoanList;}

    public ObservableList<Loan> getLoanObservableList() {return loanObservableList;}


    public void addLoan(String element, String amount,TableView<LoanDetail> tblLoan) {

        LoanDetail detail = new LoanDetail(element,amount);
        listElement.add(detail);
        observableListElement.add(detail);
        tblLoan.setItems(observableListElement);
        tblLoan.refresh();
        alertAT("El elemento se ha añadido a tu prestamo","¡Exito!");
    }

    @Override
    public void finalizarPrestamo(String element, String amount, String dateLoan, String deliveryDate, String debtorName) {
        Loan loan = new Loan(debtorName, element, amount, dateLoan, deliveryDate);
        listLoan.add(loan);
        loanReportList.add(loan);
        listElement.clear();
        observableListElement.clear();

        alertAT("El prestamo se ha finalizado y guardado exitosamente","¡Exito!");
    }

    public void seleccionar(TableView<LoanDetail> tblLoan, TextField cantidadPrestamo, ChoiceBox elemenPrestamo) {
        loanDetail = tblLoan.getSelectionModel().getSelectedItem();
        fillInputLoan(loanDetail,tblLoan,cantidadPrestamo,elemenPrestamo);
    }

    void fillInputLoan(LoanDetail loanDetail, TableView<LoanDetail> tblLoan,TextField cantidadPrestamo, ChoiceBox elemenPrestamo){
        cantidadPrestamo.setText(loanDetail.getAmount());
        //entregaPrestamo.setId(loan1.getDeliveryDate());
        elemenPrestamo.setValue(loanDetail.getElement());
    }


    public void eliminarPrestamo(TableView<LoanDetail> tblLoan, TextField cantidadPrestamo, ChoiceBox elemenPrestamo) {
        seleccionar(tblLoan,cantidadPrestamo,elemenPrestamo);
        if (loanDetail == null){
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

    //Reportes

    public void bestStudent(Label prestamoEs,ArrayList<Student> studentArrayList){
        int canti;
        int mayor=0;
        String studen="";
        for(Student stu: studentArrayList){
            canti=0;
            for(Loan loan: listLoan){
                if(loan.getDebtorName() == stu.getName()){
                    canti++;
                }
            }
            if(canti>mayor){
                mayor=canti;
                studen= stu.getName();
            }
        }
        prestamoEs.setText(studen);
    }
    public void botonBuscar(String name,TableView<Loan>tblReportLoan){
        for (Loan loan : loanReportList) {
            if (Objects.equals(loan.getDebtorName(), name) ){
                tblReportLoan.getSelectionModel().select(loan);
                tblReportLoan.refresh();
            }
        }
    }

    public void totalLoan(Label totalPrestamo){
        String total = String.valueOf(listLoan.size());
        totalPrestamo.setText(total);
    }

}
