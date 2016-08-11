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
public class Parking {
    
    private String nombre;
    private String tarifa;
    private String horarioInicio;
    private String horarioFin;
    private String direccion;
    private String telefono;
    private String latitud;
    private String longitud;

    public Parking(String nombre, String tarifa, String horarioInicio, String horarioFin, String direccion, String telefono, String latitud, String longitud) {
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.horarioInicio = horarioInicio;
        this.horarioFin = horarioFin;
        this.direccion = direccion;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    
        public Parking() {
        this.nombre = null;
        this.tarifa = null;
        this.horarioInicio = null;
        this.horarioFin = null;
        this.direccion = null;
        this.telefono = null;
        this.latitud = null;
        this.longitud = null;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.latitud);
        hash = 29 * hash + Objects.hashCode(this.longitud);
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
        final Parking other = (Parking) obj;
        if (!Objects.equals(this.latitud, other.latitud)) {
            return false;
        }
        if (!Objects.equals(this.longitud, other.longitud)) {
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

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    public String getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(String horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public String getHorarioFin() {
        return horarioFin;
    }

    public void setHorarioFin(String horarioFin) {
        this.horarioFin = horarioFin;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    @Override
    public String toString() {
        return "Parking{" + "nombre=" + nombre + ", tarifa=" + tarifa + ", horarioInicio=" + horarioInicio + ", horarioFin=" + horarioFin + ", direccion=" + direccion + ", telefono=" + telefono + ", latitud=" + latitud + ", longitud=" + longitud + '}';
    }
        
}
