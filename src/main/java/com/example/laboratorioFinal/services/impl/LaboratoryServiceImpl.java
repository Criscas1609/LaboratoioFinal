package com.example.laboratorioFinal.services.impl;

import com.example.laboratorioFinal.controller.ModelFactoryController;
import com.example.laboratorioFinal.model.Monitor;
import com.example.laboratorioFinal.services.*;

public class LaboratoryServiceImpl {
    private final LoginService loginService;
    private final ElementService elementService;
    private final StudentService studentService;
    private final MonitorService monitorService;
    private final AdministrativeService administrativeService;
    private final LoanService loanService;


    public LaboratoryServiceImpl() {
        loginService = (LoginService) new LoginServiceImpl();
        loanService = (LoanService) new LoanServiceImpl();
        elementService = (ElementService) new ElementServiceImpl();
        studentService = (StudentService) new StudentServiceImpl();
        monitorService = (MonitorService) new MonitorServiceImpl();
        administrativeService = (AdministrativeService) new AdministrativeServiceImpl();
    }

    public LoginService getLoginService() {
        return loginService;
    }
    public ElementService getElementService() {return elementService;}
    public StudentService getStudentService() {return studentService;}
    public MonitorService getMonitorService() {return monitorService;}
    public AdministrativeService getAdministrativeService(){return  administrativeService;}
    public LoanService getLoanService() {return loanService;}
}
