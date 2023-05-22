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
public class Poliza {
    
    /*
    *los datos tanto de un
    *vehículo, como los datos de un solo cliente.
    */
    
    private Vehiculo vehiculo = new Vehiculo();
    private Cliente cliente = new Cliente();
    
    /*
    *número de póliza, fecha de inicio y fin de la póliza, cantidad de cuotas, 
    *forma de pago, monto total
    *asegurado, incluye granizo, monto máximo granizo, tipo de cobertura (total, contra
    *terceros, etc.).
    */
    private int numPoliza, cantCuotas;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private String formaPago, tipoCobertura;
    private double montoTotalA, montoMaximG;
    private boolean incluyeG;

    public Poliza() {
    }

    public Poliza(int numPoliza, int cantCuotas, LocalDate fechaInicio, LocalDate fechaFin, String formaPago, String tipoCobertura, double montoTotalA, double montoMaximG, boolean incluyeG) {
        this.numPoliza = numPoliza;
        this.cantCuotas = cantCuotas;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.formaPago = formaPago;
        this.tipoCobertura = tipoCobertura;
        this.montoTotalA = montoTotalA;
        this.montoMaximG = montoMaximG;
        this.incluyeG = incluyeG;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(Vehiculo vehiculo) {
        this.vehiculo = vehiculo;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getNumPoliza() {
        return numPoliza;
    }

    public void setNumPoliza(int numPoliza) {
        this.numPoliza = numPoliza;
    }

    public int getCantCuotas() {
        return cantCuotas;
    }

    public void setCantCuotas(int cantCuotas) {
        this.cantCuotas = cantCuotas;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDate fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDate fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getFormaPago() {
        return formaPago;
    }

    public void setFormaPago(String formaPago) {
        this.formaPago = formaPago;
    }

    public String getTipoCobertura() {
        return tipoCobertura;
    }

    public void setTipoCobertura(String tipoCobertura) {
        this.tipoCobertura = tipoCobertura;
    }

    public double getMontoTotalA() {
        return montoTotalA;
    }

    public void setMontoTotalA(double montoTotalA) {
        this.montoTotalA = montoTotalA;
    }

    public double getMontoMaximG() {
        return montoMaximG;
    }

    public void setMontoMaximG(double montoMaximG) {
        this.montoMaximG = montoMaximG;
    }

    public boolean isIncluyeG() {
        return incluyeG;
    }

    public void setIncluyeG(boolean incluyeG) {
        this.incluyeG = incluyeG;
    }
    
}
