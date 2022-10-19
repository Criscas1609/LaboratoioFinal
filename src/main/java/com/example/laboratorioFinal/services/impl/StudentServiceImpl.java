package com.example.laboratorioFinal.services.impl;

import com.example.laboratorioFinal.controller.StudentViewController;
import com.example.laboratorioFinal.model.Administrative;
import com.example.laboratorioFinal.model.Student;
import com.example.laboratorioFinal.model.Teacher;
import com.example.laboratorioFinal.services.StudentService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;

import javax.swing.table.TableModel;
import javax.swing.RowFilter;
import javax.swing.table.TableRowSorter;
import java.util.ArrayList;
import java.util.Objects;

public class StudentServiceImpl implements StudentService {
    private Student studentService;
    String name;
    String id;
    String career;
    String semester;

    private ArrayList<Student> listStudent = new ArrayList<>();

    ObservableList<Student> studentObservableList = FXCollections.observableArrayList();
    ObservableList<String> careerStudent = FXCollections.observableArrayList("Ingeniería de Software", "Ingeniería Industrial", "Ingeniería Civil");
    ObservableList<String> semeStudent = FXCollections.observableArrayList("I", "II", "III", "IV", "V", "VI", "VII", "VIII");


    public ObservableList<Student> getStudentObservableList() {
        return studentObservableList;
    }

    public ObservableList<String> getCareerStudent() {
        return careerStudent;
    }

    public ObservableList<String> getSemeStudent() {
        return semeStudent;
    }


    public void createStudent(String name, String id, String career, String semester) {
        Student person = new Student(name, id, career, semester);
        studentObservableList.add(person);
        listStudent.add(person);
    }

    public void selectionStudent(TableView<Student> tablePersonEs,TextField nombreEstudiante, TextField idEstudiante, ChoiceBox<String> semestreEstudiante, ChoiceBox<String> carreraEstudiante) {
        studentService = tablePersonEs.getSelectionModel().getSelectedItem();;
        fillInputStudent(studentService,nombreEstudiante,idEstudiante,semestreEstudiante, carreraEstudiante);
    }

    void fillInputStudent(Student student, TextField nombreEstudiante, TextField idEstudiante, ChoiceBox<String> semestreEstudiante, ChoiceBox<String> carreraEstudiante) {
        nombreEstudiante.setText(student.getName());
        idEstudiante.setText(student.getId());
        semestreEstudiante.setValue(student.getSemester());
        carreraEstudiante.setValue(student.getCareer());
    }


    public void addTable(TableView<Student> tablePersonEs) {
        tablePersonEs.setItems(studentObservableList);
        tablePersonEs.refresh();
    }

    public void editStudent(TableView<Student> tablePersonEs, TextField nombreEstudiante, TextField idEstudiante, ChoiceBox<String> semestreEstudiante, ChoiceBox<String> carreraEstudiante, Student studentaux) {
        getData(nombreEstudiante,idEstudiante,semestreEstudiante,carreraEstudiante);
        if (studentService == null) {
            alert("Debe tener un elemento seleccionado", "Error");
        } else {
            try {
                if (!studentObservableList.contains(studentaux)) {
                    System.out.println(studentaux.getName());
                    fillTable(studentaux);
                    tablePersonEs.refresh();
                    alert("El estudiante se ha editado", "¡Exito!");
                } else {
                    alert("El estudiante ya existe", "Error");
                }
            } catch (NumberFormatException e) {
                alert("Formato incorrecto", "Error");
            }
        }
    }


    public void searchStudent(String name, TableView<Student> tablePersonEs) {
        for (Student student : studentObservableList) {
            if (Objects.equals(student.getName(), name) || Objects.equals(student.getId(), name)){
                tablePersonEs.getSelectionModel().select(student);
                tablePersonEs.refresh();
            }
        }

    }

    public void removeStudent(TableView<Student> tablePersonEs,TextField nombreEstudiante, TextField idEstudiante, ChoiceBox<String> semestreEstudiante, ChoiceBox<String> carreraEstudiante) {
        if (this.studentService == null) {
            alert("Debe tener un estudiante seleccionado", "Error");
        } else {
            studentObservableList.remove(studentService);
            listStudent.remove(studentService);
            tablePersonEs.refresh();
            alert("Se ha eliminado correctamente", "Exito");
        }
    }

    //Funciones de reportes

    public void allStudent(Label cantEs){
        String allStudents = String.valueOf(listStudent.size());
        cantEs.setText(allStudents);
    }

    public void allSoftware(Label cantSoft) {
        int softwareStudents = 0;
        for (Student student : listStudent) {
            if (student.getCareer().equals("Ingeniería de Software")) {
                softwareStudents++;
            }
        }
        cantSoft.setText(String.valueOf(softwareStudents));
    }
    public void allIndus(Label cantIndus) {
        int indusStudents = 0;
        for (Student student : listStudent) {
            if (student.getCareer().equals("Ingeniería Industrial")) {
                indusStudents++;
            }
        }
        cantIndus.setText(String.valueOf(indusStudents));
    }

    public void allCivil(Label cantCivil) {
        int civilStudents = 0;
        for (Student student : listStudent) {
            if (student.getCareer().equals("Ingeniería Civil")) {
                civilStudents++;
            }
        }
        cantCivil.setText(String.valueOf(civilStudents));
    }




    //Funciones aparte

    void alert(String message, String title) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    void fillTable(Student student1) {
        this.studentService.setName(student1.getName());
        this.studentService.setId(student1.getId());
        this.studentService.setCareer(student1.getCareer());
        this.studentService.setSemester(student1.getSemester());
    }

    void getData(TextField nombreEstudiante, TextField idEstudiante, ChoiceBox<String> semestreEstudiante, ChoiceBox<String> carreraEstudiante) {
        name = String.valueOf(nombreEstudiante.getText());
        id = String.valueOf(idEstudiante.getText());
        semester = String.valueOf(semestreEstudiante.getValue());
        career = String.valueOf(carreraEstudiante.getValue());
    }

    public void cargarEs(TableView<Student> tablePersonEs) {
        tablePersonEs.setItems(studentObservableList);
        tablePersonEs.refresh();
    }

}
