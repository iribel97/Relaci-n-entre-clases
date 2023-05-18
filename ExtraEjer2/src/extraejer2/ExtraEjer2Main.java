/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package extraejer2;

import Entidades.Cine;
import Entidades.Sala;

/**
 *
 * @author irina
 */
public class ExtraEjer2Main {
    /*
    *Nos piden hacer un programa sobre un Cine, que tiene una sala con un conjunto de asientos
    *(8 filas por 6 columnas). De Cine nos interesa conocer la película que se está reproduciendo, la
    *sala con los espectadores y el precio de la entrada. Luego, de las películas nos interesa saber
    *el título, duración, edad mínima y director. Por último, del espectador, nos interesa saber su
    *nombre, edad y el dinero que tiene disponible.
    *Para representar la sala con los espectadores vamos a utilizar una matriz. Los asientos son
    *etiquetados por una letra y un número la fila A1 empieza al final del mapa como se muestra en
    *la tabla. También deberemos saber si el asiento está ocupado por un espectador o no, si esta
    *ocupado se muestra una X, sino un espacio vacío.
    *Se debe realizar una pequeña simulación, en la que se generen muchos espectadores y se los
    *ubique en los asientos aleatoriamente (no se puede ubicar un espectador donde ya este
    *ocupado el asiento).
    *Los espectadores serán ubicados de uno en uno y para ubicarlos tener en cuenta que sólo se
    *podrá sentar a un espectador si tiene el dinero suficiente para pagar la entrada, si hay espacio
    *libre en la sala y si tiene la edad requerida para ver la película. En caso de que el asiento este
    *ocupado se le debe buscar uno libre.
    *Al final del programa deberemos mostrar la tabla, podemos mostrarla con la letra y numero de
    *cada asiento o solo las X y espacios vacíos.
    */
    public static void main(String[] args) {
        // TODO code application logic here
        
        
        Cine cine= new Cine();
        
        cine.menu();
        
    }
    
}
