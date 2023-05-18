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

    private double total = 0;

    //POR SI EL USUARIO QUIERE CAMBIAR DE ASIENTO, DEBO DE GUARDAR EL NUMERO DE ASIENTO Y EL NUMERO DE SALA
    ArrayList<String> salaU = new ArrayList();
    private int salaSelecU;

    //booleano para cambiar el asiento:
    private boolean flag;

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
            System.out.println("|    1. COMPRAR O DEVOLVER VOLETOS                                                          |");
            System.out.println("|    2. CAMBIAR DATOS                                                                       |");
            System.out.println("|    3. FACTURA                                                                             |");
            System.out.println("|    4. SALIR                                                                               |");
            System.out.println("|-------------------------------------------------------------------------------------------|");
            if (total != 0) {
                System.out.println(" MONTO A PAGAR $" + total);
            }
            System.out.println("|-------------------------------------------------------------------------------------------|");
            System.out.print("   SELECCIONE UNA: ");
            opcU = scaner.nextInt();
            switch (opcU) {
                case 1:
                    mostrarPelis();
                    comprar();
                    break;
                case 2:
                    cambiarDU();
                    break;
                case 3:
                    if (usuario.getCash()>=total) {
                        factura();
                    }else{
                        System.out.println("   SU SALDO ES INSUFICIENTE PARA COMPRAR UN VOLETO.");
                    }
                    break;
                case 4:
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

    //SELECCIONA LA SALA Y SUS ASIENTOS
    private void comprar() {
        int diferencia;
        String salaElim;
        String selecU;
        if (salaU.isEmpty()) {
            obtener();
        } else {
            System.out.println("YA TIENE ASIENTOS SELECCIONADOS");
            System.out.println("|-------------------------------------------------------------------------------------------|");
            System.out.println("   PELICULA: " + rooms.get(salaSelecU).getMovie().getTitle());
            System.out.print("   ASIENTOS: ");
            for (String seatsAux : salaU) {
                System.out.print(seatsAux);
                System.out.print("    ");
            }
            System.out.println("");
            rooms.get(salaSelecU).mostrar();
            System.out.println("|-------------------------------------------------------------------------------------------|");
            System.out.print("QUIERE CONSERVARLOS? (Si/No): ");
            selecU = scaner.next().toLowerCase();
            switch (selecU.charAt(0)) {
                case 'n':
                    flag = false;
                    for (String aux : salaU) {
                        desocuparAsientos(aux, salaSelecU);
                    }
                    salaU.clear();
                    obtener();
                    break;

                case 's':
                    flag = true;
                    if (salaU.size() == usuInvitados) {

                        System.out.println("LISTO, SE CONSERVO LOS ASIENTOS :) ");

                    } else if (salaU.size() < usuInvitados) {

                        usuInvitados -= salaU.size();
                        obtener();

                    } else {

                        usuInvitados = salaU.size() - usuInvitados;
                        if (usuInvitados == 1) {
                            System.out.print(" QUE ASIENTO DESEA ELIMINAR: ");
                            salaElim = scaner.next() + " ";
                            desocuparAsientos(salaElim, salaSelecU);
                        } else {
                            for (int i = 0; i < usuInvitados; i++) {
                                System.out.print(" INGRESE EL " + (i + 1) + "R ASIENTO A ELIMINAR: ");
                                salaElim = scaner.next() + " ";
                                desocuparAsientos(salaElim, salaSelecU);
                            }
                        }

                    }
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
        if (!flag) {
            do {
                System.out.print("     ELIJA UNA SALA: ");
                salaSelecU = scaner.nextInt();
                if (salaSelecU > servMovie.getMovies().size()) {
                    System.out.println("SALA NO EXISTE, INTENTELO DE NUEVO");
                }
            } while (salaSelecU > servMovie.getMovies().size());
        }

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
                            //GUARDAR EL TOTAL
                            total += aux.getValue().getMovie().getCash();

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
                            total -= aux.getValue().getMovie().getCash();
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

    //CAMBIAR DATOS DEL USUARIO
    private void cambiarDU() {
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println("|    QUE DESEA CAMBIAR:                                                                     |");
        System.out.println("|       1.- NOMBRE                                                                          |");
        System.out.println("|       2.- EDAD                                                                            |");
        System.out.println("|       3.- EFECTIVO                                                                        |");
        System.out.println("|       4.- NUMERO DE ENTRADAS                                                              |");
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.print("   SELECCIONE UNA OPCION: ");
        int opcU = scaner.nextInt();
        System.out.println("|-------------------------------------------------------------------------------------------|");
        switch (opcU) {
            case 1:
                System.out.print("      NOMBRE: ");
                usuario.setName(scaner.nextLine());
                break;
            case 2:
                System.out.print("      EDAD: ");
                usuario.setAge(scaner.nextInt());
                break;
            case 3:
                System.out.print("      EFECTIVO: ");
                usuario.setCash(scaner.nextDouble());
                break;
            case 4:
                System.out.print("      NUMERO DE ENTRADAS: ");
                usuInvitados = scaner.nextInt();
                break;
            default:
                System.out.println("    OPCION NO ENCONTRADA, INTENTELO DE NUEVO");
        }
    }

    //FACTURA ------------------------------------------------------------------
    private void factura() {
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println("|                                   FACTURA #001 001 4563                                   |");
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println("        CLIENTE: " + usuario.getName());
        System.out.println("        PELICULA: " + rooms.get(salaSelecU).getMovie().getTitle());
        System.out.print("        ASIENTOS: ");
        for (String seatsAux : salaU) {
            System.out.print(seatsAux);
            System.out.print("    ");
        }
        System.out.println("");
        System.out.println("        TOTAL A PAGAR: $" + total);
        System.out.println("|-------------------------------------------------------------------------------------------|");
        System.out.println("        CAMBIO: $" + (usuario.getCash()-total));
        System.out.println("|-------------------------------------------------------------------------------------------|");
        
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
