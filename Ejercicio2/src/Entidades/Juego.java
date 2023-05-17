/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author irina
 */
public class Juego {

    /*
    Clase Juego: esta clase posee los siguientes atributos: Jugadores (conjunto de Jugadores) y
    Revolver
     */
    ArrayList<Jugador> jugadores;
    ArrayList<Jugador> jugadoresAux = new ArrayList();

    RevolverAgua revolver;

    public Juego() {
    }

    /*
    Métodos:
        • llenarJuego(ArrayList<Jugador>jugadores, Revolver r): este método recibe los jugadores
        y el revolver para guardarlos en los atributos del juego.
     */
    public void llenarJuego(ArrayList<Jugador> jugadores, RevolverAgua revolver) {
        this.jugadores = jugadores;
        this.revolver = revolver;
    }


    /*
    • ronda(): cada ronda consiste en un jugador que se apunta con el revolver de agua y
        aprieta el gatillo. Sí el revolver tira el agua el jugador se moja y se termina el juego, sino se
        moja, se pasa al siguiente jugador hasta que uno se moje. Si o si alguien se tiene que
        mojar. Al final del juego, se debe mostrar que jugador se mojó.
        Pensar la lógica necesaria para realizar esto, usando los atributos de la clase Juego.
     */
    public void ronda() {
        boolean bandera = true;
        do {

            for (Jugador aux : jugadores) {
                bandera = aux.disparo(revolver);
                if (bandera) {
                    System.out.println("----------------------------------------------------");
                    System.out.println("JUGADOR " + aux.getNombreJ() + ", QUEDA DESCALIFICADO");
                    jugadores.remove(aux);
                    jugadoresAux.add(aux);
                    break;
                }
            }
        } while (!bandera);

    }

    public void mostrarJugadores() {
        if (jugadores.size() == 1) {
            jugadoresAux.add(jugadores.get(0));
            System.out.println("--------------------------------------------------------");
            System.out.println("EL JUGADOR GANADOR ES : " + jugadores.get(0).getNombreJ());
        }else{
            for (Jugador aux : jugadores) {
                jugadoresAux.add(aux);
            }
        }

        // Comparador personalizado para ordenar por ID
        Comparator<Jugador> comparadorDuracion = new Comparator<Jugador>() {
            @Override
            public int compare(Jugador p1, Jugador p2) {
                return p1.getNombreJ().compareTo(p2.getNombreJ());
            }
        };
        // Ordenar la lista de barajas usando el comparador
        Collections.sort(jugadoresAux, comparadorDuracion);
        System.out.println("------------------------------------------------------------");
        for(Jugador aux : jugadoresAux){
            System.out.println(aux.getNombreJ() + "  ---->  " + aux.isMojado());
        }
    }

    public void setRevolver() {
        this.revolver.llenarRevolver();
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

}
