/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

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
    private Perro perro;

    public Persona() {
    }

    public Persona(String nombre, String apellido, int edad, int documento, Perro perro) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.documento = documento;
        this.perro = perro;
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

    public Perro getPerro() {
        return perro;
    }

    public void setPerro(Perro perro) {
        this.perro = perro;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Persona{");
        sb.append("\n Nombre = ").append(nombre);
        sb.append("\n Apellido =").append(apellido);
        sb.append("\n Edad = ").append(edad);
        sb.append("\n Documento = ").append(documento);
        sb.append("\n Perro{ ");
        sb.append("\n    - Nombre: ").append(perro.getNombre());
        sb.append("\n    - Raza: ").append(perro.getRaza());
        sb.append("\n    - Edad: ").append(perro.getEdad());
        sb.append("\n    - Tamaño: ").append(perro.getTamanio());
        sb.append("\n    }");
        sb.append('}');
        return sb.toString();
    }

}
