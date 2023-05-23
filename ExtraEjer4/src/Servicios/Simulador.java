/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Entidades.Alumno;
import Entidades.Voto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author irina
 */
public class Simulador {

    private ArrayList<Alumno> alumnos = new ArrayList();
    private ArrayList<Voto> votaciones = new ArrayList();

    public Simulador() {
        alumnos = generarAlumnos();
    }

    /*
    *   • La clase Simulador debe tener un método que genere un listado de alumnos manera
    *       aleatoria y lo retorne. Las combinaciones de nombre y apellido deben ser generadas de
    *       manera aleatoria. Nota: usar listas de tipo String para generar los nombres y los apellidos.
     */
    private ArrayList<Alumno> generarAlumnos() {
        alumnos.add(new Alumno("Irina Mabel Ochoa Ramirez", 0));
        alumnos.add(new Alumno("Angel Josmanny Peñafiel Mantuano", 0));
        alumnos.add(new Alumno("Marina Nayeli Gaston Vera", 0));
        alumnos.add(new Alumno("Celi Katherine Cobos Chulli", 0));
        alumnos.add(new Alumno("Emmanuel Aldahir Anastacio Peñafiel", 0));
        alumnos.add(new Alumno("Erick Josue Montes", 0));
        alumnos.add(new Alumno("Rodney Alberto Llanos Sanchez", 0));
        alumnos.add(new Alumno("Nury Maoly Jungal Mora", 0));
        alumnos.add(new Alumno("Cindy Elizabeth Limones Ricaurte", 0));
        alumnos.add(new Alumno("Jorge Alejandro Teran Ocaña", 0));
        alumnos.add(new Alumno("Jose Adrian Cabrera Endara", 0));
        alumnos.add(new Alumno("Dayanna Lidilia Cuadro Chang", 0));

        generadorDNI();
        return alumnos;
    }

    /*
    *   • Ahora hacer un generador de combinaciones de DNI posibles, deben estar dentro de un
    *       rango real de números de documentos. Y agregar a los alumnos su DNI. Este método
    *       debe retornar la lista de dnis.
     */
    private void generadorDNI() {
        boolean bandera;
        String dniG;
        int cont = 0;
        for (Alumno aux : alumnos) {
            bandera = false;
            do {
                dniG = (int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + ""
                        + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + ""
                        + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + ""
                        + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10) + ""
                        + (int) (Math.random() * 10) + "" + (int) (Math.random() * 10);
                if (cont == 0) {
                    bandera = true;
                    cont++;
                } else {
                    for (Alumno aux1 : alumnos) {
                        if (!aux1.getDni().isEmpty()) {
                            if (!aux1.getDni().equals(dniG)) {
                                bandera = true;
                                break;
                            }
                        }
                    }
                }

            } while (!bandera);
            aux.setDni(dniG);
        }
    }

    //IMPRIMIR LISTA
    private void imprimirAlumno(String nombre, String variable) {
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

    public void imprimirAlumnos() {
        String vNombre = "__________________NOMBRES_________________", vDNI = "______DNI_______",
                vPulsos = "______VOTOS_______";
        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|                                 INTEGRANTES                                  |");
        System.out.println("|------------------------------------------------------------------------------|");
        System.out.println("|" + vNombre + "|" + vDNI + "|" + vPulsos + "|");
        for (Alumno aux : alumnos) {
            imprimirAlumno(aux.getNombreCom(), vNombre);
            imprimirAlumno(aux.getDni(), vDNI);
            imprimirAlumno(String.valueOf(aux.getCantVotos()), vPulsos);
            System.out.println("|");
        }
        System.out.println("|__________________________________________|________________|__________________|");

    }

    /*
    *   • Crearemos un método votación en la clase Simulador que, recibe el listado de alumnos y
    *       para cada alumno genera tres votos de manera aleatoria. En este método debemos
    *       guardar a el alumno que vota, a los alumnos a los que votó y sumarle uno a la cantidad de
    *       votos a cada alumno que reciba un voto, que es un atributo de la clase Alumno.
    *       Tener en cuenta que un alumno no puede votarse a sí mismo o votar más de una vez al
    *       mismo alumno. Utilizar un hashset para resolver esto.
     */
    public void votar() {
        Scanner scaner = new Scanner(System.in);
        String id;

        Alumno[] studentV = new Alumno[3];

        //AGREGAMOS LOS ALUMNOS QUE VAN A VOTAR
        for (Alumno votante : alumnos) {

            System.out.println("|------------------------------------------------------------------------------|");
            System.out.printf("|         HOLA, %35s VAMOS A DAR PULSOS         |\n", votante.getNombreCom());
            System.out.println("|------------------------------------------------------------------------------|");
            imprimirAlumnos();

            for (int i = 0; i < 3; i++) {
                System.out.println("|------------------------------------------------------------------------------|");
                do {
                    System.out.print("Ingresa el ID del " + (i + 1) + "o participante: ");
                    id = scaner.next();
                    if (id.equals(votante.getDni())) {
                        System.out.println("NO SE PUEDE VOTAR PARA UNO MISMO");
                    }
                } while (id.equals(votante.getDni()));

//                System.out.println(id);
                for (Alumno persona : alumnos) {
                    if (id.equals(persona.getDni())) {
                        persona.setCantVotos(persona.getCantVotos() + 1);
                        studentV[i] = persona;

                    }
                }

            }

            votaciones.add(new Voto(votante, new ArrayList(Arrays.asList(studentV))));
        }
    }

    /*
    *   • Se debe crear un método que muestre a cada Alumno con su cantidad de votos y cuales
    *       fueron sus 3 votos.
     */
    public void mostrarV() {
        String vNombre = "__________________NOMBRES_________________",
                vPulsos = "______VOTOS_______",
                vVotados = "__________________VOTADOS_________________";
        int cantEspacios = vNombre.length() + vPulsos.length() + 1;

        int cont;

        System.out.println("|" + vNombre + "|" + vPulsos + "|" + vVotados + "|");
        for (Voto votante : votaciones) {
            cont = 0;
            imprimirAlumno(votante.getAlumno().getNombreCom(), vNombre);
            imprimirAlumno(String.valueOf(votante.getAlumno().getCantVotos()), vPulsos);
            for (Alumno votado : votante.getAlumnosV()) {
                if (cont > 0) {
                    System.out.print("|");
                    System.out.print(" ".repeat(cantEspacios));
                }
                imprimirAlumno(votado.getNombreCom(), vVotados);
                cont++;
                System.out.println("|");
            }
            System.out.println("|__________________NOMBRES_________________|______VOTOS_______|__________________VOTADOS_________________|");
            System.out.println("|__________________________________________|__________________|__________________________________________|");

        }
    }

    /*
    *   • Se deben crear 5 facilitadores con los 5 primeros alumnos votados y se deben crear 5
    *       facilitadores suplentes con los 5 segundos alumnos más votados. A continuación, mostrar
    *       los 5 facilitadores y los 5 facilitadores suplentes.
     */
    public void facilitador() {
        String vFacilitador = "                  FACILITADORES                  ",
                vFacilSuplent = "             FACILITADORES SUPLENTES             ";
        // Comparador personalizado para ordenar por duración de mayor a menor
        Comparator<Voto> comparadorCantV = new Comparator<Voto>() {
            @Override
            public int compare(Voto p1, Voto p2) {
                return Integer.compare(p2.getAlumno().getCantVotos(), p1.getAlumno().getCantVotos());
            }
        };
        // Ordenar la lista de alumnos usando el comparador
        Collections.sort(votaciones, comparadorCantV);
        System.out.println("|-------------------------------------------------|");
        System.out.println("|"+vFacilitador+"");
        System.out.println("|-------------------------------------------------|");
        for (int i = 0; i < 5; i++) {
            imprimirAlumno(votaciones.get(i).getAlumno().getNombreCom(), vFacilitador);
            System.out.println("|");
        }
        System.out.println("|-------------------------------------------------|");
        System.out.println("|             FACILITADORES SUPLENTES             |");
        System.out.println("|-------------------------------------------------|");
        for (int i = 5; i < 10; i++) {
            imprimirAlumno(votaciones.get(i).getAlumno().getNombreCom(), vFacilitador);
            System.out.println("|");
        }
    }
}
