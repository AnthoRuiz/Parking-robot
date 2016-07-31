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

    public TipoVehiculo(String nombre, int capacidad) {
        this.nombre = nombre;
        this.capacidad = capacidad;
    }
    
    public TipoVehiculo() {
        this.nombre = null;
        this.capacidad = 0;
    }

    @Override
    public String toString() {
        return "TipoVehiculo{" + "nombre=" + nombre + ", capacidad=" + capacidad + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TipoVehiculo other = (TipoVehiculo) obj;
        if (this.capacidad != other.capacidad) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
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
    
    

    
    
}
