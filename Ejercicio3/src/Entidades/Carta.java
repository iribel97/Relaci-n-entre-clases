/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author irina
 */
public class Carta {
    /*
    *Esta clase debe contener un método toString() que retorne el número de carta y el palo.
    */
    private int numCarta;
    private String palo;

    public Carta() {
    }

    public Carta(int numCarta, String palo) {
        this.numCarta = numCarta;
        this.palo = palo;
    }

    public int getNumCarta() {
        return numCarta;
    }

    public void setNumCarta(int numCarta) {
        this.numCarta = numCarta;
    }

    public String getPalo() {
        return palo;
    }

    public void setPalo(String palo) {
        this.palo = palo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("|").append(numCarta);
        sb.append("   de   ").append(palo);
        sb.append("|");
        return sb.toString();
    }
    
}
