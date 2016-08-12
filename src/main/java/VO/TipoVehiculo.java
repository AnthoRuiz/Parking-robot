/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package VO;

import java.util.Objects;

/**
 *
 * @author Jarvis
 */
public class TipoVehiculo {
    private String nombre;
    private int capacidad;
    private String tarifa;
    private int disp;
    
    public TipoVehiculo(String nombre, int capacidad, String tarifa, int disp) {
        this.nombre = nombre;
        this.capacidad = capacidad;
        this.tarifa = tarifa;
        this.disp = disp;
    }
    
    public TipoVehiculo() {
        this.nombre = null;
        this.capacidad = 0;
        this.tarifa = null;
        this.disp = 0;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public int getCapacidad() {
        return capacidad;
    }
    
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public String getTarifa() {
        return tarifa;
    }
    
    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }
    
    public int getDisp() {
        return disp;
    }
    
    public void setDisp(int disp) {
        this.disp = disp;
    }
    
    @Override
    public String toString() {
        return "TipoVehiculo{" + "nombre=" + nombre + ", capacidad=" + capacidad + ", tarifa=" + tarifa + ", disp=" + disp + '}';
    }
}
