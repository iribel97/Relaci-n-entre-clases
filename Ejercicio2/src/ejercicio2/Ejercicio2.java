/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejercicio2;

import Entidades.Juego;
import Entidades.Jugador;
import Entidades.RevolverAgua;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author irina
 */
public class Ejercicio2 {

    /*
    Realizar el juego de la ruleta rusa de agua en Java. Como muchos saben, el juego se trata de
un número de jugadores, que, con un revolver de agua, el cual posee una sola carga de agua,
se dispara y se moja. Las clases por hacer del juego son las siguientes:
     */
    public static void main(String[] args) {
        Scanner scaner = new Scanner(System.in);
        String opcU = "s";

        ArrayList<Jugador> players = new ArrayList<>();
        Juego play = new Juego();
        RevolverAgua shot = new RevolverAgua();
        System.out.println("--------------------------------------------------");
        System.out.println("      VAMOS A JUGAR A LA RULETA RUSA DE AGUA      ");
        System.out.println("--------------------------------------------------");
        System.out.println("Ingrese cantidad de jugadores: ");
        int cantJ = scaner.nextInt();

        for (int i = 1; i <= cantJ; i++) {
            if (i==1) {
                scaner.nextLine();
            }
            
            System.out.println("--------------------------------------------------");
            System.out.println("                JUGADOR # " + i);
            System.out.println("--------------------------------------------------");
            System.out.print("Ingrese nombre: ");
            players.add(new Jugador(i, scaner.nextLine(), false));
        }
        shot.llenarRevolver();
        play.llenarJuego(players, shot);

        while (opcU.charAt(0) == 's' && play.getJugadores().size() != 1) {

            play.ronda();
            if (play.getJugadores().size() != 1) {
                System.out.println("--------------------------------------------------");
                System.out.print("Desea descalificar a otra persona? (Si/No): ");
                opcU = scaner.next().toLowerCase();
                if (opcU.charAt(0) == 's') {
                    play.setRevolver();
                }
            }

        }

        play.mostrarJugadores();

    }

}
