/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author irina
 */
public class Baraja {

    Scanner scaner = new Scanner(System.in);

    ArrayList<Carta> baraja = new ArrayList();

    //Cartas entregadas al usuario
    ArrayList<Carta> barajaU = new ArrayList();

    /*
    *Una carta tiene un número entre 1
    *y 12 (el 8 y el 9 no los incluimos)
    *y un palo (espadas, bastos, oros y copas)
     */
    private void crearBaraja() {
        cartas( "Espadas");
        cartas( "Bastos");
        cartas( "Oros");
        cartas( "Copas");
        
    }
    
    private void cartas(String tipo){
        for (int i = 1; i < 13; i++) {
            if (i != 8 && i != 9) {
                baraja.add(new Carta(i, tipo));
               
            }

        }
    }


    /*
    *   • barajar(): cambia de posición todas las cartas aleatoriamente.
     */
    private void barajar() {
        Collections.shuffle(baraja);
    }

    /*
    *   • siguienteCarta(): devuelve la siguiente carta que está en la baraja, cuando no haya más o
    *                       se haya llegado al final, se indica al usuario que no hay más cartas.
     */
    private void siguienteCarta() {

        if (baraja.isEmpty()) {
            System.out.println("--------------------------------------------------");
            System.out.println("QUERIDO USUARIO, YA NO HAY MAS CARTAS EN LA BARAJA");
            System.out.println("--------------------------------------------------");
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("CARTA: " + baraja.get(0));
            System.out.println("--------------------------------------------------");
            //agregar a la baraja del usuario
            barajaU.add(baraja.get(0));
            //eliminar carta de la baraja principal
            baraja.remove(0);
        }
    }

    /*
    *   • cartasDisponibles(): indica el número de cartas que aún se puede repartir.
     */
    private void cartasDisponibles() {
        System.out.println("--------------------------------------------------");
        System.out.println("    AUN QUEDAN : " + baraja.size() + " CARTA/S");
        System.out.println("--------------------------------------------------");
    }

    /*
    *   • darCartas(): dado un número de cartas que nos pidan, le devolveremos ese número de
    *                       cartas. En caso de que haya menos cartas que las pedidas, no devolveremos nada, pero
    *                       debemos indicárselo al usuario.
     */
    private void darCarta() {
        System.out.println("------------------------------------------------------");
        System.out.print("    CUANTAS CARTAS DESEA SELECCIONAR? ");
        int cant = scaner.nextInt();
        if (cant < baraja.size()) {
            for (int i = 0; i < cant; i++) {
                siguienteCarta();
            }
        } else {
            System.out.println("--------------------------------------------------");
            System.out.println("LA CANTIDAD INGRESADA EXCEDE LA CANTIDAD DE CARTAS");
            System.out.println("--------------------------------------------------");
        }

    }

    /*
    *   • cartasMonton(): mostramos aquellas cartas que ya han salido, si no ha salido ninguna
    *                       indicárselo al usuario
     */
    private void cartasMonton() {
        int cont = 1;
        if (barajaU.isEmpty()) {
            System.out.println("--------------------------------------------------");
            System.out.println("ESTIMADO USUARIO, AUN NO SE LE HA DADO CARTAS");
            System.out.println("--------------------------------------------------");
        } else {
            for (Carta aux : barajaU) {

                System.out.print(aux);
                if (cont % 10 == 0) {
                    System.out.println("");
                }
                cont++;
            }
        }
        System.out.println("");

    }

    /*
    *   • mostrarBaraja(): muestra todas las cartas hasta el final. Es decir, si se saca una carta y
    *                       luego se llama al método, este no mostrara esa primera carta.
     */
    private void mostrarBaraja() {
        int cont = 1;
        if (!baraja.isEmpty()) {
            for (Carta aux : baraja) {

                System.out.print(aux);
                if (cont % 10 == 0) {
                    System.out.println("");
                }
                cont++;
            }
        }else{
            System.out.println("--------------------------------------------------");
            System.out.println(" YA NO HAY CARTAS EN LA BARAJA");
            System.out.println("--------------------------------------------------");
        }
        System.out.println("");

    }
    
    //--------------------------------------------------------------------------
    public void menu(){
        int opcU;
        //Primero creamos la baraja
        crearBaraja();
        //Mostramos menu de opciones para que el usuario interactue
        do {
            System.out.println("--------------------------------------------------");
            System.out.println("                 MENU DE OPCIONES                 ");
            System.out.println("--------------------------------------------------");
            System.out.println("   1. MEZCLAR BARAJA");
            System.out.println("   2. DAR UNA CARTA");
            System.out.println("   3. DAR MAS DE UNA CARTA");
            System.out.println("   4. CANTIDAD DE CARTAS EN LA BARAJA");
            System.out.println("   5. MOSTRAR BARAJA DEL USUARIO");
            System.out.println("   6. MOSTRAR BARAJA");
            System.out.println("   7. SALIR");
            System.out.println("--------------------------------------------------");
            System.out.print("    SELECCIONE UNA OPCION: ");
            opcU = scaner.nextInt();
            
            switch (opcU) {
                case 1:
                    barajar();
                    break;
                case 2:
                    siguienteCarta();
                    break;
                case 3:
                    darCarta();
                    break;
                case 4:
                    cartasDisponibles();
                    break;
                case 5:
                    cartasMonton();
                    break;
                case 6:
                    mostrarBaraja();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("--------------------------------------------------");;
                    System.out.println("OPCION INGRESADA NO ENCONTRADA, INTENTELO DE NUEVO");;
            }
            
        } while (opcU != 7);
    }
}
