/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author irina
 */
public class Alumno {
    /*
    *nombre completo, DNI y cantidad de votos.
    */
    private String nombreCom, dni;
    private int cantVotos;

    public Alumno() {
    }

    public Alumno(String nombreCom, int cantVotos) {
        this.nombreCom = nombreCom;
        this.cantVotos = cantVotos;
    }

    public String getNombreCom() {
        return nombreCom;
    }

    public void setNombreCom(String nombreCom) {
        this.nombreCom = nombreCom;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getCantVotos() {
        return cantVotos;
    }

    public void setCantVotos(int cantVotos) {
        this.cantVotos = cantVotos;
    }
    
    
}
