/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

/**
 *
 * @author irina
 */
public class RevolverAgua {
    /*
    Clase Revolver de agua: esta clase posee los siguientes atributos: posición actual (posición
    del tambor que se dispara, puede que esté el agua o no) y posición agua (la posición del
    tambor donde se encuentra el agua). Estas dos posiciones, se generarán aleatoriamente.
    */
    private int posAct, posAgua;

    public RevolverAgua() {
    }

    public RevolverAgua(int posAct, int posAgua) {
        this.posAct = posAct;
        this.posAgua = posAgua;
    }

   
    
    /*
    Métodos:
        • llenarRevolver(): le pone los valores de posición actual y de posición del agua. Los valores
            deben ser aleatorios.
        • mojar(): devuelve true si la posición del agua coincide con la posición actual
        • siguienteChorro(): cambia a la siguiente posición del tambor
        • toString(): muestra información del revolver (posición actual y donde está el agua)
    */
    public void llenarRevolver(){
        posAct = (int)(Math.random()*6)+1;
        posAgua = (int)(Math.random()*6)+1;
    }
    
    public boolean mojar(){
        return posAct == posAgua;
    }
    
    public void siguienteChorro(){
        if(posAct > 6){
            posAct = 1;
        }else{
            posAct ++;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Revolver de Agua{");
        sb.append("\n Posicion Actual=").append(posAct);
        sb.append("\n  Posicion del Agua=").append(posAgua);
        sb.append('}');
        return sb.toString();
    }
    
    
}
