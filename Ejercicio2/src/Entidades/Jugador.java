/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author irina
 */
public class Jugador {
    /*
    Clase Jugador: esta clase posee los siguientes atributos: id (representa el número del
    jugador), nombre (Empezara con Jugador más su ID, “Jugador 1” por ejemplo) y mojado (indica
    si está mojado o no el jugador). El número de jugadores será decidido por el usuario, pero
    debe ser entre 1 y 6. Si no está en este rango, por defecto será 6.
    */
    private int id;
    private String nombreJ;
    private boolean mojado;

    public Jugador() {
    }

    public Jugador(int id, String nombreJ, boolean mojado) {
        this.id = id;
        this.nombreJ = id + " " +nombreJ;
        this.mojado = mojado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreJ() {
        return nombreJ;
    }

    public void setNombreJ(String nombreJ) {
        this.nombreJ = nombreJ;
    }

    public boolean isMojado() {
        return mojado;
    }

    public void setMojado(boolean mojado) {
        this.mojado = mojado;
    }
    
    /*
    • disparo(Revolver r): el método, recibe el revolver de agua y llama a los métodos de
        mojar() y siguienteChorro() de Revolver. El jugador se apunta, aprieta el gatillo y si el
        revolver tira el agua, el jugador se moja. El atributo mojado pasa a false y el método
        devuelve true, sino false.
    */
    
    public boolean disparo(RevolverAgua r){
        mojado = r.mojar();
        
        r.siguienteChorro();
        
        return mojado;
    }
}
