/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package request;

import java.util.ArrayList;

/**
 *
 * @author Jarvis
 */
public class ParkingRequest {
    
    String nombre;
    String tarifa;
    String horario;
    String direccion;
    String telefono;
    String latitud;
    String longitud;
    ArrayList<Disponible> dispList;
    
    public ParkingRequest(String nombre, String tarifa, String horario, String direccion, String telefono, String latitud, String longitud, ArrayList<Disponible> dispList) {
        this.nombre = nombre;
        this.tarifa = tarifa;
        this.horario = horario;
        this.direccion = direccion;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
        this.dispList = dispList;
    }
    
        public ParkingRequest() {
        this.nombre = null;
        this.tarifa = null;
        this.horario = null;
        this.direccion = null;
        this.telefono = null;
        this.latitud = null;
        this.longitud = null;
        this.dispList = null;
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

    public ArrayList<Disponible> getDispList() {
        return dispList;
    }

    public void setDispList(ArrayList<Disponible> dispList) {
        this.dispList = dispList;
    }
}

