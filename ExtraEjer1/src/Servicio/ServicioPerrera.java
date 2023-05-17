/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicio;

import Entidades.Persona;
import EnumEntidades.Perrera;
import java.util.Scanner;

/**
 *
 * @author irina
 */
public class ServicioPerrera {

    Scanner scaner = new Scanner(System.in);
    //CREAR PERSONAS
    Persona per = new Persona();

    private void crearPersonas() {
        Persona person =new Persona();
        System.out.print("NOMBRE: ");
        person.setNombre(scaner.next());
        System.out.print("APELLIDO: ");
        person.setApellido(scaner.next());
        System.out.print("EDAD: ");
        person.setEdad(scaner.nextInt());
        System.out.print("ID: ");
        person.setDocumento(scaner.nextInt());

        per.setPersons(
                new Persona(person.getNombre(), person.getApellido(),
                        person.getEdad(), person.getDocumento())
        );

    }

    private void mostrarMascotas() {
        String vNombre = "___NOMBRE___", vRaza = "_______RAZA_______",
                vTamanio = "___TAMAÑO___", vEdad = "____EDAD____";
        System.out.println("___________________________________________________________");
        System.out.println("                          MASCOTAS                         ");
        System.out.println("___________________________________________________________");
        System.out.println("|" + vNombre + "|" + vRaza + "|" + vTamanio + "|" + vEdad + "|");

        for (Perrera aux : Perrera.values()) {

            imprimirMascota(aux.name(), vNombre);
            imprimirMascota(aux.getRaza(), vRaza);
            imprimirMascota(aux.getTamanio(), vTamanio);
            imprimirMascota(String.valueOf(aux.getEdad()), vEdad);
            System.out.print("|");
            System.out.println("");
        }
        System.out.println("___________________________________________________________");

    }

    private void imprimirMascota(String nombre, String variable) {
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

    public void adoptar() {

        boolean verificarP = false;
        String nomMas;

        if (!per.getPersons().isEmpty()) {

            System.out.println("---------------------------------------------------------");
            System.out.print("INGRESE SU ID: ");
            int idU = scaner.nextInt();

            for (Persona aux : per.getPersons()) {

                if (aux.getDocumento() == idU) {
                    verificarP = true;
                    System.out.println("---------------------------------------------------------");
                    System.out.println("    BIENVENIDO/A " + aux.getNombre() + ", VAMOS A ADOPTAR UNA MASCOTA");
                    System.out.println("---------------------------------------------------------");
                    mostrarMascotas();

                    System.out.println("---------------------------------------------------------");
                    System.out.print("   ESCRIBA NOMBRE DE LA MASCOTA: ");
                    nomMas = scaner.next();
                    System.out.println(verificarMascota(nomMas));
                    if (verificarMascota(nomMas)) {
                        System.out.println("MASCOTA ADOPTADA");
                    } else {
                        System.out.println("MUCHAS GRACIAS POR ADOPTAR A " + nomMas.toUpperCase());
                        for (Perrera dog : Perrera.values()) {
                            if (dog.name().equalsIgnoreCase(nomMas)) {
                                per.setPerros(dog);
                            }
                        }
                    }

                }
            }
            if (!verificarP) {
                System.out.println("---------------------------------------------------------");
                System.out.println("LO SENTIMOS, NO TE ENCUENTRAS REGISTRADO");
                System.out.println("---------------------------------------------------------");
            }
        } else {
            System.out.println("---------------------------------------------------------");
            System.out.println("AUN NO EXISTEN PERSONAS REGISTRADAS");
            System.out.println("---------------------------------------------------------");
        }

    }

    private boolean verificarMascota(String nombreMascota) {

        for (Persona aux : per.getPersons()) {
            if (!aux.getPerros().isEmpty()) {
                for (Perrera aux1 : aux.getPerros()) {
                    if (aux1.name().equalsIgnoreCase(nombreMascota)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void menu() {
        int opcU;
        do {
            System.out.println("---------------------------------------------------------");
            System.out.println("                           MENU                          ");
            System.out.println("---------------------------------------------------------");
            System.out.println("   1.- REGISTRARSE");
            System.out.println("   2.- ADOPTAR MASCOTA");
            System.out.println("   3.- MASCOTAS ADOPTADAS");
            System.out.println("   4.- SALIR");
            System.out.println("---------------------------------------------------------");
            System.out.print("   SELECCIONE UNA OPCION: ");
            opcU = scaner.nextInt();
            switch (opcU) {
                case 1:
                    crearPersonas();
                    break;
                case 2:
                    adoptar();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("---------------------------------------------------------");
                    System.out.println("OPCION MAL INGRESADA, INTENTELO DE NUEVO");
                    System.out.println("---------------------------------------------------------");
            }
        } while (opcU != 4);
    }

}
