/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Entidades;

import java.time.LocalDate;

/**
 *
 * @author irina
 */
public class Cuota {
    /*
    *   d. Gestión de cuotas: Se registrarán y podrán consultar las cuotas generadas en cada póliza.
    *       Esas cuotas van a contener la siguiente información: número de cuota, monto total de la
    *       cuota, si está o no pagada, fecha de vencimiento, forma de pago (efectivo, transferencia,
    *       etc.).
    */
    private int numCuota;
    private double montoTotal;
    private boolean pagada;
    private LocalDate fechaVence;
    private String formaPago;
}
