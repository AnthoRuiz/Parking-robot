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
    private String horario;
    private String direccion;
    private String telefono;
    private String latitud;
    private String longitud;

    public Parking(String nombre, String tarifa, String horario, String direccion, String telefono, String latitud, String longitud) {
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.horario = horario;
        this.direccion = direccion;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
    }
    
        public Parking() {
        this.nombre = null;
        this.tarifa = null;
        this.horario = null;
        this.direccion = null;
        this.telefono = null;
        this.latitud = null;
        this.longitud = null;
    }

    @Override
    public String toString() {
        return "Parking{" + "nombre=" + nombre + ", tarifa=" + tarifa + ", horario=" + horario + ", direccion=" + direccion + ", telefono=" + telefono + ", latitud=" + latitud + ", longitud=" + longitud + '}';
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 73 * hash + Objects.hashCode(this.nombre);
        hash = 73 * hash + Objects.hashCode(this.direccion);
        hash = 73 * hash + Objects.hashCode(this.latitud);
        hash = 73 * hash + Objects.hashCode(this.longitud);
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
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
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

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
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
        
        
    
    
    
    
    
}
