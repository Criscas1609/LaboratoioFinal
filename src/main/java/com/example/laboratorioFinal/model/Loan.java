package com.example.laboratorioFinal.model;

//Prestamo

public class Loan {
    private String debtorName;
    /*private String nombreMonitor;*/
    private String element;
    private String amount;
    private String dateLoan;
    private String deliveryDate;
   /*private String tipo;*/

    public Loan(String debtorName, String element, String amount, String dateLoan, String deliveryDate) {
        this.debtorName = debtorName;
        this.element = element;
        this.amount = amount;
        this.dateLoan = dateLoan;
        this.deliveryDate = deliveryDate;
    }

    public String getDebtorName() {
        return debtorName;
    }

    public void setDebtorName(String debtorName) {
        this.debtorName = debtorName;
    }

    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
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
}

