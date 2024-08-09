package com.example.notaslistview;

import java.io.Serializable;

public class NotasEstudiante implements Serializable {
    private String nombre;
    private double nota1;
    private double nota2;
    private double nota3;
    private String carrera;

    public NotasEstudiante(String nombre, double nota1, double nota2, double nota3, String carrera) {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
        this.nota3 = nota3;
        this.carrera = carrera;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getNota1() {
        return nota1;
    }

    public void setNota1(double nota1) {
        this.nota1 = nota1;
    }

    public double getNota2() {
        return nota2;
    }

    public void setNota2(double nota2) {
        this.nota2 = nota2;
    }

    public double getNota3() {
        return nota3;
    }

    public void setNota3(double nota3) {
        this.nota3 = nota3;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public double promedio(){
        return (nota1+nota2+nota3)/3;
    }
    public String toString(){
        return ("Nombre Estudiante:"+nombre+"\nCarrera:"+carrera+"\nPromedio:"+promedio());
    }
}
