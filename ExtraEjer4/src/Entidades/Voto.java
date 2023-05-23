/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author irina
 */
public class Voto {

    /*
    *   • Una vez hecho esto debemos generar una clase Voto, esta clase tendrá como atributos,
    *       un objeto Alumno que será el alumno que vota y una lista de los alumnos a los que votó.
     */
    private Alumno alumno;
    private ArrayList<Alumno> alumnosV;

    public Voto() {
        this.alumno = new Alumno();
        this.alumnosV = new ArrayList();
    }

    public Voto(Alumno alumno, ArrayList<Alumno> alumnosV) {
        this.alumno = alumno;
        this.alumnosV = alumnosV;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public ArrayList<Alumno> getAlumnosV() {
        return alumnosV;
    }

    public void setAlumnosV(ArrayList<Alumno> alumnosV) {
        this.alumnosV = alumnosV;
    }

   

}
