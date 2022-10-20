package com.example.laboratorioFinal.model;

//Prestamo

import java.util.ArrayList;

public class Loan {
    private String debtorName;
    private String nombreMonitor;
    private ArrayList<LoanDetail> listElement;
    private String dateLoan;
    private String deliveryDate;
    private String tipo;


    public Loan(String debtorName, String nombreMonitor, ArrayList<LoanDetail> listElement, String dateLoan, String deliveryDate, String tipo) {
        this.debtorName = debtorName;
        this.nombreMonitor = nombreMonitor;
        this.listElement = listElement;
        this.dateLoan = dateLoan;
        this.deliveryDate = deliveryDate;
        this.tipo = tipo;
    }


    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public String getNombreMonitor() {
        return nombreMonitor;
    }

    public void setNombreMonitor(String nombreMonitor) {
        this.nombreMonitor = nombreMonitor;
    }

    public ArrayList<LoanDetail> getListElement() {
        return listElement;
    }

    public void setListElement(ArrayList<LoanDetail> listElement) {
        this.listElement = listElement;
    }

    public String getDateLoan() {
        return dateLoan;
    }

    public void setDateLoan(String dateLoan) {
        this.dateLoan = dateLoan;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}