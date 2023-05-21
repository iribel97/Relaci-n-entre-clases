/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author irina
 */
public class Vehiculo {
    /*
    *   b. Gestión de vehículos. Se registra la información de cada vehículo asegurado. Marca,
    *       modelo, año, número de motor, chasis, color, tipo (camioneta, sedán, etc.).
    */
    private String marca, modelo, color, chasis;
    private String[] tipo = {"camioneta", "sedan", "moto", "lamborgini", "cuadron"};
    private int year, numMotor;

    public Vehiculo() {
    }

    public Vehiculo(String marca, String modelo, String color, String chasis, int year, int numMotor) {
        this.marca = marca;
        this.modelo = modelo;
        this.color = color;
        this.chasis = chasis;
        this.year = year;
        this.numMotor = numMotor;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getChasis() {
        return chasis;
    }

    public void setChasis(String chasis) {
        this.chasis = chasis;
    }

    public String[] getTipo() {
        return tipo;
    }

    public void setTipo(String[] tipo) {
        this.tipo = tipo;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getNumMotor() {
        return numMotor;
    }

    public void setNumMotor(int numMotor) {
        this.numMotor = numMotor;
    }
    
    
}
