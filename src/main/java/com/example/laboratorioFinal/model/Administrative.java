package com.example.laboratorioFinal.model;

public class Administrative extends Person{

    private String antiguety;
    private String charger;

    public String getAntiguety() {
        return antiguety;
    }

    public void setAntiguety(String antiguety) {
        this.antiguety = antiguety;
    }

    public String getCharger() {
        return charger;
    }

    public void setCharger(String charger) {
        this.charger = charger;
    }

    public Administrative(String name, String id, String antiguety, String charger) {
        super(name, id);
        this.antiguety = antiguety;
        this.charger = charger;
    }
}
