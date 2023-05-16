/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;

/**
 *
 * @author irina
 */
public class Equipo {
    /*
    Luego otra clase Equipo que contenga una colección de jugadores.
    */
    private ArrayList<Jugador> jugadores;

    public Equipo() {
        this.jugadores = new ArrayList();
    }

    public Equipo(ArrayList<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(Jugador j) {
        this.jugadores.add(j);
    }
    
    
    
    
}
