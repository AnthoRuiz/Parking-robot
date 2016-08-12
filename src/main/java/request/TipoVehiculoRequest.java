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
public class TipoVehiculoRequest {
    
    String tipoVehiculo;
    String celdas;
    String total;
    String tarifa;

    public TipoVehiculoRequest(String tipoVehiculo, String celdas, String total, String tarifa) {
        this.tipoVehiculo = tipoVehiculo;
        this.celdas = celdas;
        this.total = total;
        this.tarifa = tarifa;
    }
    
    public TipoVehiculoRequest() {
        this.tipoVehiculo = null;
        this.celdas = null;
        this.total = null;
        this.tarifa = null;
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

    public String getTarifa() {
        return tarifa;
    }

    public void setTarifa(String tarifa) {
        this.tarifa = tarifa;
    }

    @Override
    public String toString() {
        return "TipoVehiculoRequest{" + "tipoVehiculo=" + tipoVehiculo + ", celdas=" + celdas + ", total=" + total + ", tarifa=" + tarifa + '}';
    }
}
