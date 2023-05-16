/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package EnumEntidades;

/**
 *
 * @author irina
 */
public enum Perrera {
    Nala("Mini French", "Pequeño", 2), 
    Mia("ShisTzu", "Pequeña", 1),
    Hachi("Shiba Inu", "Grande", 10),
    Zeus("Husky Siberianp", "Grande", 5);
    
    private String raza, tamanio;
    int edad;

    private Perrera(String raza, String tamanio, int edad) {
        this.raza = raza;
        this.tamanio = tamanio;
        this.edad = edad;
    }

    public String getRaza() {
        return raza;
    }

    public String getTamanio() {
        return tamanio;
    }

    public int getEdad() {
        return edad;
    }
    
    
}
