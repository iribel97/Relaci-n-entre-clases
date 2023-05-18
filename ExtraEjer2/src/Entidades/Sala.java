/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author irina
 */
public class Sala {

    Pelicula movie = new Pelicula();
    private String asientos[][] = new String[8][6];
    private int cont = 8;

    public Sala(Pelicula movie) {
        this.movie = movie;
        this.asientos = crearSala();
    }

    public String[][] getAsientos() {
        return asientos;
    }

    public void setAsientos(String[][] asientos) {
        this.asientos = asientos;
    }

    public Pelicula getMovie() {
        return movie;
    }

    public void setMovie(Pelicula movie) {
        this.movie = movie;
    }

    public String[][] crearSala() {
        String asientos2[][] = new String[8][6];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 6; j++) {
                switch (j) {
                    case 0:
                        asientos2[i][j] = (cont) + "A ";
                        break;
                    case 1:
                        asientos2[i][j] = (cont) + "B ";
                        break;
                    case 2:
                        asientos2[i][j] = (cont) + "C ";
                        break;
                    case 3:
                        asientos2[i][j] = (cont) + "D ";
                        break;
                    case 4:
                        asientos2[i][j] = (cont) + "E ";
                        break;
                    case 5:
                        asientos2[i][j] = (cont) + "F ";
                        break;

                }
            }
            cont--;
        }
        return asientos2;
    }

    public void mostrar() {
        System.out.println("|***********************|");
        System.out.println("|        PANTALLA       |");
        System.out.println("|***********************|");
        for (int i = 0; i < 8; i++) {
            System.out.print("|");
            for (int j = 0; j < 6; j++) {
                System.out.print(asientos[i][j]);
                System.out.print("|");
            }
            System.out.println("");
        }
        System.out.println("|***********************|");
        System.out.println(" 'X' -> Ocupados, ' '-> Disponibles");
    }
}
