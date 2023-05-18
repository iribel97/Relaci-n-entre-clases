/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author irina
 */
public class Pelicula {
    /*
    *de las películas nos interesa saber
    *el título, duración, edad mínima y director
    */
    
    private String title, director, time;
    private int age;
    private double cash;

    public Pelicula() {
    }

    public Pelicula(String title, String director, int age, String time, double cash) {
        this.title = title;
        this.director = director;
        this.age = age;
        this.time = time;
        this.cash = cash;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
    
}
