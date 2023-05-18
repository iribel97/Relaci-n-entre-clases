/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import Servicios.ServPeli;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author irina
 */
public class Cine {

    Scanner scaner = new Scanner(System.in);
    /*
    *De Cine nos interesa conocer la película que se está reproduciendo, la
    *sala con los espectadores y el precio de la entrada.
     */
    ServPeli servMovie = new ServPeli();
    Espectador usuario = new Espectador();
    private int usuInvitados;

    HashMap<Integer, Sala> rooms = new HashMap();

    //POR SI EL USUARIO QUIERE CAMBIAR DE ASIENTO, DEBO DE GUARDAR EL NUMERO DE ASIENTO Y EL NUMERO DE SALA
     ArrayList<String> salaU = new ArrayList();
    private int salaSelecU;

    public void crearSalas() {
        servMovie.addMovie();
        for (int i = 0; i < servMovie.getMovies().size(); i++) {
            rooms.put((i + 1), new Sala(servMovie.getMovies().get(i)));
        }
    }

    public void menu() {
        int opcU;
        infoUsuario();
        crearSalas();
        //MOSTRAR PELICULAS
        llenarSala();

        do {

            System.out.println("|-------------------------------------------------------------------------------------------|");
            System.out.println("|                                      MENU DE OPCIONES                                     |");
            System.out.println("|-------------------------------------------------------------------------------------------|");
            System.out.println("|    1. COMPRAR VOLETOS                                                                     |");
            System.out.println("|    2. CAMBIAR DATOS                                                                       |");
            System.out.println("|    3. SALIR                                                                               |");
            System.out.println("|-------------------------------------------------------------------------------------------|");
            System.out.print("   SELECCIONE UNA: ");
            opcU = scaner.nextInt();
            switch (opcU) {
                case 1:
                    mostrarPelis();
                    comprar();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    System.out.println("OPCION MAL INGRESADA, INTENTELO DE NUEVO");
            }
        } while (opcU != 3);

    }

    //METODO PARA PEDIR LOS DATOS AL USUARIO
    private void infoUsuario() {
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println("|                             QUERIDO USUARIO, INGRESE SUS DATOS                            |");
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.print("     NOMBRE: ");
        usuario.setName(scaner.nextLine());
        System.out.print("     EDAD: ");
        usuario.setAge(scaner.nextInt());
        System.out.print("     EFECTIVO: ");
        usuario.setCash(scaner.nextDouble());
        System.out.print("     CANTIDAD DE ENTRADAS: ");
        usuInvitados = scaner.nextInt();
        System.out.println("|-------------------------------------------------------------------------------------------|");
    }

    private void comprar() {
        String selecU;
        if (salaU.isEmpty()) {
            obtener();
        } else {
            System.out.println("YA TIENE ASIENTOS SELECCIONADOS");
            System.out.println("|-------------------------------------------------------------------------------------------|");
            System.out.println("   PELICULA: " + rooms.get(salaSelecU).getMovie().getTitle());
            rooms.get(salaSelecU).mostrar();
            System.out.println("|-------------------------------------------------------------------------------------------|");
            System.out.print(", QUIERE CONSERVARLOS? (Si/No): ");
            selecU = scaner.next().toLowerCase();
            switch (selecU.charAt(0)) {
                case 'n':
                    for (String aux : salaU) {
                        desocuparAsientos(aux, salaSelecU);
                    }
                    salaU.clear();
                    obtener();
                    break;
                case 's':
                    System.out.println("");
                    break;
                default:
                    System.out.println("RESPUESTA NO IDENTIFICADA");
                    break;
            }
        }
    }

    //OBTENER ASIENTOS
    private void obtener() {
        int opcU;
        String asientoU, selecU;

        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.print("     ELIJA UNA SALA: ");
        salaSelecU = scaner.nextInt();
        //PRIMERO COMPRUEBA SI NO ES APTO PARA LA PELI
        if (usuario.getAge() < rooms.get(salaSelecU).getMovie().getAge()) {
            System.out.println("    LO SENTIMOS, EDAD INSUFICIENTE PARA VER LA PELICULA");
        } else {
            //MOSTRAR ASIENTOS
            
            rooms.get(salaSelecU).mostrar();
            
            System.out.println("|-------------------------------------------------------------------------------------------|");
            System.out.print("    DESEA SELECCIONAR ASIENTOS? (Si/No): ");
            selecU = scaner.next().toLowerCase();
            if (selecU.charAt(0) == 's') {
                if (usuInvitados > 1) {
                    for (int i = 0; i < usuInvitados; i++) {
                        do {
                            System.out.print("    SELECCIONE UN ASIENTO PARA LA PERSONA #" + (i + 1) + ": ");
                            asientoU = scaner.next() + " ";
                            if (reservado(asientoU, salaSelecU)) {
                                System.out.println("-----------------------------------");
                                System.out.println("ASIENTO OCUPADO, INTENTELO DE NUEVO");
                                System.out.println("-----------------------------------");
                            }
                        } while (reservado(asientoU, salaSelecU));
                        ocuparAsientos(asientoU, salaSelecU);
                        
                    }
                } else {

                    do {
                        System.out.print("    SELECCIONE SU ASIENTO: ");
                        asientoU = scaner.next() + " ";
                        if (reservado(asientoU, salaSelecU)) {
                            System.out.println("-----------------------------------");
                            System.out.println("ASIENTO OCUPADO, INTENTELO DE NUEVO");
                            System.out.println("-----------------------------------");
                        }
                    } while (reservado(asientoU, salaSelecU));
                    ocuparAsientos(asientoU, salaSelecU);
                    
                }
            }

        }

    }

    // VERIFICAR SI EL ASIENTO QUE ESCOGE EL USUARIO YA ESTA OCUPADO
    private boolean reservado(String seat, int opc) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                if (rooms.get(opc).getAsientos()[i][j].charAt(0) == seat.charAt(0)
                        && rooms.get(opc).getAsientos()[i][j].charAt(1) == seat.charAt(1)
                        && rooms.get(opc).getAsientos()[i][j].charAt(2) == 'X') {
                    return true;
                }

            }
        }

        return false;
    }

    //CUANDO EL USUARIO YA ELIJE UN/UNOS ASIENTO/S
    private void ocuparAsientos(String seat, int opc) {
        for (Map.Entry<Integer, Sala> aux : rooms.entrySet()) {
            if (aux.getKey() == opc) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (aux.getValue().getAsientos()[i][j].charAt(0) == seat.charAt(0)
                                && aux.getValue().getAsientos()[i][j].charAt(1) == seat.charAt(1)) {
                            StringBuilder asientos = new StringBuilder(aux.getValue().getAsientos()[i][j]);
                            salaU.add(seat);
                            asientos.setCharAt(2, 'X'); // Cambiar el carácter a 'X' (o cualquier otro carácter deseado)
                            aux.getValue().getAsientos()[i][j] = asientos.toString();
                            rooms.entrySet().contains(aux);

                        }

                    }
                }
            }
        }

    }

    //SI EL USUARIO DESEA CAMBIAR SE ASIENTOS
    private void desocuparAsientos(String seat, int opc) {
        for (Map.Entry<Integer, Sala> aux : rooms.entrySet()) {
            if (aux.getKey() == opc) {
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 6; j++) {
                        if (aux.getValue().getAsientos()[i][j].charAt(0) == seat.charAt(0)
                                && aux.getValue().getAsientos()[i][j].charAt(1) == seat.charAt(1)) {
                            StringBuilder asientos = new StringBuilder(aux.getValue().getAsientos()[i][j]);
                            asientos.setCharAt(2, ' '); // Cambiar el carácter a 'X' (o cualquier otro carácter deseado)
                            aux.getValue().getAsientos()[i][j] = asientos.toString();
                            rooms.entrySet().contains(aux);

                        }

                    }
                }
            }
        }
    }

    //MOSTRAR LA TABLA DE PELICULAS --------------------------------------------
    private void mostrarPelis() {
        String vNombre = "______________NOMBRE______________",
                vDirector = "_____DIRECTOR_____",
                vDuracion = "_DURACION_", vEdad = "_EDAD MIN_", vPrecio = "_PRECIO_", vSala = "_SALA_";

        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println("|                                         TAQUILLA                                          |");
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println("|" + vNombre + "|" + vDirector + "|" + vDuracion + "|" + vEdad + "|" + vPrecio + "|" + vSala + "|");
        for (Map.Entry<Integer, Sala> aux : rooms.entrySet()) {

            imprimirPeli(aux.getValue().getMovie().getTitle(), vNombre);
            imprimirPeli(aux.getValue().getMovie().getDirector(), vDirector);
            imprimirPeli(aux.getValue().getMovie().getTime(), vDuracion);
            imprimirPeli(String.valueOf(aux.getValue().getMovie().getAge()), vEdad);
            imprimirPeli(String.valueOf(aux.getValue().getMovie().getCash()), vPrecio);
            imprimirPeli(String.valueOf(aux.getKey()), vSala);
            System.out.print("|");
            System.out.println("");
        }
        System.out.println("|-------------------------------------------------------------------------------------------|");
    }

    //METODO PARA IMPRIMIR UNA CASILLA -----------------------------------------
    private void imprimirPeli(String nombre, String variable) {
        int tamanio;
        String vAux;
        System.out.print("|");

        vAux = nombre;
        tamanio = vAux.length();

        if (tamanio % 2 == 0) {
            for (int i = 0; i < (variable.length() - tamanio) / 2; i++) {
                System.out.print(" ");
            }
            System.out.print(vAux);
            for (int i = 0; i < (variable.length() - tamanio) / 2; i++) {
                System.out.print(" ");
            }
        } else {
            tamanio--;
            for (int i = 0; i < (variable.length() - tamanio) / 2; i++) {
                System.out.print(" ");
            }
            System.out.print(vAux);
            for (int i = 0; i < (variable.length() - tamanio - 2) / 2; i++) {
                System.out.print(" ");
            }
        }
    }

    // LLENAR LOS ASIENTOS CON 'X' ---------------------------------------------
    private void llenarSala() {

        boolean bandera;

        for (Map.Entry<Integer, Sala> aux : rooms.entrySet()) {
            // genera posiciones random
            int fila = (int) (Math.random() * 8);
            int columna = (int) (Math.random() * 6);
            //FOR PARA RECORRER TANTAS VECES PARA OCUPAR LOS ASIENTOS CON UNA X
            for (int i = 0; i < (10); i++) {
                //BOOLEANO PARA RECONOCER SI ENTRA EN EL IF, SE INICIALIZA EN FALSE CADA QUE ITERA
                bandera = false;
                do {
                    //COMPARA SI EL ULTIMO CARACTER ES UN ESPACIO EN BLANCO
                    if (aux.getValue().getAsientos()[fila][columna].charAt(2) == ' ') {
                        bandera = true;
                        StringBuilder asientos = new StringBuilder(aux.getValue().getAsientos()[fila][columna]);
                        asientos.setCharAt(2, 'X'); // Cambiar el carácter a 'X' (o cualquier otro carácter deseado)
                        aux.getValue().getAsientos()[fila][columna] = asientos.toString();
                        rooms.entrySet().contains(aux);

                    } else {
                        //CASO CONTRARIO VUELVE A GENERAR UN NUMERO ALEATORIO DE FILAS Y COLUMNAS
                        fila = (int) (Math.random() * 8);
                        columna = (int) (Math.random() * 6);
                    }
                } while (!bandera);
            }

        }

    }
}
