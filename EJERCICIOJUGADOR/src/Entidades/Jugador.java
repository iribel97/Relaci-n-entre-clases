/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author irina
 */
public class Jugador {
    /*
    que contenga nombre, apellido, posición y número.
    */
    private String nombre, apellido, posicion;
    private int num;

    public Jugador() {
    }

    public Jugador(String nombre, String apellido, String posicion, int num) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicion = posicion;
        this.num = num;
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

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("----------------------------------------------------------");
        sb.append("\n NOMBRE: ").append(nombre);
        sb.append("\n APELLIDO: ").append(apellido);
        sb.append("\n POSICION: ").append(posicion);
        sb.append("\n NUMERO:").append(num);
        sb.append(' ');
        return sb.toString();
    }
    
}
