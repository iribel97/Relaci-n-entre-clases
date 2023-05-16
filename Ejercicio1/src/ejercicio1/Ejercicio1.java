/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio1;

import Entidades.Perro;
import Entidades.Persona;

/**
 *
 * @author irina
 */
public class Ejercicio1 {

    /*
    Realizar un programa para que una Persona pueda adoptar un Perro. Vamos a contar de dos
    clases. Perro, que tendrá como atributos: nombre, raza, edad y tamaño; y la clase Persona con
    atributos: nombre, apellido, edad, documento y Perro.
    Ahora deberemos en el main crear dos Personas y dos Perros. Después, vamos a tener que
    pensar la lógica necesaria para asignarle a cada Persona un Perro y por ultimo, mostrar desde
    la clase Persona, la información del Perro y de la Persona.
    */
    public static void main(String[] args) {
        /*
       Perro dog1 = new Perro("Lulu", "Buldog", 11, 0.9);
       Perro dog2 = new Perro("Otto", "Minie French", 2, 0.2);
       
       Persona person1 = new Persona("Diego", "Sanchez", 27, 1254, dog2);
       Persona person2 = new Persona("Luis", "Riofrio", 32, 4569, dog1);
       */
        Persona person1 = new Persona("Diego", "Sanchez", 27, 1254, new Perro("Lulu", "Buldog", 11, 0.9));
        Persona person2 = new Persona("Luis", "Riofrio", 32, 4569, new Perro("Otto", "Minie French", 2, 0.2));
        System.out.println(person1);
        System.out.println("");
        System.out.println(person2.toString());
    }
    
}
