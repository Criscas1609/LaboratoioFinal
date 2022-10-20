package com.example.laboratorioFinal.model;

public class LoanDetail {

    private String element;
    private String amount;

    public LoanDetail(String element, String amount) {
        this.element = element;
        this.amount = amount;
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

}
