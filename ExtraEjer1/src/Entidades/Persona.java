/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import EnumEntidades.Perrera;
import java.util.ArrayList;

/**
 *
 * @author irina
 */
public class Persona {

    /*
        atributos: nombre, apellido, edad, documento y Perro.
     */
    private String nombre, apellido;
    private int edad, documento;
    private ArrayList<Persona> persons = new ArrayList();
    private ArrayList<Perrera> perros = new ArrayList();

    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, int documento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public ArrayList<Persona> getPersons() {
        return persons;
    }

    public void setPersons(Persona persons) {
        this.persons.add(persons);
    }

    public ArrayList<Perrera> getPerros() {
        return perros;
    }

    public void setPerros(Perrera perros) {
        this.perros.add(perros);
    }

    

}
