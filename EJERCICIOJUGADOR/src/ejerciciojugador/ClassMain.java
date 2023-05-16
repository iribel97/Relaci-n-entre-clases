/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciojugador;

import Entidades.Equipo;
import Entidades.Jugador;

/**
 *
 * @author irina
 */
public class ClassMain {
    /*
    Realiza un programa en donde exista una clase Jugador que contenga nombre, apellido, posición
    y número. Luego otra clase Equipo que contenga una colección de jugadores. Una vez hecho
    esto, desde el main recorreremos el equipo mostrando la información de cada jugador.
    */
    public static void main(String[] args) {
        Equipo soccer = new Equipo();
        
        for (int i = 1; i <= 5; i++) {
            soccer.setJugadores(new Jugador("Nombre " + i, "Apellido " + i, "Posicion " + i, 1));
        }
        
        
        for (Jugador en : soccer.getJugadores()) {
            System.out.println(en);
            
        }
    }
    
}
