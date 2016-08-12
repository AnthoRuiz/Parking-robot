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
    
    int id;
    String nombre;
    String horario;
    String direccion;
    String telefono;
    String latitud;
    String longitud;
    ArrayList<TipoVehiculoRequest> tipoVehiculoList;
    
    public ParkingRequest(int id, String nombre, String horario, String direccion, String telefono, String latitud, String longitud, ArrayList<TipoVehiculoRequest> tipoVehiculoList) {
        this.id = id;
        this.nombre = nombre;
        this.horario = horario;
        this.direccion = direccion;
        this.telefono = telefono;
        this.latitud = latitud;
        this.longitud = longitud;
        this.tipoVehiculoList = tipoVehiculoList;
    }
    
    public ParkingRequest() {
        this.id = 0;
        this.nombre = null;
        this.horario = null;
        this.direccion = null;
        this.telefono = null;
        this.latitud = null;
        this.longitud = null;
        this.tipoVehiculoList = null;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    
    public ArrayList<TipoVehiculoRequest> getTipoVehiculoList() {
        return tipoVehiculoList;
    }
    
    public void setTipoVehiculoList(ArrayList<TipoVehiculoRequest> tipoVehiculoList) {
        this.tipoVehiculoList = tipoVehiculoList;
    }
    
    @Override
    public String toString() {
        return "ParkingRequest{" + "id=" + id + ", nombre=" + nombre + ", horario=" + horario + ", direccion=" + direccion + ", telefono=" + telefono + ", latitud=" + latitud + ", longitud=" + longitud + ", tipoVehiculoList=" + tipoVehiculoList + '}';
    }
}

