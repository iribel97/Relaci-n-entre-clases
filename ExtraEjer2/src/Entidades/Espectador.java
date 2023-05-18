/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author irina
 */
public class Espectador {
    /*
    *del espectador, nos interesa saber su
    *nombre, edad y el dinero que tiene disponible.
    */
    private String name;
    private int age;
    private double cash;

    public Espectador() {
    }

    public Espectador(String name, int age, double cash) {
        this.name = name;
        this.age = age;
        this.cash = cash;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
    
}
