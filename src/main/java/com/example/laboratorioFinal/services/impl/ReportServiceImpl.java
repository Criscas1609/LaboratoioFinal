package com.example.laboratorioFinal.services.impl;

import com.example.laboratorioFinal.model.Student;
import com.example.laboratorioFinal.services.ReportService;

import java.util.ArrayList;

public class ReportServiceImpl implements ReportService {
    public Student searchEstudent(ArrayList<Student> studentArrayList, String seach){
        Student studentAux = null;
        for (Student student:studentArrayList) {
            if(student.getName().equals(seach)){
                studentAux= student;
            }
        }
        if(studentAux != null){
            return studentAux;
        }else return null;
    }
}
