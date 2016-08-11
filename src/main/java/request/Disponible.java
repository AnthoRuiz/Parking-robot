/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package request;

/**
 *
 * @author Jarvis
 */
public class Disponible {
    
    String tipoVehiculo;
    String celdas;
    String total;

        public Disponible() {
        this.tipoVehiculo = null;
        this.celdas = null;
        this.total = null;
    }
    
    public Disponible(String tipoVehiculo, String celdas, String total) {
        this.tipoVehiculo = tipoVehiculo;
        this.celdas = celdas;
        this.total = total;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public String getCeldas() {
        return celdas;
    }

    public void setCeldas(String celdas) {
        this.celdas = celdas;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
    
    
    
}
