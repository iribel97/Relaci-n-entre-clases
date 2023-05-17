/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package extraejer1;


import Servicio.ServicioPerrera;
/**
 *
 * @author irina
 */
public class ExtraEjer1Main {

    /*
    *Ahora se debe realizar unas mejoras al ejercicio de Perro y Persona. Nuestro programa va a
    *tener que contar con muchas personas y muchos perros. El programa deberá preguntarle a
    *cada persona, que perro según su nombre, quiere adoptar. Dos personas no pueden adoptar
    *al mismo perro, si la persona eligió un perro que ya estaba adoptado, se le debe informar a la
    *persona.
    *Una vez que la Persona elige el Perro se le asigna, al final deberemos mostrar todas las
    *personas con sus respectivos perros.
     */
    public static void main(String[] args) {
        
        ServicioPerrera serv = new ServicioPerrera();
        
        serv.menu();
        
    }
    
   

}
