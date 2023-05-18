/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Servicios;

import Entidades.Pelicula;
import java.util.ArrayList;

/**
 *
 * @author irina
 */
public class ServPeli {
    private ArrayList<Pelicula> movies = new ArrayList();

    public ServPeli() {
    }
    
    public void addMovie(){
        movies.add(new Pelicula("Guardianes de la Galaxia Vol 3", "James Gunn", 13, "2h29m", 3.5));
        movies.add(new Pelicula("Rapidos y Furiosos 10", "Louis Leterrier", 15, "2h21m", 4.25));
        movies.add(new Pelicula("GRock Dog 3: Rockeando Juntos", "Anthony Bell", 5, "1h30m", 2.5));
        movies.add(new Pelicula("Agente Fortune: el gran engaño", "Guy Ritchie", 16, "1h54m", 4.25));
    }

    public ArrayList<Pelicula> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Pelicula> movies) {
        this.movies = movies;
    }
    
}
