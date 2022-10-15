package com.example.laboratorioFinal.services.impl;

import com.example.laboratorioFinal.services.LoginService;

import java.util.Objects;

public class LoginServiceImpl implements LoginService {
    String user = "cdp";
    String password = "12345";
    @Override
    public Boolean login(String userRegis, String passwordRegis){
        System.out.println(userRegis+passwordRegis);
        boolean pass = validatePass(passwordRegis);
        boolean us = validateUser(userRegis);
        if(pass == true && us == true){
            return true;
        }else return false;
    }
    public Boolean validatePass(String passwordRegis){
        if (Objects.equals(password, passwordRegis)){
            return true;
        }else return false;
    }
    public Boolean validateUser(String userRegis){
        if (Objects.equals(user, userRegis)) {
            return true;
        }else return false;
    }
}
