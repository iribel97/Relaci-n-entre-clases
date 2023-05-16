/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciopersona;

import Entidad.Dni;
import Entidad.Persona;
/**
 *
 * @author irina
 */
public class EjercicioPersona {

    /*
    Realiza un programa en donde una clase Persona tenga como atributo nombre, apellido y un
objeto de clase Dni. La clase Dni tendrá como atributos la serie (carácter) y número. Prueba
acceder luego a los atributos del dni de la persona creando objetos y jugando desde el main.
    */
    public static void main(String[] args) {
        // TODO code application logic here
        Persona person1 = new Persona();
        
        //Crear persona
        person1.setNombre("Nala");
        person1.setApellido("Ochoa");
        Dni cdl = new Dni('e',12356);
        person1.setDni(cdl);
        
        //Mostrar por pantalla
        
        System.out.println(person1.toString());
        
        
    }
    
}
